package io.rsbox.net

import io.netty.buffer.ByteBuf

/**
 * @author Kyle Escobar
 */

/**
 * Defines a class which contains logic to decode / encode a [Message] to/from a byte buffer.
 */
interface Codec<T : Message> {

    /**
     * Encodes a message into bytes to be send over the network.
     *
     * @param buf The Buffer to encode into. Should be empty.
     * @param message The outbound message class.
     * @return The encoded byte buffer.
     */
    fun encode(buf: ByteBuf, message: T): ByteBuf { throw IllegalAccessError("Unable to execute encode on inbound messages.") }

    /**
     * Decodes a byte buffer received from the network into a message.
     *
     * @param buf The buffer from the network packet.
     * @return The message object as a new instance.
     */
    fun decode(buf: ByteBuf): T { throw IllegalAccessError("Unable to execute decode on outbound messages.") }

    /**
     * A registration class which defines an opcode associated with a codec.
     *
     * @param opcode The opcode integer.
     * @param codec The associated codec.
     */
    @Suppress("UNCHECKED_CAST")
    data class CodecRegistration(val opcode: Int, private val codec: Codec<*>) {

        @Suppress("UNUSED_PARAMETER")
        fun <M : Message> getCodec(): Codec<M> {
            return codec as Codec<M>
        }

    }
}