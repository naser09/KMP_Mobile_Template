package data.database

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.kmp.KMP_DB
import core.Constant
import org.koin.java.KoinJavaComponent.inject


actual object SqliteDatabaseImpl:SqliteDatabase{
    private val contextHolder:ContextHolder by inject(ContextHolder::class.java)
    private val driver = AndroidSqliteDriver(KMP_DB.Schema, contextHolder.context,Constant.DATABASE_NAME)
    override fun database(): KMP_DB {
        return KMP_DB(driver)
    }
}
class ContextHolder(val context: Context){}
