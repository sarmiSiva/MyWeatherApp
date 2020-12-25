package com.example.myweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class forgotPasswordActivity : AppCompatActivity() {
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val username=findViewById<TextView>(R.id.resetMail) as EditText
        val userNewpassword=findViewById<TextView>(R.id.NewPasswor) as EditText
        val resetBut = findViewById<TextView>(R.id.btnRestPassword) as Button

        handler = DatabaseHelper(this)

        resetBut.setOnClickListener{
          if (handler.resetPassword(username.toString(),userNewpassword.toString())){
              Toast.makeText(this,"Successfully Changed Password", Toast.LENGTH_SHORT).show()

              val intent = Intent(this@forgotPasswordActivity, LoginActivity::class.java)
              startActivity(intent)
              finish()
          }
            else{
              Toast.makeText(this,"Please check your mail address", Toast.LENGTH_SHORT).show()
          }
        }

    }
}