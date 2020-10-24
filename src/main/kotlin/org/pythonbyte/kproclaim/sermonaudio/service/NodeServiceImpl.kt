package org.pythonbyte.kproclaim.sermonaudio.service

import org.pythonbyte.krux.json.JsonObject
import org.pythonbyte.kproclaim.sermonaudio.domain.Recording
import org.pythonbyte.kproclaim.sermonaudio.domain.Speaker
import org.pythonbyte.kproclaim.sermonaudio.util.transport.SermonAudioHttp
import khttp.responses.Response
import org.springframework.stereotype.Component
import java.net.URLEncoder

@Component
@SuppressWarnings("unused")
class NodeServiceImpl : NodeService {
    val apiKey = ""
    val language = ""

    override fun getRecording(sermonId: String): Recording {
        val response = makeHttpRequest("sermon_info", "sermonID", sermonId)

        return Recording.createFromJson(JsonObject(response.jsonObject).getArray("results")[0])
    }

    private fun makeHttpRequest(endpoint: String, parameterName: String, parameterValue: String): Response {
        return SermonAudioHttp(apiKey)
            .getNode("2", endpoint, parameterName, URLEncoder.encode(parameterValue, "UTF-8"))
    }

    override fun getAllRecordings(): List<Recording> {
        return getRecordingsFromEndpoint("sermons_by_language", "languageCode", language)
    }

    override fun getSpeakers(sourceId: String): List<Speaker> {
        val response = makeHttpRequest("speakers_for_source", "sourceID", sourceId)

        val speakers = JsonObject(response.jsonObject).getArray("results")

        return speakers.map { jsonObject -> Speaker.createFromJson(jsonObject) }
    }

    override fun getRecordingsBySpeaker(speakerName: String): List<Recording> {
        return getRecordingsFromEndpoint("sermons_by_speaker", "speakerName", speakerName)
    }

    private fun getRecordingsFromEndpoint(endpointName: String, parameterName: String, parameterValue: String): List<Recording> {
        val response = makeHttpRequest(endpointName, parameterName, parameterValue)

        val recordings = JsonObject(response.jsonObject).getArray("results")

        return recordings.map { jsonObject -> Recording.createFromJson(jsonObject) }
    }
}
