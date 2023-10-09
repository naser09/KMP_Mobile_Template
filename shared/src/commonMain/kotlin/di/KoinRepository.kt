package di

import domain.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object KoinRepository :KoinComponent{
    val repository:UserRepository by inject()
}