fun main() {
    collectionRetrieval()
}

fun collectionRetrieval () {
    val nums = listOf(1,2,3,4,5,6,7,8,9,10)
    println(nums.slice(0..2))
    println(nums)
}

fun grouping() {

    val nums = listOf(1,1,1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    /**
     * Returns a Map of type (<predicate return value, element type>)
     *
     * Groups collection elements using the predicate
     *
     * The predicate return value acts as the map-key and the map-value(s) are elements that are equal to the keys after transformation by the predicate.
     */
    println(nums.groupBy { it*30 })

    /**
     * keySelector parameter determines the map-key
     *
     * in this case, trailing lambda acts a valueTransform parameter argument
     */
    println(nums.groupBy(keySelector = {it}) { it%2 == 0 })
}

fun filtering() {
    val nums =
        listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    println(nums.filter { it.length == 3 })
    val numsMap = nums.associateBy { it.length }
    println(numsMap.filter { it.key == 5 })

    println(nums.filterIndexed { indx, value -> value.length + indx == 3 })
    print("No three letter numbers: ")
    println(nums.filterNot { value -> value.length == 3 })
    print("Instance filtering: ")
    val mixedList = listOf("one", "two", "three", 4, 5, 6, 7, 8)
    println(mixedList.filterIsInstance<Int>())

    //Partition: returns two lists, element that pass the predicate are elements of the first list others are in the second list
    print("Partition: ")
    println(nums.partition { it.length >= 5 })

    // any: returns True if all the elements match the predicate
    println(nums.any { it.length == 3 })
    // none: returns True if none of the elements match the predicate
    println(nums.none { it.length == 20 })
    // all: returns True if all of the elements match the predicate
    println(nums.all { it.length == 5 })
}

fun stringRepresentation() {
    val nums = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // string are immutable, a string buffer gives use a mutable string. Mutation can happen using methods such as (append<add to end of list>, insert<add to specified position in list>)
    val simplerStrBuff = StringBuffer("Lets get started: ")
    println(
        nums.joinTo(
            buffer = simplerStrBuff,
            separator = " | ",
            prefix = " % ",
            postfix = " ^ "
        )
    )
    println(nums.joinToString())
    println(nums.joinToString { "Element: ${it.toString()}" })
}

fun zipping() {
    // ZIPPING
    val colors = listOf("red", "brown", "grey");
    val animals = listOf("fox", "bear", "wolf");
    // returns a list of pairs
    println(colors zip animals);
    colors.zip(
        animals,
        { color, animal -> "The ${animal.replaceFirstChar({ it.uppercase() })} is $color" })
        .let { println(it) }

    // the difference in list of pairs and map, is a map does not allow duplicate keys while a list of pairs does.
    val nameMap = mutableListOf<Pair<Int, String>>(
        1 to "name1",
        2 to "name2",
        3 to "name3",
        4 to "name4",
        5 to "name5",
        5 to "name5-duplicate"
    );
    // returns two lists on containing keys the other values
    println(nameMap.unzip());

    // ASSOCIATION
    val nums = listOf("one", "two", "three", "four", "five");
    // map with collection elements as keys
    println(nums.associateWith { it.length });
    // map with collection elements as values
    println(nums.associateBy { it.length })
    // map with collection elements as values included a `keySelector`
    println(nums.associateBy(keySelector = { it.first() }) { it.length * 10 })

    // FLATTEN
    val numSet: List<Set<Int>> = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(7, 8, 9))
    println(numSet[0].elementAt(0))
    print("Flattened: ")
    println(numSet.flatten())
}

fun collectionManipulation() {
    val numSet = setOf(1, 2, 3, 4, 5, 6, 7);
    numSet.map { it + 2 }.let { println(it) }
    println(numSet)
}

fun basicCollections() {
    val names = mutableListOf<String>("name1", "name2", "name3", "name4");
    val nameSet = mutableSetOf<String>("name1", "name2", "name3", "name4", "name5");
    val nameMap = mutableMapOf<Int, String>(
        1 to "name1",
        2 to "name2",
        3 to "name3",
        4 to "name4",
        5 to "name5"
    );
    nameMap.put(6, "James");
    print("Some Value ");
    println(nameMap[3]);

    nameMap.forEach { it -> println("key: ${it.key} | value: ${it.value}") }
}