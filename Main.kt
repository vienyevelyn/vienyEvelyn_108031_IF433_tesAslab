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
            
            if (receiver != null){
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
                println("Check your amount input")
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
