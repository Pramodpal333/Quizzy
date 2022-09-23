package com.example.quizzapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class Questions : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition:  Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedItemPostion: Int = 0


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

        btnCheckAnswer = findViewById(R.id.btnCheckAnswer)

        val username = intent.getStringExtra("username")

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnCheckAnswer?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()


        getQuestions()

    }

    private fun getQuestions() {

        var mCurrentPosition = 1

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivFlag?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnCheckAnswer.text = "Finish"
        } else{btnCheckAnswer.text = "Submit"}
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0, it)
        }

        tvOptionTwo?.let {
            options.add(1, it)
        }

        tvOptionThree?.let {
            options.add(2, it)
        }

        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(ContextCompat.getColor(this, R.color.muted_text))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.options_bg)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNUm: Int){

        defaultOptionsView()
        mSelectedItemPostion = selectedOptionNUm

        tv.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option)

    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.tvOptionOne -> { tvOptionOne?.let { selectedOptionView(it,1) } }

            R.id.tvOptionTwo -> {tvOptionTwo?.let { selectedOptionView(it,2) }}

            R.id.tvOptionThree -> {tvOptionThree?.let { selectedOptionView(it,3) }}

            R.id.tvOptionFour -> {tvOptionFour?.let { selectedOptionView(it,4) }}

            R.id.btnCheckAnswer -> {
               if (mSelectedItemPostion == 0){
                   mCurrentPosition ++
                   when{
                       mCurrentPosition <= mQuestionList!!.size -> {
                           getQuestions()
                       }
                   }

               } else{
                   val question = mQuestionList?.get(mCurrentPosition-1)
                   if (question!!.correctAnswer !=  mSelectedItemPostion){
                       answerView(mSelectedItemPostion, R.drawable.wrong_answer)
                   }
                   answerView(question.correctAnswer, R.drawable.correct_answer)
               }
            }
        }

    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1 -> { tvOptionOne?.background= ContextCompat.getDrawable(this,drawableView)}

            2 -> {tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)}

            3 -> {tvOptionThree?.background = ContextCompat.getDrawable(this,drawableView)}

            4 -> {tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)}
        }
    }
}