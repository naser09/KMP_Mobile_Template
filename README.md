# KMP Mobile Template Project

This is a template project for creating a multiplatform app using Kotlin's Jetbrain Compose and other essential dependencies.
The project is structured to support Android and iOS platforms, making it easier to create cross-platform applications.

## Dependencies

Here are the main dependencies used in this project, categorized by their respective source sets:

### Common Main

- **Jetpack Compose Libraries**:
    - `compose.runtime`: Jetpack Compose runtime library.
    - `compose.foundation`: Jetpack Compose foundation library.
    - `compose.material`: Jetpack Compose material design library.
    - `compose.animation`: Jetpack Compose animation library.
    - `compose.components.resources` (Experimental): Experimental Compose library for components and resources.

- **Kotlin Serialization**:
    - `libs.kotlinx.serialization.json`: Kotlin Serialization library for JSON handling.

- **Coroutines**:
    - `libs.kotlinx.coroutines.core`: Kotlin Coroutines core library for asynchronous programming.

- **Ktor Client**:
    - `io.ktor:ktor-client-core`: Ktor HTTP client core.

- **Firebase Auth**:
    - `libs.firebase.auth`: Firebase Authentication library.

- **Multiplatform Settings**:
    - `libs.multiplatform.settings.no.arg`: Multiplatform settings library.

- **Voyager**:
    - `libs.voyager.navigator`: Voyager Navigator library.
    - `libs.voyager.transitions`: Voyager Transitions library.
    - `libs.voyager.koin`: Voyager Koin integration.

- **Koin**:
    - `libs.koin.core`: Koin Dependency Injection library.

- **Korim**:
    - `com.soywiz.korlibs.korim:korim:4.0.10`: Korim library for graphics and image processing.

### Common Test

- **Testing Libraries**:
    - `com.willowtreeapps.assertk:assertk:0.27.0`: Assertion library.
    - `kotlin.test`: Kotlin testing framework.

- **Koin Test**:
    - `libs.koin.test`: Koin testing support.

### Android Main

- **Android Jetpack Libraries**:
    - `androidx.activity:activity-compose:1.7.2`: Android Activity Compose integration.
    - `androidx.appcompat:appcompat:1.6.1`: Android AppCompat library.
    - `androidx.core:core-ktx:1.12.0`: Android Core KTX library.

- **SQL Driver**:
    - `libs.android.driver`: SQL driver library.

- **Ktor Engine**:
    - `io.ktor:ktor-client-okhttp`: Ktor HTTP client engine using OkHttp.

- **Koin Android**:
    - `libs.koin.android`: Koin Dependency Injection for Android.

### iOS Main

- **Native Driver**:
    - `libs.native.driver`: Native SQL driver library.

- **Ktor Client for iOS**:
    - `io.ktor:ktor-client-darwin`: Ktor HTTP client engine for iOS.

## Getting Started

To use this template, follow these steps:

1. Clone the repository.
2. Customize the project to suit your needs.
3. Start building your cross-platform application using Jetpack Compose and other dependencies.