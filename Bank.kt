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
