package org.pythonbyte.kproclaim.sermonaudio.util.transport

import org.pythonbyte.kproclaim.sermonaudio.util.url.BroadcasterApiUrlBuilder
import org.pythonbyte.kproclaim.sermonaudio.util.url.NodeApiUrlBuilder
import khttp.responses.Response

class SermonAudioHttp( apiKey : String ) {
    private val postHeaders = mapOf( "X-Api-Key" to apiKey )

    private fun post( url : String ) : Response {
        return khttp.post( url=url, headers=postHeaders )
    }

    fun get( url : String ) : Response {
        println("get request [$url]")
        return khttp.get( url=url, headers=postHeaders )
    }

    fun postBroadcaster( version: String, endpoint: String, parameterMap: Map<String, String> ) : Response {
        return post( url= BroadcasterApiUrlBuilder().build( version, endpoint, parameterMap ) )
    }

    fun getNode( version: String, endpoint: String, parameterName: String, parameterValue: String ) : Response {
        return get( url= NodeApiUrlBuilder().build( version, endpoint, parameterName, parameterValue) )
    }
}