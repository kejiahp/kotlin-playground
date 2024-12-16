import kotlin.random.Random;

class Person(val fname: String = "Peter", val lname: String = "Parker") {
    var nickName: String? = null
    set (value) {
        field = "This the new value $value"
        println("This the new value $value")
    }
        get() {
            return field
        }

    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname";
        println("$fname ($nickNameToPrint) $lname");
    }
}

/* Working with interfaces */
interface PersonInfoProvider {
    val callingClass: String;

    fun printInfo(person: Person) {
        println(callingClass);
        person.printInfo();
    }
}

interface SessionInfoProvider {
    fun getSessionID(): String;
}

open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider {
    protected open val sID: String? = "BasicInfoProviderSession";

    override val callingClass: String
        get() {
            return "BasicInfoProvider"
        }

    override fun printInfo(person: Person) {
        super.printInfo(person);
        println("Just some extra steps involved in the basic info provider `printInfo` process")
    }

    override fun getSessionID(): String {
        return sID ?: Random.nextInt(1,100).toString()
    }
}

class FancyInfoProvider: BasicInfoProvider() {
    override val sID: String?
        get() {
            return null
        }
    override val callingClass: String
        get() {
            return "FancyInfoProvider"
        }
    override fun printInfo(person: Person) {
        super.printInfo(person);
        println("`printInfo` is been called from $callingClass, this is an override")
    }
}

interface CompObjProvider {
    fun getId(): String
}

// companion objects
class Entity private constructor(val id: String) {
    companion object Factory: CompObjProvider {
        override fun getId(): String {
        return Random.nextInt(1,100).toString();
        }

        fun create(): Entity {
            return Entity("ID: ${getId()}")
        };
    }
}



fun main() {
//    val entity = Entity.Companion.create();
    val entity = Entity.Factory.create();
    println(entity.id);
}

fun testingInterfacesAndInheritance() {
    // Instantiating anonymous inner classes using the object keyword
    // object expression
    val anonymousClassInstance = object: PersonInfoProvider {
        override val callingClass: String
            get() = "Anon"

        fun getSessionID(): String {
            return "Anon SessionID";
        }
    }

    print("anonymousClassInstance" + " ");
    println(anonymousClassInstance.getSessionID());

    val basicInfoProvider = BasicInfoProvider()
    val provider = FancyInfoProvider()
    val person = Person();
    provider.printInfo(person);
    println(provider.getSessionID());
}

fun listPlay() {
    val someCollection = listOf("sf",1,"difference")
    someCollection.forEach{it -> println(it)};

    val keyPairs = mapOf(1 to "one", 2 to "two", 3 to "three");
    keyPairs.forEach{(key, value) -> println("$key $value")};
}
