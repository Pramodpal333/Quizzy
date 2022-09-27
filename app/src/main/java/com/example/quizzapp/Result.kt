package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvScore = findViewById<TextView>(R.id.tvScrore)
        val btnFinish: Button = findViewById(R.id.btnFinish)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestion =  intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        tvName.text = userName

        tvScore.text = "You scored $correctAnswers out of $totalQuestion"


        btnFinish.setOnClickListener{
            startActivity( Intent(this,WelcomePage::class.java))
            finish()
        }

    }
}