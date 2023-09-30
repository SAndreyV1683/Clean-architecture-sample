package a.sboev.cleanarchitecturesample.domain.repository

import a.sboev.cleanarchitecturesample.domain.models.SaveUserNameParam
import a.sboev.cleanarchitecturesample.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}