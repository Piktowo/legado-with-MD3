package io.legado.app

import io.legado.app.utils.ColorUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class ColorUtilsTest {

    @Test
    fun byteArrToIntUsesUnsignedBytes() {
        val bytes = byteArrayOf(
            0x12.toByte(),
            0x34.toByte(),
            0x56.toByte(),
            0x78.toByte()
        )

        val result = ColorUtils.byteArrToInt(bytes)

        assertEquals(0x12345678, result)
    }
}
