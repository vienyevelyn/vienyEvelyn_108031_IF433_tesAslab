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
    
    fun deposit(inputAmount : Int) : Boolean{
        
        if (inputAmount > 0){
            balance += inputAmount
            println("Desposit Success")
            println("Your Balance ${balance}")
            return true
        }
        else{
            println("Deposit Failed")
            println("Your Balance ${balance}")
            return false
        }
        
        
    }
    
    fun withdraw(inputAmount : Int) : Boolean{
        if (inputAmount < balance){
            balance -= inputAmount
            println("Withdraw Success")
            println("Your Balance ${balance}")
            return true
        }
        else{
            println("You can't withdraw all your money or more")
            println("Your Balance ${balance}")
            return false
        }
        
    }
    
    fun transfer(receiver: Account, inputAmount: Int) : Boolean{
        val withdrawMoney = withdraw(inputAmount)
        if (withdrawMoney){
            receiver.deposit(inputAmount)
            println("Transfer success")
            return true
        }
        else{
            println("Transfer Failed")
            return false
        }
    }
    
}
