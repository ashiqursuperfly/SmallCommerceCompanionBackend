package com.ashiqursuperfly.smallcommercecompanion.utils

import java.security.MessageDigest
import java.util.*

object Utils {
    fun generateSHA1(input: String): String {
        val crypt: MessageDigest = MessageDigest.getInstance("SHA-1")
        crypt.reset()
        crypt.update(input.toByteArray(Charsets.UTF_16))
        return byteToHex(crypt.digest())
    }

    private fun byteToHex(hash: ByteArray): String {
        val formatter = Formatter()
        for (b in hash) {
            formatter.format("%02x", b)
        }
        val result = formatter.toString()
        formatter.close()
        return result
    }
}