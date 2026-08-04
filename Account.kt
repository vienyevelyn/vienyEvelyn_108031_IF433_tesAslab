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
    fun deposit(inputAmount : Int){
        
        if (inputAmount > 0){
            balance += inputAmount
            println("Desposit Success")
        }
        else{
            println("Deposit Failed")
        }
        println("Your Balance ${balance}")
        
    }
}
