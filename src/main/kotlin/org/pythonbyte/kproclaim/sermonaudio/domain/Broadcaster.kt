package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject

class Broadcaster {
    var broadcasterId = ""
    var displayName = ""

    companion object {
        fun createFromJson(jsonObject: JsonObject): Broadcaster {
            val recordingSource = Broadcaster()
            recordingSource.broadcasterId = jsonObject.getString("broadcasterID")
            recordingSource.displayName = jsonObject.getString("displayName")

            return recordingSource
        }
    }
}
