package a.sboev.cleanarchitecturesample.domain.usecase

import a.sboev.cleanarchitecturesample.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}