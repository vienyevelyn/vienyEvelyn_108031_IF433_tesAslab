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
        
        println("MENU\n 1. Transfer\n 2. Withdraw\n 3. Deposit\n 4. Exit")
        
        println("Masukkan opsi: ")
        var choice= readLine() ?: "4"
        if (choice == "4"){
            println("You have exited the program")
            break
        }
        
        if (choice == "1"){
            print("Destination NIM : ")
        }
        
    }
   
    
}
