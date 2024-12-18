import kotlin.math.floor
import kotlin.random.Random

fun main() {
    val someList = mutableListOf<Int>();
    (1..100).toList().forEach { it ->
        someList.add(Random.nextInt(1, 100))
    }
    val toFind = someList[Random.nextInt(1, 100)];
    print("toFind:  ")
    println(toFind)

    someList.sortWith(compareBy { it });

    println(someList);

    val low: Int = 0;
    val high: Int = someList.size - 1;

    val index = binarySearch(someList, high, low, toFind);

    print("index:   ");
    println(index);

    print("element: ")
    println(someList[index]);
}

/**
 * Simple search implementation
 * */
fun binarySearch(sortedArr: MutableList<Int>, high: Int, low: Int, x: Int): Int {
    if (high >= low) {
        var mid = (high + low).floorDiv(2);
        if (sortedArr[mid] == x) {
            return mid
        } else if (sortedArr[mid] > x) {
            return binarySearch(sortedArr,mid - 1, low, x);
        } else {
            return binarySearch(sortedArr, high, mid + 1, x);
        }
    } else {
        return -1;
    }
}

/**
 * Implementing the comparable operator giving our class sorting capabilities.
 * */
data class Laptop(val brand: String, val year: Int, val ram: Int, val price: Int) :
    Comparable<Laptop> {
    override fun compareTo(other: Laptop): Int {
        if (this.price > other.price) {
            return 1
        } else if (other.price > this.price) {
            return -1
        } else {
            return 0
        }
    }
}

/**
 * Create a comparator for sorting by ram property.
 * */
class ComparatorRam : Comparator<Laptop> {
    override fun compare(o1: Laptop, o2: Laptop): Int {
        if (o1.ram > o2.ram) {
            return 1;
        } else if (o1.ram < o2.ram) {
            return -1;
        } else {
            return 0;
        }
    }
}

/**
 * Comparator to sort by year property
 * */
class ComparatorYear : Comparator<Laptop> {
    override fun compare(o1: Laptop, o2: Laptop): Int {
        if (o1.year > o2.year) {
            return 1;
        } else if (o1.year < o2.year) {
            return -1;
        } else {
            return 0;
        }
    }
}

fun ordering() {
    val numsWithDuplicate = mutableListOf<Int>(7, 10, 7, 7, 9, 4, 3, 8, 9, 6);
    val numsWithoutDuplicate = mutableListOf<Int>(10, 9, 4, 1, 7, 8, 2, 5)

    print("SORTED")
    println(numsWithDuplicate.sorted());

    val laptops = mutableListOf(
        Laptop("Dell", 2015, 12, 500),
        Laptop("Apple", 2019, 16, 1680),
        Laptop("HP", 2024, 8, 600)
    );

    print("SORTING CLASS:   ")
    println(laptops.sorted())

    print("SORTED WITH TO SORT BY RAM: ")
    println(laptops.sortedWith(ComparatorRam()))

    print("SORTED WITH TO SORT BY YEAR: ")
    println(laptops.sortedWith(ComparatorYear()))

    print("SORTED WITH COMPARE BY:  ")
    println(laptops.sortedWith(compareBy { it.price }))

    print("SORTED BY: ")
    println(laptops.sortedBy { it.year })

    print("SORTED WITH COMPARE BY / THEN BY:  ")
    println(laptops.sortedWith(compareBy<Laptop> { it.price }.thenBy { it.year }))
}


fun collectionRetrieval() {
    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(nums.slice(1..5))
    println(nums.slice(1..5 step 2))
    println(nums.slice(setOf(1, 5)))

    // returns/removes the specified number of elements starting from the beginning of the collection
    println("TAKE")
    println(nums.take(3))
    println(nums.takeLast(6))

    // returns/removes the specified number of elements starting from the end of the collections
    println("DROP")
    println(nums.drop(3))
    println(nums.dropLast(6))

    // returns/removes the specified number of elements starting from the end of the collections
    // stops checking (while loop) the collection when the predicate is failed.
    println(nums.takeWhile { it != 3 })
    println(nums.dropWhile { it != 3 })

    // CHUNK
    // [[1,2],[3,4]]
    print("Chunk")
    println(nums.chunked(2))
    print("Chunk with transformer:  ")
    println(nums.chunked(2) { it ->
        print("inner: ")
        println(it)

        // sums up each array chunk
        it.sum()
    })

    // WINDOWED
    print("WINDOWED")
    println(nums.windowed(3))

    print("WINDOWED WITH A STEP: ")
    println(nums.windowed(size = 3, step = 3))

    print("ELEMENT AT")
    println(nums.elementAt(4));

    print("FIRST")
    println(nums.first())

    print("LAST")
    println(nums.last())

    print("FIRST with a predicate, continues checking down the list until a predicate matching element is found:    ")
    println(nums.first { it % 2 == 0 })

    print("LAST with a predicate, continues checking up the list until a predicate matching element is found:   ")
    println(nums.last { it % 2 == 0 })

    print("RANDOM:  ")
    println(nums.random())

    print("EMPTY:   ")
    println(nums.isEmpty())

    print("Original array:  ")
    println(nums)
}

fun grouping() {

    val nums = listOf(1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    /**
     * Returns a Map of type (<predicate return value, element type>)
     *
     * Groups collection elements using the predicate
     *
     * The predicate return value acts as the map-key and the map-value(s) are elements that are equal to the keys after transformation by the predicate.
     */
    println(nums.groupBy { it * 30 })

    /**
     * keySelector parameter determines the map-key
     *
     * in this case, trailing lambda acts a valueTransform parameter argument
     */
    println(nums.groupBy(keySelector = { it }) { it % 2 == 0 })
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