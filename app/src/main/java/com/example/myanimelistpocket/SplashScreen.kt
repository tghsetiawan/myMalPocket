package com.example.myanimelistpocket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

//    private val SPLASHTIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
//
//        Handler().postDelayed({
//            startActivity(Intent(this, MainActivity::class.java))
//        }, SPLASHTIME)

//        Handler().postDelayed({
//            startActivity(Intent(this, MainActivity::class.java))
//
//        }, 3000)

        Handler().postDelayed(Runnable {
            val i = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}