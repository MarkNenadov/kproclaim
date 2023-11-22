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
open class NodeServiceImpl : NodeService {
    open val apiKey = ""
    open val language = ""

    override fun getRecording(sermonId: String): Recording {
        return getRecordingFromEndpoint("sermons/${sermonId}")
    }

    private fun makeHttpRequest(endpoint: String, parameterName: String = "", parameterValue: String = ""): Response {
        val response = SermonAudioHttp(apiKey).getNode("2", endpoint, parameterName, URLEncoder.encode(parameterValue, "UTF-8"))

        when ( response.statusCode ) {
            500 -> {
                throw Exception( "500 code received from API, probable cause is bad api key. Url [${response.url}]")
            }
            200 -> {
                print( "Successful API Request [${response.url}]")
            }
            else -> {
                print( response )
            }
        }

        return response
    }

    override fun getAllRecordings(): List<Recording> {
        return getRecordingsFromEndpoint("sermons", "languageCode", language)
    }

    override fun getSpeakers(broadcasterId: String): List<Speaker> {
        val response = makeHttpRequest("speakers", "broadcasterID", broadcasterId)

        val speakers = JsonObject(response.jsonObject).getArray("results")

        return speakers.map { jsonObject -> Speaker.createFromJson(jsonObject) }
    }

    override fun getRecordingsBySpeaker(speakerName: String): List<Recording> {
        return getRecordingsFromEndpoint("sermons", "speakerName", speakerName)
    }

    private fun getRecordingsFromEndpoint(endpointName: String, parameterName: String = "", parameterValue: String = ""): List<Recording> {
        val response = makeHttpRequest(endpointName, parameterName, parameterValue)

        val recordings = JsonObject(response.jsonObject).getArray("results")

        return recordings.map { jsonObject -> Recording.createFromJson(jsonObject) }
    }

    private fun getRecordingFromEndpoint(endpointName: String, parameterName: String = "", parameterValue: String = ""): Recording {
        val response = makeHttpRequest(endpointName, parameterName, parameterValue)
        val recordingJson = JsonObject(response.jsonObject)

        return Recording.createFromJson(recordingJson)
    }
}
