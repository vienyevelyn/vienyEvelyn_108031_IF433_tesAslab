class Account(
    val name: String,
    val nim: String,
    private val password: String,
    private var balance: Int = 100000
)
