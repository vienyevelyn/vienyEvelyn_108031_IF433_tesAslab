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

class Bank{
    private val accounts = mutableListOf<Account>()
    
    init {
        accounts.add(Account("Angy", "0001", "01012006"))
        accounts.add(Account("Bandy", "0002", "02022006"))
        accounts.add(Account("Chonky", "0003", "03032006"))
    }
    
    fun findAccount(inputNim: String) : Account?{
        return accounts.find { it.nim == inputNim }
    }

    fun login(inputNim: String, inputPassword: String) : Account?{
        for (account in accounts) {
            if (account.login(inputNim, inputPassword)) {
                return account
            }
        }
        return null
    }
}

fun main(){
    val bankUMN = Bank()
    println("Selamat datang di Bank UMN")
    
    print("Masukkan NIM : ")
    val nim = readLine() ?: ""
    
    print("Password (Birth Date): ")
    val password = readLine() ?: ""
    
    val user = bankUMN.login(nim, password)
    
    if (user == null) {
        println("Login Failed!")
        return
    }
    
    while (true){
        println("Welcome ${user.name}")
        user.showBalance()
        
        println("MENU\n 1. Transfer\n 2. Withdraw\n 3. Deposit\n 4. Exit")
        
        println("Masukkan opsi: ")
        var choice= readLine() ?: "4"
        if (choice == "4"){
            println("You have exited the program")
            break
        }
        
        else if(choice == "1"){
            println("Destination NIM : ")
            val destinationNim = readLine() ?: ""
            val receiver = bankUMN.findAccount(destinationNim)
            if (receiver == user){
                println("You can't transfer to your own account")
            }
            else if (receiver != null){
                print("Amount : ")
                val inputAmount : Int = readLine()?.toIntOrNull() ?: 0
                if(user.transfer(receiver, inputAmount)){
                    println("Transfer Success")
                }
                else{
                    println("Transfer Failed. Make sure the amount is correct")
                }
                
            }
            else{
                println("No account is found")
            }
        }
        
        else if(choice == "2"){
            print("Amount : ")
            val inputAmount : Int = readLine()?.toIntOrNull() ?: 0
            
            if(user.withdraw(inputAmount)){
                println("Withdraw Success")
            }
            else{
                println("Check your amount input. Can't withdraw all your money or more or minus")
            }
        }
        else if(choice == "3"){
            print("Amount : ")
            val inputAmount : Int = readLine()?.toIntOrNull() ?: 0
            
            if(user.deposit(inputAmount)){
                println("Deposit Success")
            }
            else{
                println("Check your amount input")
            }
        }
        else{
            println("Invalid Choice")
        }
        
    }
   
    
}
