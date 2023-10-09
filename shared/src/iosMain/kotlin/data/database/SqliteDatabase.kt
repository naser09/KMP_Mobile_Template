package data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.kmp.KMP_DB
import core.Constant
actual class DriverFactory{
    actual fun createDriver(): SqlDriver= NativeSqliteDriver(
        KMP_DB.Schema,
        Constant.DATABASE_NAME
    )

}