package org.pythonbyte.kproclaim.sermonaudio.service

import org.pythonbyte.kproclaim.sermonaudio.domain.Recording

interface BroadcasterService {
    fun createRecording(recording: Recording) : Boolean
}
