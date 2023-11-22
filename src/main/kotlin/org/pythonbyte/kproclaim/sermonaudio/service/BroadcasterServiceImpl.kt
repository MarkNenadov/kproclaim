package org.pythonbyte.kproclaim.sermonaudio.service

import org.pythonbyte.kproclaim.sermonaudio.domain.Recording
import org.pythonbyte.kproclaim.sermonaudio.util.transport.SermonAudioHttp
import org.springframework.stereotype.Component

@Component
@SuppressWarnings("unused")
class BroadcasterServiceImpl : BroadcasterService {
    val apiKey = ""

    override fun createRecording(recording: Recording): Boolean {
        val response = SermonAudioHttp(apiKey)
            .postBroadcaster(
                "1",
                "create_sermon",
                recording.getParameterMapForCreate(),
            )
        println(response.text)
        return true
    }
}
