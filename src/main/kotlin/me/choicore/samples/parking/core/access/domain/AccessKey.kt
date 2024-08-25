package me.choicore.samples.parking.core.access.domain

import me.choicore.samples.parking.common.util.NanoIdKeyGenerator

data class AccessKey(
    val value: String,
) {
    companion object {
        fun generate(): AccessKey = AccessKey(NanoIdKeyGenerator.generate())
    }

    override fun toString(): String = this.value
}
