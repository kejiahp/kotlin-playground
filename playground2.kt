fun main() {
    labeledForLoop()
}

fun forLoop () {
    val step: Int = 100;

    for (i in step downTo 50 step 10) {
        print(i)
    }

    print("\n")

    for (i in 0 until step step 10) {
        print("${i * 2} ")
    }
}

fun labeledForLoop () {
    val step: Int = 100;
    outer_looper@ for (i in 1..step) {
        print("outer_cnt:$i ")
        for (j in 1..step) {
            print("inner_cnt: $j ")
            if(j == 50) break@outer_looper
        }
    }
}

/**
 * Playing around with the when statement Kotlin `when` can be used as both an expression and a
 * statement
 */
fun whenStatement() {
    /** readln returns an empty string if `STDIN` was not provided */
    val readVal: String = readln();
    if (readVal.isEmpty()) return;

     when (val num = readVal.toInt() as Any) {
         10, 11, 12 -> println("$num is within either 10,11 or 12")
         42 -> println("$num The answer to life, the universe and everything")
         in 20..30 -> println("$num is within the range of 20-30")
         is Int ->
                 when {
                     num % 2 == 0 -> println("$num is an even number")
                     else -> println("$num is an odd number")
                 }
         is Long -> println("$num is a 64bit integer")
         else -> println("$num unknown type or value")
     }
}

/** kotlin `if` can be used as an expression and also as a statement */
fun ifExpression() {
    val num1: Int = 5
    var result: String?  =
            if (num1 > 10) "$num1 is greater than 6"
            else if (num1 == 5) "$num1 is equal to 5" else null
    println(result)
}


fun testingThingsOut() {
    var num: String? = readLine()
    num = if (num?.length!! < 5) null else num
    if(num == null) {
        num = "ofdream thelema is one of the best songs ive heard"
    }
    num?.let {
        val lister = it.split(' ');
        println(lister.javaClass)
        println(lister.javaClass.name)
        println(lister.javaClass.simpleName)
        println("value provided is: $it")
    }
}