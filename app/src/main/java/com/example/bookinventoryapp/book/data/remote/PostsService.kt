package com.example.bookinventoryapp.book.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

interface PostsService {

    suspend fun getPosts(): ByteArray

//    suspend fun createPost(postRequest: PostRequest): PostResponse?

    companion object {
        fun create(): PostsService {
            return PostsServiceImpl(
                client = HttpClient(Android) {
//                    install(Logging) {
//                        level = LogLevel.ALL
//                    }
//                    install(JsonFeature) {
//                        serializer = KotlinxSerializer()
//                    }
                }
            )
        }
    }

}