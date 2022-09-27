package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WelcomePage : AppCompatActivity() {

    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val etUsername = findViewById<EditText>(R.id.etUsername)

        var checkName: String? = null

        btnSubmit.setOnClickListener{
                checkName = etUsername.text.toString()

                if (checkName.isNullOrEmpty()){
                    Toast.makeText(this,"Please Enter your Name",Toast.LENGTH_LONG).show()
                } else {
                    val intent = Intent(this@WelcomePage, Questions::class.java)
                    intent.putExtra(Constants.USER_NAME, checkName)
                    startActivity(intent)


                }

            }

    }
}