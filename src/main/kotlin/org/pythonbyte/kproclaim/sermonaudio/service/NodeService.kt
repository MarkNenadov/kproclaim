package org.pythonbyte.kproclaim.sermonaudio.service

import org.pythonbyte.kproclaim.sermonaudio.domain.Recording
import org.pythonbyte.kproclaim.sermonaudio.domain.Speaker

interface NodeService {
    fun getRecording(sermonId: String) : Recording

    fun getRecordingsBySpeaker(speakerName: String) : List<Recording>

    fun getAllRecordings() : List<Recording>

    fun getSpeakers(broadcasterId: String) : List<Speaker>
}
