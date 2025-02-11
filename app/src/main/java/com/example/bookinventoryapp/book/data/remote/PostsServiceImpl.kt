package com.example.bookinventoryapp.book.data.remote

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readRawBytes

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {
    override suspend fun getPosts(): ByteArray {
        try {
            val httpResponse: HttpResponse = client.get {
                url("https://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
//                onDownload { bytesSentTotal, contentLength ->
//                    println("Received $bytesSentTotal bytes from $contentLength")
//                }
            }

            return httpResponse.readRawBytes()
        } catch (e: RedirectResponseException) {
            //3XX Response
            Log.e("client_call", e.response.status.description)
            return byteArrayOf()
        } catch (e: ClientRequestException) {
            //4XX Response
            Log.e("client_call", e.response.status.description)
            return byteArrayOf()
        } catch (e: ServerResponseException) {
            //5XX Response
            Log.e("client_call", e.response.status.description)
            return byteArrayOf()
        } catch (e: Exception) {
            // Everything else
            Log.e("client_call", "$e.message")
            return byteArrayOf()
        }
    }

//    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
//        return try {
//            client.post<PostResponse> {
//                url(HttpRoutes.POSTS)
//                contentType(ContentType.Application.Json)
//                body = postRequest
//            }
//        } catch (e: RedirectResponseException) {
//            //3XX Response
//            Log.e("client_call", e.response.status.description)
//            null
//        } catch (e: ClientRequestException) {
//            //4XX Response
//            Log.e("client_call", e.response.status.description)
//            null
//        } catch (e: ServerResponseException) {
//            //5XX Response
//            Log.e("client_call", e.response.status.description)
//            null
//        } catch (e: Exception) {
//            // Everything else
//            Log.e("client_call", "$e.message")
//            null
//        }
//    }
}