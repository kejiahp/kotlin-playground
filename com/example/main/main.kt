package com.example.main

import com.example.classes.*
import com.example.interfaces.Move

fun main() {
    val fPlayer1 = FootballPlayer("Messi")
    val fPlayer2 = FootballPlayer("Ronaldo")

    val bPlayer1 = BaseballPlayer("John")
    val bPlayer2 = BaseballPlayer("Jane")

//    val fTeam = Team<Player>("Barcelona", mutableListOf<FootballPlayer>(fPlayer1))
//    fTeam.addPlayers(fPlayer2);

    val bTeam = Team<BaseballPlayer>("NewYortMets", mutableListOf(bPlayer1))
    bTeam.addPlayers(bPlayer2)

//    val gameTeam = Team<GamesPlayer>("Games Team", mutableListOf())
//
//    val codTeam = Team<BaseballPlayer>("NewYortMets", mutableListOf(bPlayer1))
//    bTeam.addPlayers(bPlayer2)\

    val mixedList = mutableListOf(1,"two",3,"four",5,"six",7,"eight",9,"ten");
    val filteredList = getSpecificTypes<Int>(mixedList);

    print("Filter List")
    println(filteredList);
}




/**
 * A function with a `reified` type, ensuring the type is preserved at runtime.
 */
inline fun <reified T> getSpecificTypes(list: List<Any>): List<T> {
    val ofSpecifiedType = mutableListOf<T>();
    for (i in list) {
        if (i is T) {
            ofSpecifiedType.add(i);
        }
    }
    return ofSpecifiedType;
}

/**
 * function with multiple upper bounds
 */
fun <T> addPlayer(player: T) where T: Player, T: Move {
    println(player)
}