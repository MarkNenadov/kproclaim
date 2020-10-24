package org.python.kproclaim.sermonaudio.service

import org.junit.jupiter.api.Test
import org.pythonbyte.kproclaim.sermonaudio.service.NodeServiceImpl
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

class NodeResolver : NodeServiceImpl() {
    override val apiKey = "YOUR API KEY GOES HERE"

    override val language = "en"
}

class NodeServiceTest {
    @Test
    fun testGetAllRecordings() {
        val nodeService = NodeResolver()

        val recordings = nodeService.getAllRecordings()

        assertNotNull( recordings );
        assertNotEquals( 0, recordings.size )
        assertEquals( "en", recordings[0].languageCode )
    }
}
