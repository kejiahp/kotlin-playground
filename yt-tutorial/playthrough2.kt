import java.nio.channels.Selector
import java.util.Locale
import java.util.UUID

/**
 * Enum classes
 */
enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormatterName(): String {
        return name.lowercase()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}

/*
* object declaration
*
* Commonly used to create thread safe singleton
* */
object EntityFactory {
    fun create(type: EntityType): SealedEntity {
        val name: String = when(type) {
            EntityType.EASY -> type.getFormatterName()
            EntityType.MEDIUM -> type.getFormatterName()
            EntityType.HARD -> type.getFormatterName()
            EntityType.HELP -> type.getFormatterName()
            else -> "Not specified"
        }
        val id = UUID.randomUUID().toString();
//        return NewEntity(id, name)
        return when(type) {
            EntityType.MEDIUM -> SealedEntity.Medium(id, name);
            EntityType.EASY -> SealedEntity.Easy(id, name);
            EntityType.HARD -> SealedEntity.Hard(id, name, 2f);
            EntityType.HELP -> SealedEntity.Help
//            else -> println("Not specified")
        }
    }
}

class NewEntity(val id: String, val name: String) {
    override fun toString():String {
        return "id: $id | name: $name";
    }
}

/*
* Seal class
*
* Used to restrict class hierarchies
*
* A set of classes extending a base type and only these classes can extend the base type.
*
*  This means that all subclasses of a sealed class are known at compile time, which can be very useful for modeling state or representing a fixed set of types.
*
* I this example rather than using Enums to differentiate between classes we will us a sealed class with a couple of data classes
*  */
sealed class SealedEntity{
    object Help: SealedEntity() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): SealedEntity();
    data class Medium(val id: String, val name: String): SealedEntity();
    data class Hard(val id: String, val name: String, val multiplier: Float): SealedEntity();
}


/*
* Another sealed class example
* */
sealed class Resultx {
    data class Success(val data: String): Resultx();
    data class Error(val exception: Exception): Resultx();
    object Loading: Resultx();
}

fun handleResult(result: Resultx) {
    when (result) {
        is Resultx.Success -> println(result.data)
        is Resultx.Error -> println(result.exception)
        Resultx.Loading -> println("Loading...")
        else -> println("Nothing to see here")
    }
}

fun main() {
    val newEntity = EntityFactory.create(EntityType.EASY);
    println(newEntity);

    when (newEntity) {
        is SealedEntity.Hard -> println("Entity is Hard");
        is SealedEntity.Easy -> println("Entity is Easy");
        is SealedEntity.Medium -> println("Entity is Medium");
        SealedEntity.Help -> println("Help Class Object")
        else -> println("Not specified");
    }
}