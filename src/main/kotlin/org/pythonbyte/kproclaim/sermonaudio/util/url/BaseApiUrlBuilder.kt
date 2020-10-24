package org.pythonbyte.kproclaim.sermonaudio.util.url

import org.pythonbyte.krux.url.mapToUrlParameterString

abstract class BaseApiUrlBuilder: ApiUrlBuilder {
    private val baseUrl = "https://api.sermonaudio.com/"

    abstract fun getBuilderName() : String

    override fun build(version: String, endpoint: String, parameterName: String, parameterValue: String ) : String {
        val endpointUrl = "${baseUrl}v$version/${getBuilderName()}/$endpoint";

        if ( parameterName != "" && parameterValue != "" ) {
            return endpointUrl + "?$parameterName=$parameterValue";
        }

        return endpointUrl;
    }

    override fun build(version: String, endpoint: String, parameterMap: Map<String, String> ) : String {
        val parameterString = mapToUrlParameterString(parameterMap)
        return "${baseUrl}v$version/${getBuilderName()}/$endpoint?$parameterString"
    }
}
