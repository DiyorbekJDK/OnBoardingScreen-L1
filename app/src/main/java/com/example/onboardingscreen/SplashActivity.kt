package com.example.onboardingscreen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.onboardingscreen.shared.SharePref

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#ff8800")
        window.decorView.setBackgroundColor(Color.parseColor("#ff8800"))

        val shared = SharePref(this)
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                if (shared.getFinish()) {
                    startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }
        }.start()
    }
}