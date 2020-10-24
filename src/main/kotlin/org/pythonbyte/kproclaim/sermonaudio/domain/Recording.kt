package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject
import org.pythonbyte.krux.url.utf8Url

class Recording {
    var sermonId = ""
    var speaker = Speaker()
    var source = RecordingSource()
    var datePublished = ""
    var preachDate = "" // YYYY-MM-DD
    var fullTitle = ""
    var displayTitle = ""
    var mp3Url = ""
    var mp4Url = ""
    var eventType = ""
    var downloadCount = 0
    var languageCode = ""

    fun getParameterMapForCreate(): Map<String, String> {
        return mapOf(
                "fullTitle" to utf8Url(fullTitle)!!,
                "speakerName" to utf8Url(speaker.fullName)!!,
                "preachDate" to utf8Url(preachDate)!!,
                "acceptAdditionalCharges" to "false"
        )
    }

    companion object {
        fun createFromJson(jsonObject: JsonObject): Recording {
            val recording = Recording()
            recording.speaker = Speaker.createFromJson(jsonObject.getObject("speaker"))
            //recording.source = RecordingSource.createFromJson(jsonObject.getObject("source"))
            recording.datePublished = jsonObject.getString("publishDate")
            recording.preachDate = jsonObject.getString("preachDate")
            recording.sermonId = jsonObject.getString("sermonID")
            recording.fullTitle = jsonObject.getString("fullTitle")
            recording.displayTitle = jsonObject.getString("displayTitle")
            recording.mp3Url = jsonObject.getString("audioFileURL")
            recording.eventType = jsonObject.getString("eventType")
            recording.downloadCount = jsonObject.getInt("downloadCount")
            recording.languageCode = jsonObject.getString("languageCode")
            recording.mp4Url = jsonObject.getString("videoFileURL")

            return recording
        }
    }
}
