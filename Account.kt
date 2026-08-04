class Account(
    val name: String,
    val nim: String,
    private val password: String,
    private var balance: Int = 100000
){
    fun login(inputNim: String, inputPassword: String) : Boolean{
        if (inputNim == nim && inputPassword == password){
            return true
        }
        return false
    }
    
    fun deposit(inputAmount : Int) : Boolean{
        
        if (inputAmount > 0){
            balance += inputAmount
            return true
        }
        else{
            return false
        }
        
        
    }
    
    fun withdraw(inputAmount : Int) : Boolean{
        if (inputAmount < balance && inputAmount > 0){
            balance -= inputAmount
            return true
        }
        else{
            return false
        }
        
    }
    
    fun transfer(receiver: Account, inputAmount: Int) : Boolean{
        val withdrawMoney = withdraw(inputAmount)
        if (withdrawMoney){
            receiver.deposit(inputAmount)
            return true
        }
        else{
            return false
        }
    }
    
    fun showBalance(){
        println("Your Current Balance: ${balance}")
    }
}
