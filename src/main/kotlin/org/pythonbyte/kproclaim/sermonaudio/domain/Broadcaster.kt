package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject

class Broadcaster {
    var broadcasterId = ""
    var displayName = ""

    companion object {
        fun createFromJson(jsonObject: JsonObject): Broadcaster {
            return Broadcaster().apply {
                broadcasterId = jsonObject.getString("broadcasterID")
                displayName = jsonObject.getString("displayName")
            }
        }
    }
}
