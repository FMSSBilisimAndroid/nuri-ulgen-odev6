package com.nuriulgen.odev6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var counter= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        while(true){
            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main){
                    Log.v("PATIKA",answer)
                }
                counter++
                println("Counter: $counter")
            }
        }

    }
    private suspend fun doNetworkCall(): String {
        delay(2000L)
        return "Network Answer Called"
    }
}