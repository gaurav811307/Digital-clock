package com.example.digitalclock

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var clockTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        clockTextView = findViewById(R.id.clockTV)

        //Start the clock update
        val handler = Handler()
        val runnable = object : Runnable{
            override fun run() {
                updateClock()
                handler.postDelayed(this,1000) //update every second
            }
        }
        handler.post(runnable)
    }

    private fun updateClock(){
        val currentTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val formattedTime = dateFormat.format(currentTime)
        clockTextView.text = formattedTime
    }
}