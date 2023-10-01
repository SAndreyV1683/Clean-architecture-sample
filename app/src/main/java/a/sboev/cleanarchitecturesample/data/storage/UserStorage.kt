package a.sboev.cleanarchitecturesample.data.storage



interface UserStorage {

    fun save(user: User): Boolean
    fun get():User
}