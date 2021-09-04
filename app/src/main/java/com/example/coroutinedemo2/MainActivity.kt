package com.example.coroutinedemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("TAG", "Calculation started ..")
            val s1 = async { getStock1() }
            val s2 = async { getStock2() }
            val sum = s1.await() + s2.await()
            Log.i("TAG", "Calculation Value is .. $sum")
        }
    }
}

private suspend fun getStock1(): Int {
    delay(10000)
    Log.i("TAG", "getStock1 finished")
    return 10000
}
private suspend fun getStock2(): Int {
    delay(8000)
    Log.i("TAG", "getStock2 finished")
    return 5000
}