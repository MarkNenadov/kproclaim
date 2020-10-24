package org.pythonbyte.kproclaim.sermonaudio.util.transport

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SermonAudioHttpTest {
    private val apiKey = "API KEY HERE"
    private val sermonAudioHttp = SermonAudioHttp(apiKey)

    @Test
    fun testGetNodeWhen404() {
        val result = sermonAudioHttp.getNode("2", "doesntexist", "test", "test1")
        val expectedJson = "{\"status\":\"SermonAudio API 404 Not Found\"}"

        assertNotNull(result)
        assertEquals(expectedJson, result.text)
    }
}
