package org.pythonbyte.kproclaim.sermonaudio.util.url

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BroadcasterApiUrlBuilderTest {
    @Test
    fun testBuild() {
        val broadcasterApiUrlBuilder = BroadcasterApiUrlBuilder()
        val expectedValue = "https://api.sermonaudio.com/v2/broadcaster/bob?name=mark&age=4"
        assertEquals(expectedValue, broadcasterApiUrlBuilder.build("2", "bob", mapOf("name" to "mark", "age" to "4")))
    }
}
