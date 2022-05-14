package me.hirotask.android.testapp

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var START_TIME : Long = 10000

    var timerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textViewCountDown : TextView = findViewById(R.id.text_view_countdown)
        val buttonStartPause : Button= findViewById(R.id.button_start_pause)
        val buttonReset : Button = findViewById(R.id.button_reset)

        textViewCountDown.text = "${(START_TIME / 1000)}"

        buttonStartPause.isEnabled = true
        buttonReset.isEnabled = true

        val timer = object : CountDownTimer(START_TIME, 100) {
            override fun onTick(millisUntilFinished: Long) {
                textViewCountDown.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                textViewCountDown.text = "Time UP"

                buttonStartPause.isEnabled = false
                buttonReset.isEnabled = true

            }
        }

        textViewCountDown.setOnClickListener {
            if(!timerRunning) {
                //Text押して、時間を変えられるようにしたい
            }
        }

        buttonStartPause.setOnClickListener {
            if(timerRunning) {
                timer.cancel()

                buttonStartPause.text = "スタート"

                buttonReset.isEnabled = true
            } else {
                timer.start()

                buttonStartPause.text = "一時停止"
                buttonReset.isEnabled = false
            }
            timerRunning = !timerRunning

        }

        buttonReset.setOnClickListener {
            timer.cancel()
            textViewCountDown.text = "${START_TIME / 1000}"

            buttonStartPause.isEnabled = true
            buttonReset.isEnabled = false
        }





    }
}