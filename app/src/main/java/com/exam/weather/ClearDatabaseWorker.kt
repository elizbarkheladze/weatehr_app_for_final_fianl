package com.exam.weather

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.exam.weather.db.DatabaseHelper

class ClearDatabaseWorker(private val context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        DatabaseHelper(context).nukeTable()
        return Result.success()
    }

}
