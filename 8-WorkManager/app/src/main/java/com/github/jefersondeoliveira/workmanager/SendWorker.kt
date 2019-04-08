package com.github.jefersondeoliveira.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v4.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class SendWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {

    override fun doWork(): Result {

        val taskdata: Data = inputData
        val taskDataString: String? = taskdata.getString(MainActivity.MESSAGE_STATUS)

        showNotifications("Work Manager", taskDataString ?:"Message Send")

        val outputDate:Data = Data.Builder().putString(WORK_RESULT, "Task Finished").build()

        return Result.success(outputDate)

    }

    private fun showNotifications(title: String, message: String){

        val manager: NotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "message_channel"
        val channelName = "message_name"

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)

            manager.createNotificationChannel(channel)

        }

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)

        manager.notify(1, builder.build())

    }

    companion object {
        const val WORK_RESULT = "WORK_RESULT"
    }

}