package a.sboev.cleanarchitecturesample.domain.usecase

import a.sboev.cleanarchitecturesample.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Ivan", lastName = "Ivanov")
    }
}