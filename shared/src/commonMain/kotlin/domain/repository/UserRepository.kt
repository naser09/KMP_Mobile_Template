package domain.repository

import domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun createUser(user: User)
    fun getAllUser():Flow<List<User>>
    fun getUserById(id:Long):User
}