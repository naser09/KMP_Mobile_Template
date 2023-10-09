package data.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.kmp.KMP_DB
import core.Constant
import org.koin.java.KoinJavaComponent.inject
actual class DriverFactory (private val context: Context){
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        KMP_DB.Schema,context,
        Constant.DATABASE_NAME
    )

}