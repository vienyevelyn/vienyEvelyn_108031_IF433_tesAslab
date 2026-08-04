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
    
   
   
    
}
