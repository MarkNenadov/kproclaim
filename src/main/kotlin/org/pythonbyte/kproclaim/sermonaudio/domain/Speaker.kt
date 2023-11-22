package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject

class Speaker {
    var fullName = ""
    var portraitUrl = ""
    var bio = ""

    companion object {
        fun createFromJson(jsonObject: JsonObject): Speaker {
            return Speaker().apply {
                fullName = jsonObject.getString("displayName")
                portraitUrl = jsonObject.getString("portraitURL")

                if (jsonObject.hasKey("bio")) {
                    bio = jsonObject.getString("bio")
                }
            }
        }
    }
}
