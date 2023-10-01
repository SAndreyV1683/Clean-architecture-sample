package a.sboev.cleanarchitecturesample.data.repository

import a.sboev.cleanarchitecturesample.data.storage.User
import a.sboev.cleanarchitecturesample.data.storage.UserStorage
import a.sboev.cleanarchitecturesample.domain.models.SaveUserNameParam
import a.sboev.cleanarchitecturesample.domain.models.UserName
import a.sboev.cleanarchitecturesample.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveParam.name, lastName = "")
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(firstName = user.firstName, user.lastName)
    }

}