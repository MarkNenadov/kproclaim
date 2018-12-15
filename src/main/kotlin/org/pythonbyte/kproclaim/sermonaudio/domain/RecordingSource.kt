package org.pythonbyte.kproclaim.sermonaudio.domain

import org.pythonbyte.krux.json.JsonObject

class RecordingSource {
    var sourceId = ""
    var displayName = ""

    companion object {
        fun createFromJson(jsonObject: JsonObject): RecordingSource {
            val recordingSource = RecordingSource()
            recordingSource.sourceId = jsonObject.getString("sourceID")
            recordingSource.displayName = jsonObject.getString("displayName")

            return recordingSource
        }
    }
}
