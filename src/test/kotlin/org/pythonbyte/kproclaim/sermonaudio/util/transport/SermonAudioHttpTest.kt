package org.pythonbyte.kproclaim.sermonaudio.util.transport

import org.junit.jupiter.api.Test

class SermonAudioHttpTest {
    private val apiKey = "API KEY HERE"
    private val sermonAudioHttp = SermonAudioHttp(apiKey)

    @Test
    fun testGetNodeWhen404() {
        println(sermonAudioHttp.getNode( "1", "doesntexist", "test", "test1" ))
    }

    @Test
    fun testGetNodeWhenX() {
        val response = sermonAudioHttp.getNode( "1", "sermons_by_language", "languageCode", "eng" )

        println( response.jsonObject )
    }
}