package a.sboev.cleanarchitecturesample.data.repository

import a.sboev.cleanarchitecturesample.domain.models.SaveUserNameParam
import a.sboev.cleanarchitecturesample.domain.models.UserName
import a.sboev.cleanarchitecturesample.domain.repository.UserRepository
import android.content.Context

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImpl(context: Context): UserRepository{

    private val shaderPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        shaderPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = shaderPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = shaderPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }
}