package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val tvShow = findViewById<TextView>(R.id.tvShow)

        val username = intent.getStringExtra("username")

        tvShow.text = "Hii $username"


        val questionList = Constants.getQuestions()
        Log.i("Questions List size is", "${questionList.size}")
    }
}