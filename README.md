# kproclaim
A Kotlin interface to SermonAudio's API endpoints (https://api.sermonaudio.com/). Also see [kproclaim-server](https://github.com/MarkNenadov/kproclaim), which implements this interface to provide a GraphQL API.

### TODO ###

* Figure out why supposedly optional request parameter "sourceID" on speakers_for_source endpoint doesn't behave as the documentation at https://api.sermonaudio.com/ indicates. 
* Finish create_sermon endpoint
* Implement upload_audio
