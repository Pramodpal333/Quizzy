package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextBtn = findViewById<Button>(R.id.nextBtn)

        nextBtn.setOnClickListener({
            val intent = Intent(this@MainActivity,Questions::class.java)
        startActivity(intent)
            finish()
        })

//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this@MainActivity,WelcomePage::class.java)
//            startActivity(intent)
//
//        }, 3000)

    }
}