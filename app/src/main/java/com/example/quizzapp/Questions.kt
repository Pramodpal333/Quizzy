package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class Questions : AppCompatActivity() {

    private var progressBar :ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivFlag : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null

   private lateinit var btnCheckAnswer: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        ivFlag = findViewById(R.id.ivFalgs)
        tvQuestion = findViewById(R.id.tvQuestions)

        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)


        val username = intent.getStringExtra("username")




        val questionList = Constants.getQuestions()
        Log.i("Questions List size is", "${questionList.size}")

        for (i in questionList){
            Log.e("Questions",i.question)
        }


        var currentPosition = 1

        val question : Question = questionList[currentPosition-1]
        ivFlag?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"
        tvQuestion?.text =question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text =question.optionTwo
        tvOptionThree?.text =question.optionThree
        tvOptionFour?.text = question.optionFour
    }
}