package data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.kmp.KMP_DB
import domain.model.User
import domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(private val database: KMP_DB):UserRepository {
    override fun createUser(user: User) {
        database.userEntityQueries.create_user(user.name)
    }

    override fun getAllUser(): Flow<List<User>> {
        return database.userEntityQueries.get_users().asFlow().mapToList(Dispatchers.IO).map { list -> list.map { User(it.id,it.full_name) }}
    }

    override fun getUserById(id: Long): User {
        val user = database.userEntityQueries.get_user_by_id(id).executeAsOne()
        return User(user.id,user.full_name)
    }
}