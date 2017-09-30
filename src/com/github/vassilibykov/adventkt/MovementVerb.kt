package com.github.vassilibykov.adventkt

/**
 * A special verb bound to a movement direction such as "north",
 * so a direction by itself may be used as a command.
 */
abstract class MovementVerb(word: String) : Verb(word) {
    internal fun movePlayer(where: String) {
        val direction = Direction.lookup(where)
        if (direction == null) {
            println("You can't go to '$where'")
            return
        }
        val destination = player.room.exits[direction]
        if (destination == null) {
            println("You can't go $direction.")
            return
        }
        player.moveTo(destination)
    }
}