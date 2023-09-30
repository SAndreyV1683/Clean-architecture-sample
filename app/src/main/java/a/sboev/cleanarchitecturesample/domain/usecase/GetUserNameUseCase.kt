package a.sboev.cleanarchitecturesample.domain.usecase

import a.sboev.cleanarchitecturesample.domain.models.UserName
import a.sboev.cleanarchitecturesample.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}