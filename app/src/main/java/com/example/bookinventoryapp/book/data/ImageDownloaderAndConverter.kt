package com.example.bookinventoryapp.book.data

import java.net.URL


class ImageDownloaderAndConverter {
    fun downloadImage(): ByteArray {
        val url =
            URL("https://books.google.com/books/content?id=NRWPDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")

        return url.readBytes()
    }
}