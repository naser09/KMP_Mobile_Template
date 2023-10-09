package domain.use_cases.user

import domain.model.User
import domain.repository.UserRepository

class CreateUser(private val repository: UserRepository){
    operator fun invoke(user: User){
        repository.createUser(user)
    }
}