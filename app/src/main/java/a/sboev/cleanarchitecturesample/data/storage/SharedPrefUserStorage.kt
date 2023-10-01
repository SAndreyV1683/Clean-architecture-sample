package a.sboev.cleanarchitecturesample.data.storage



import android.content.Context

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Default last name"
private const val DEFAULT_FIRST_NAME = "Default first name"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val shaderPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun save(user: User): Boolean {
        shaderPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        shaderPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = shaderPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = shaderPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}