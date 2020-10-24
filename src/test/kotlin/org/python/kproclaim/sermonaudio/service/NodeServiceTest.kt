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

        assertNotNull(recordings);
        assertNotEquals(0, recordings.size)
        assertEquals("en", recordings[0].languageCode)
    }

    @Test
    fun testGetRecordingsBySpeaker() {
        val nodeService = NodeResolver()

        val speakerName = nodeService.getAllRecordings().get(0).speaker.fullName

        println( "looking up speakers with the name " + speakerName )
        val recordings = nodeService.getRecordingsBySpeaker(speakerName)

        assertNotNull(recordings);
        assertNotEquals(0, recordings.size)
        assertEquals("en", recordings[0].languageCode)
        assertEquals(speakerName, recordings[0].speaker.fullName)
    }

    @Test
    fun testGetSpeakersByBroadcasterId() {
        val nodeService = NodeResolver()

        val broadcasterId = nodeService.getAllRecordings().get(0).broadcaster.broadcasterId

        println( "looking up speakers with broadcasterID " + broadcasterId )
        val speakers = nodeService.getSpeakers(broadcasterId)

        assertNotNull(speakers);
        assertNotEquals(0, speakers.size)
    }

    @Test
    fun testGetRecordingsById() {
        val nodeService = NodeResolver()

        val recordingId = nodeService.getAllRecordings().get(0).sermonId
        val broadcasterId = nodeService.getAllRecordings().get(0).broadcaster.broadcasterId

        println( "looking up speakers with the id " + recordingId )
        val recording = nodeService.getRecording(recordingId)

        assertNotNull(recording);
        assertEquals("en", recording.languageCode)
        assertEquals(recordingId, recording.sermonId)
        assertEquals(broadcasterId, recording.broadcaster.broadcasterId)
    }
}
