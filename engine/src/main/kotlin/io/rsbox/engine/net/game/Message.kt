package io.rsbox.engine.net.game

import io.rsbox.engine.net.game.model.GamePacket
import io.rsbox.engine.net.game.model.GamePacketBuilder
import io.rsbox.engine.net.game.model.GamePacketReader
import io.rsbox.engine.net.game.model.PacketType

/**
 * @author Kyle Escobar
 */

abstract class Message(val opcode: Int, val length: Int, val type: PacketType = PacketType.FIXED) {

    open fun encode(packet: GamePacketBuilder): GamePacket { throw Exception("Unable to encode message ${this.javaClass.simpleName}.") }

    open fun decode(packet: GamePacketReader) { throw Exception("Unable to decode message ${this.javaClass.simpleName}.") }

    open fun handle() { throw Exception("Unable to handle message ${this.javaClass.simpleName}.") }

}