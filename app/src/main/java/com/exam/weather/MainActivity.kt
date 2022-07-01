package com.exam.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clearDatabaseWorker = PeriodicWorkRequest.Builder(
            ClearDatabaseWorker::class.java,
            1,
            TimeUnit.HOURS
        ).build()

        WorkManager.getInstance(this)
            .enqueue(clearDatabaseWorker)
    }
}
