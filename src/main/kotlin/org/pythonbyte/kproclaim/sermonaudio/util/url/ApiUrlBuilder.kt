package org.pythonbyte.kproclaim.sermonaudio.util.url

interface ApiUrlBuilder {
    fun build( version: String, endpoint: String, parameterName: String, parameterValue: String ) : String
    fun build( version: String, endpoint: String, parameterMap: Map<String, String> ) : String
}
