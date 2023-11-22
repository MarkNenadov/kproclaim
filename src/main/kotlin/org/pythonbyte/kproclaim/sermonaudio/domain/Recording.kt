package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject
import org.pythonbyte.krux.url.utf8Url

class Recording {
    var sermonId = ""
    var speaker = Speaker()
    var broadcaster = Broadcaster()
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
            "acceptAdditionalCharges" to "false",
        )
    }

    companion object {
        fun createFromJson(jsonObject: JsonObject): Recording {
            return Recording().apply {
                speaker = Speaker.createFromJson(jsonObject.getObject("speaker"))
                broadcaster = Broadcaster.createFromJson(jsonObject.getObject("broadcaster"))
                datePublished = jsonObject.getString("publishDate")
                preachDate = jsonObject.getString("preachDate")
                sermonId = jsonObject.getString("sermonID")
                fullTitle = jsonObject.getString("fullTitle")
                displayTitle = jsonObject.getString("displayTitle")
                mp3Url = jsonObject.getString("audioFileURL")
                eventType = jsonObject.getString("eventType")
                downloadCount = jsonObject.getInt("downloadCount")
                languageCode = jsonObject.getString("languageCode")
                mp4Url = jsonObject.getString("videoFileURL")
            }
        }
    }
}
