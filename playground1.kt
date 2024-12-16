fun main() {
    val result = deezNuts("Deez NuTs")
    // println(result.toUpperCase()) // this is deprecated

    // println(result.uppercase())
    // print(result.lowercase())
    // println(result.contains("NuTs"))
}

fun deezNuts(returnString: String): String {
    // The `Any` type allows you to assign any datatype value to a variable.
    var num1: Any = 3
    val num2: String = "Two"

    // I literally don't know the difference in Byte(8bit),Short(16bit),Int(32bit),Long(64bit).
    // I literally don't know the difference in Float(32bit),Double(64bit)
    // NOTE: I need to do some research on the above
    var superNum: Int = 20

    // val randomCharacter: Char = 'I'
    // val randomString: String = "C"

    val name = "John Doe"
    val age = 30
    var shoeSize: String? = null
    lateinit var someVar: String

    // println(this::someVar.isInitialized)

//    if (::shoeSize.isInitialized) {
//        println("HOME")
//    }

    //      Get the type of a variable
    //      for this to work, `kotlin-reflect.jar` is required it is intentionally removed from
    //      base runtime library
    // println(num1::class::simpleName)
    // println(num1::class::qualifiedName)

    //     Re-assign a variable
    //     num1 = "three";

    //     Check if a value is an instance of or is of a certain type
    //     println(num1 is String);

    if (shoeSize != null) {
        println("Safe-call test: ${shoeSize.length}")
    }

    // OR

    println("Safe-call test: ${shoeSize?.length}")

    shoeSize = "44-45"

    // converts nullable var into non-nullable var name `it`. This is better than using an `if`
    // statement.  Less code i guess🙃
    shoeSize?.let { println(it::class::simpleName) }

    // shoeSize.let { println(it::class::simpleName) }

    // println(
    //         "My name is $name, I am $age years old. My name as ${name.length} characters. I make
    // \$100 every hour"
    // )

    return returnString
}
