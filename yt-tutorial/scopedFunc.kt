fun main() {
    runScopedFun()
}

class User {
    var firstName: String = "";
    var lastName: String = "";
    var age: Int = -1;
}

data class NewUser (val firstName: String, val lastName: String) {
    override fun toString(): String {
        return "I am $firstName $lastName"
    }
}

fun runScopedFun() {
    val user: User? = null;
    // unlike with the `run` and `let` allow safe calls using the `?` keyword
    user?.run {
        firstName = "James"
        lastName = "Doette"
        age = 23
    }
}

fun alsoScopedFun() {
    NewUser(firstName = "John", lastName = "Doe").also { println(it) }
}

fun applyScopedFun() {
    val user = User().apply {
        firstName = "Jane"
        lastName = "Doette"
        age = 22
    };
    with(user) {
        println(firstName);
        println(lastName);
        println(age);
    }
}

fun withScopedFun() {
    val user = User();
    // WITH SCOPED FUNCTION
    with(user) {
        firstName = "John"
        lastName = "Doe"
        age = 23
    }

    // WITH SCOPED FUNCTION AS AN EXPRESSION
    val result = with(user) {
        firstName = "Jane"
        lastName = "Doette"
        age = 22
        "Text to be returned"
    }
    println(result)
}