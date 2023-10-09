package data.database

import com.kmp.KMP_DB

interface SqliteDatabase{
    fun database():KMP_DB
}
expect object SqliteDatabaseImpl:SqliteDatabase