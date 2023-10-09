package data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.kmp.KMP_DB
import core.Constant

actual object SqliteDatabaseImpl:SqliteDatabase{
    override fun database(): KMP_DB {
        val sqlDriver:SqlDriver = NativeSqliteDriver(
            KMP_DB.Schema,
            Constant.DATABASE_NAME,
            maxReaderConnections = 4,
        )
        return KMP_DB(sqlDriver)
    }
}