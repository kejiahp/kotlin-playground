fun main() {
    tryCatchExpression();
}

fun tryCatchExpression() {
    val a = 5;
    val b = 0;
    val result = try {
        a / b
    } catch (e: ArithmeticException) {
        println("You can't divide by zero: ${e.message}");
        0
    } finally {
        println("I always run ")
    }
    print("result:  ")
    println(result)
}

fun basicExceptionHandling() {
    val num = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    try {
        println(num[20])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("You can't get this element: ${e.message}")
    } finally {
        println("I always run 😉");
    }
}