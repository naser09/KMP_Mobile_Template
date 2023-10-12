plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
    id("app.cash.sqldelight")
}

kotlin {
    val ktorVersion = extra["ktor"] as String
    val voyagerVersion = extra["voyagerVersion"] as String
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.animation)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                //serialization
                implementation(libs.kotlinx.serialization.json)
                //coroutine
                implementation(libs.kotlinx.coroutines.core)
                //ktor client
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                //firebase auth
                implementation(libs.firebase.auth)
                //multiplatform setting
                implementation(libs.multiplatform.settings.no.arg)
                //voyeger
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.transitions)
                implementation(libs.voyager.koin)
                //koin
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.coroutine)

                //sqldelight
                implementation(libs.sqldelight.coroutine)
                //kamel image loader   https://github.com/Kamel-Media/Kamel
                implementation(libs.kamel.image)
                //napier log  https://github.com/AAkira/Napier
                implementation(libs.napier)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("com.willowtreeapps.assertk:assertk:0.27.0")
                implementation(kotlin("test"))
                implementation(libs.koin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.activity.compose)
                api(libs.appcompat)
                api(libs.core.ktx)
                //sql driver
                implementation(libs.sqldelight.androiddriver)
                //ktor engine
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation(libs.koin.android)

            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.sqldelight.nativedriver)
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
sqldelight{
    databases{
        create("KMP_DB"){
            packageName.set("com.kmp")
        }
    }
}
tasks.register("makedb"){
    val a = dependsOn("generateCommonMainKMP_DBInterface")
    val b = dependsOn("generateSqlDelightInterface")
    val c = dependsOn("verifyCommonMainKMP_DBMigration")
    val d = dependsOn("verifySqlDelightMigration")
    doLast {
        if (a.didWork && b.didWork && c.didWork && d.didWork){
            println("Database created Successful")
        }
    }
}