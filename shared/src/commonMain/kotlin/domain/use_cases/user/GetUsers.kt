package domain.use_cases.user

import domain.model.User
import domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(private val repository: UserRepository) {
    operator fun invoke():Flow<List<User>>{
        return repository.getAllUser()
    }
}