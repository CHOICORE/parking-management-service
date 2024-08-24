package me.choicore.samples.parking.common.util

import java.util.UUID.randomUUID

interface KeyGenerator {
    fun generate(): String
}

data object NanoIdKeyGenerator : KeyGenerator {
    override fun generate(): String {
        return NanoId.generate()
    }
}

data object UUIDKeyGenerator : KeyGenerator {
    override fun generate(): String {
        return "${randomUUID()}"
    }
}