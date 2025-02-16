package com.example.bookinventoryapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import com.example.bookinventoryapp.app.App
import com.example.bookinventoryapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Log.d("Permissions", "Granted")
            } else {
                // Handle permission denied
                Log.d("Permissions", "Denied")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setupKoin(this@MainActivity)
            requestPermissions()

//            val book = produceState<List<Book>>(
//                initialValue = emptyList(),
//                producer = {
//                    value = booksService.getBookByIsbn("9780375829871")
//                }
//            )

            App()
        }
    }

    private fun setupKoin(context: Context) {
        stopKoin()
        startKoin {
            androidContext(context)
            modules(
                appModule
            )
        }
    }

    private fun requestPermissions() {
        requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
    }
}