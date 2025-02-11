package com.example.bookinventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bookinventoryapp.app.App
import com.example.bookinventoryapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            stopKoin()
            startKoin {
                androidContext(this@MainActivity)
                modules(
                    appModule
                )
            }

//            val book = produceState<List<Book>>(
//                initialValue = emptyList(),
//                producer = {
//                    value = booksService.getBookByIsbn("9780375829871")
//                }
//            )

            App()
        }
    }
}