package com.example.mysecondunitconverterapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Sometimes we need to delay some function call,for that we use - Handler().postDelayed()

        // Handler() = A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue.
        //.postDelayed() = Causes the Runnable r to be added to the message queue, to be run after the specified amount of time elapses.

        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
               val intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)

                finish()
            }
        }, 3000)

        val animation = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        imageView.startAnimation(animation)
        lottie.startAnimation(animation)
    }
}


