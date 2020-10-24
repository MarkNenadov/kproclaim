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

    @Test
    fun testGetNodeWhenX() {
        val response = sermonAudioHttp.getNode("2", "sermons", "languageCode", "eng")

        assertNotNull(response.jsonObject)

        val nextPageUrl = response.jsonObject.getString("next")
        val nodeDisplayName = response.jsonObject.getString("nodeDisplayName")
        assertEquals("/v2/node/sermons?languageCode=eng&page=2", nextPageUrl)
        assertEquals("sermons_list", nodeDisplayName)
    }
}
