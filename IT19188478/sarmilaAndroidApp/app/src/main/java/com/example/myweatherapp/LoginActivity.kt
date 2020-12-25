package com.example.myweatherapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.*

class LoginActivity : AppCompatActivity() {
    //object of the database
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        handler = DatabaseHelper(this)

        val username=findViewById<TextView>(R.id.loginMail) as EditText
        val userpassword=findViewById<TextView>(R.id.loginPassword) as EditText

        val forgotpassword=findViewById<TextView>(R.id.forgotPassword)
        val signUp=findViewById<TextView>(R.id.signUp)

        val btnLogin=findViewById<TextView>(R.id.btnlogin) as Button
        val facebook=findViewById<TextView>(R.id.btnloginfacebook) as Button
        val google=findViewById<TextView>(R.id.btnlogingoogle) as Button

        // set on-click listener for btnLogin button
        btnLogin.setOnClickListener {

            if(username.text.toString().equals("sarmila") and userpassword.text.toString().equals("12345") ) {
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
            else if ((handler.userPresent(username.toString(), userpassword.toString()))) {
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
            else {
                Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
            //}
            /*
            if(username.text.toString().equals("sarmila") ){
                if(userpassword.text.toString().equals("sarmila") {
                    Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
             }*/

        signUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        //set on-click listener for login facebook
        facebook.setOnClickListener{
            val GooglewebIntent: Intent = Uri.parse("https://www.facebook.com/").let { webpage ->  Intent(Intent.ACTION_VIEW, webpage)}
            startActivity(GooglewebIntent)
            finish()
        }

        //set on-click listener for login google
        google.setOnClickListener{
            val webIntent: Intent = Uri.parse("https://plus.google.com/").let { webpage ->  Intent(Intent.ACTION_VIEW, webpage)}
            startActivity(webIntent)
            finish()
        }

        //set on-click listener for forgotPassword
        forgotpassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, forgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}