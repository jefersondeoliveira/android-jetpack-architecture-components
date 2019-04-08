package com.github.jefersondeoliveira.workmanager

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager: WorkManager = WorkManager.getInstance()

        //conditins
        val conditions: Constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        //sendData
        val data: Data = Data.Builder()
            .putString(MESSAGE_STATUS, "Message send successfully")
            .build()

        val request: OneTimeWorkRequest = OneTimeWorkRequest.Builder(SendWorker::class.java)
            .setConstraints(conditions)
            .setInputData(data)
            .build()


        bSend.setOnClickListener{

            workManager.enqueue(request)

        }

        workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer {workInfo->

            workInfo?.let {

                if(it.state.isFinished){
                    val outputData: Data = it.outputData
                    val taskResult: String? = outputData.getString(SendWorker.WORK_RESULT)
                    tvStatus.append(taskResult + "\n")
                }

                val state: WorkInfo.State = workInfo.state
                tvStatus.append(state.toString() + "\n")
            }

        })

    }

    companion object {
        const val MESSAGE_STATUS = "MESSAGE_STATUS"
    }
}
