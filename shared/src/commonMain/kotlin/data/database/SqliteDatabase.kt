package data.database

import app.cash.sqldelight.db.SqlDriver
import com.kmp.KMP_DB

interface SqliteDatabase{
    fun database():KMP_DB
}
expect object SqliteDatabaseImpl:SqliteDatabase