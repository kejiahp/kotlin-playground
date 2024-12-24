package com.example.classes

import com.example.interfaces.Move

internal class Team<T>(val name: String, val players: MutableList<out T>) where T: Player, T: Move {
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${player.name} is already in team $name")
        } else {
//            players.add(player);
            println("Player: ${player.name} was added team $name")
        }
    }
}


open class Player(val name: String)

class FootballPlayer(name: String) : Player(name), Move {
    override fun running() {
        TODO("Not yet implemented")
    }
}
class BaseballPlayer(name: String) : Player(name), Move {
    override fun running() {
        TODO("Not yet implemented")
    }
}
open class GamesPlayer(name: String) : Player(name), Move {
    override fun running() {
        TODO("Not yet implemented")
    }
}
class CallOfDutyPlayer(name: String) : GamesPlayer(name), Move {
    override fun running() {
        TODO("Not yet implemented")
    }
}

