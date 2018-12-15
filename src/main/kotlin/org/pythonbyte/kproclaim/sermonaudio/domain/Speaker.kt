package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject

class Speaker {
    var fullName = ""
    var portraitUrl = ""
    var bio = ""

    companion object {
        fun createFromJson(jsonObject: JsonObject): Speaker {
            val speaker = Speaker()
            speaker.fullName = jsonObject.getString("displayName")
            speaker.portraitUrl = jsonObject.getString("portraitURL")

            if (jsonObject.hasKey("bio")) {
                speaker.bio = jsonObject.getString("bio")
            }

            return speaker
        }
    }
}