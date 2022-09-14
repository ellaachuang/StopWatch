package com.example.stopwatch

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var startStopButton: Button
    private lateinit var timerChronometer: Chronometer
    private lateinit var resetButton: Button

    //make a classwide static constant in kotlin
    companion object{
        //static constants go here
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()
        var isRunning = false
        var lastPause : Long = 1
        resetButton.setBackgroundColor(Color.rgb(90, 90, 180))
        startStopButton.setBackgroundColor(Color.rgb(40, 120, 40))

        startStopButton.setOnClickListener{
            if (isRunning) {
                startStopButton.text = "START"
                startStopButton.setBackgroundColor(Color.rgb(40, 120, 40))
                isRunning = false
                lastPause = SystemClock.elapsedRealtime()
                timerChronometer.stop()
            } else {
                startStopButton.text = "STOP"
                startStopButton.setBackgroundColor(Color.rgb(200, 80, 80))
                isRunning = true
                timerChronometer.setBase(SystemClock.elapsedRealtime())
                timerChronometer.setBase(timerChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause)
                timerChronometer.start()
            }
        }

        resetButton.setOnClickListener {
            timerChronometer.setBase(SystemClock.elapsedRealtime());
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    private fun wireWidgets() {
        startStopButton = findViewById(R.id.button_main_start)
        resetButton = findViewById(R.id.button_main_reset)
        timerChronometer = findViewById(R.id.chronometer_main_stopwatch)
    }





}