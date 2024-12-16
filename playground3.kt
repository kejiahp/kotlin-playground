fun main() {
    oopStuff()
}


fun oopStuff() {
    // primary constructor
    class BankAccount(val number: Int, balance: Double) {
        var accountBalance: Double = balance
        var accountNumber: Int = number
        var lastName: String = ""
        var accountType: String = ""
        val fees: Double = 25.00

        // Initializer blocks
        // This runs whenever the class is initialized
        init {
            accountType = if (accountBalance > 1000000) "Gold" else "Ordinary"
        }

        // secondary constructor
        constructor(number: Int, balance: Double, lname: String) : this(number, balance) {
            lastName=lname
        }

        var balanceLessFees: Double get() {
            return accountBalance - fees
        } set(value: Double) {
            accountBalance = value - fees
        }

        // Creation of a companion object don't work inside local classes, in our case it wont work because of the function the class is inside.
//        companion object {
//            const val dfs = 100
//            fun bankAnnouncement(): Unit {
//                println("###### WELCOME TO THE AGE OF THE PROGRESSIVE BANK ######")
//            }
//        }

        fun displayBalance() {
            println("Account number: $accountNumber || Current balance: $accountBalance")
        }
    }

    val account1: BankAccount = BankAccount(number = 2123450193, balance = 1000000.00)
    val account2: BankAccount = BankAccount(2123450194, 3000000.00, "Popoola")

    account1.accountBalance *= 5
    account1.displayBalance()

    account1.balanceLessFees // executes the getter
    account1.balanceLessFees = 10000000.00 // executes the setter

    println(account1.accountType)
    println(account2.accountType)

}

fun oopStuffNestedClasses() {
    class ClassA{
        var globalProps: String = "sds"
        inner class ClassB {
            init {
                println("globalProps $globalProps")
            }
        }
    }
}

fun lambdaz() {
    fun packedArguments(vararg stringArgs: String) {
        stringArgs.forEach(::println)
    }
//    packedArguments("one","two","three","four","five")

    val packer = ::packedArguments
//    packer(Array(3){"value"})
    packer(Array(3){index -> "value $index"})
}