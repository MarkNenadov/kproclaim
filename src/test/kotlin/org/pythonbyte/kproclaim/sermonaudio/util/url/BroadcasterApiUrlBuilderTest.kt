package org.pythonbyte.kproclaim.sermonaudio.util.url

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BroadcasterApiUrlBuilderTest {
    @Test
    fun testBuild() {
        val broadcasterApiUrlBuilder = BroadcasterApiUrlBuilder()
        val expectedValue = "https://api.sermonaudio.com/v1/broadcaster/bob?name=mark&age=4"
        assertEquals(expectedValue, broadcasterApiUrlBuilder.build("1", "bob", mapOf("name" to "mark", "age" to "4")))
    }
}