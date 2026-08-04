class Account(
    val name: String,
    val nim: String,
    private val password: String,
    private var balance: Int = 100000
){
    fun login(inputNim: String, inputPassword: String) : Boolean{
        if (inputNim == password && inputPassword == password){
            return true
        }
        return false
    }
}
