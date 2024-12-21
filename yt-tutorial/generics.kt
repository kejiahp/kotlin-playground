/**
 * Generics for that sweet compile time errors
 *
 * Type checking can't be done with generics they are compile time (Type Erasure)
 *
 * Generics don't make it to runtime
 *
 * upperbounds - <T: Player> which is <T extends Player> in typescript is called an `Under bounds`
 *
 * invariance - expects the exact type ignores upper bound types. e.g. MutableList
 *
 * covariance - allows only sub-classes of a type, usually the specified upper bounds type, applied using `out` keyword | | DOWN THE INHERITANCE TREE
 *
 * covariance can have errors because it allows subtypes and subtypes might have override the supertype properties.
 *
 * contravariance - opposite of covariance, accepts only super-classes of a type, usually the upper bounds type, applied using `in` keyword | UP THE INHERITANCE TREE
 */

fun main() {
    val fPlayer1 = FootballPlayer("Messi")
    val fPlayer2 = FootballPlayer("Ronaldo")

    val bPlayer1 = BaseballPlayer("John")
    val bPlayer2 = BaseballPlayer("Jane")

    val fTeam = Team<Player>("Barcelona", mutableListOf<FootballPlayer>(fPlayer1))
    fTeam.addPlayers(fPlayer2);

    val bTeam = Team<BaseballPlayer>("NewYortMets", mutableListOf(bPlayer1))
    bTeam.addPlayers(bPlayer2)

//    val gameTeam = Team<GamesPlayer>("Games Team", mutableListOf())
//
//    val codTeam = Team<BaseballPlayer>("NewYortMets", mutableListOf(bPlayer1))
//    bTeam.addPlayers(bPlayer2)
}


class Team<T: Player>(val name: String, val players: MutableList<out T>) {
    fun addPlayers(player: T) {
        if(players.contains(player)) {
            println("Player: ${player.name} is already in team $name")
        }else {
//            players.add(player);
            println("Player: ${player.name} was added team $name")
        }
    }
}

open class Player (val name: String)

class FootballPlayer (name: String): Player(name);
class BaseballPlayer (name: String): Player(name);
open class GamesPlayer(name: String): Player(name);
class CallOfDutyPlayer (name: String): GamesPlayer(name)


//fun <>