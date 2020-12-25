package com.example.myweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    //object of the database
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        handler = DatabaseHelper(this)

        val username = findViewById<TextView>(R.id.resetMail)
        val mail = findViewById<TextView>(R.id.inputRegemail)
        val regPass = findViewById<TextView>(R.id.inputRegPassword)
        val regCoPAss = findViewById<TextView>(R.id.inputConformPassword)

        val txterror = findViewById<TextView>(R.id.txterror)

        val allreadyAcc = findViewById<TextView>(R.id.alreadyHaveAccount)

        val btnRegLogin = findViewById<TextView>(R.id.btnReg) as Button

//on click activity for already Have Account
        allreadyAcc.setOnClickListener {
            val Altintent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(Altintent)
            finish()
        }

//on click activity for Register New account Account

        btnRegLogin.setOnClickListener {
            if (username.text.toString().isEmpty() or mail.text.toString().isEmpty() or regPass.text.toString().isEmpty() or !regPass.text.toString().equals(regCoPAss.text.toString())) {

                txterror.text = "Please fill empty fields or check password"

            }
            else {
                handler.insertUserData(username.text.toString(), mail.text.toString(), regPass.text.toString())
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}



 /*if (mail.text.toString().isEmpty()) {
                txterror.text = "Please enter your Mail Address"
            } else if (regPass.text.toString().isEmpty()) {
                if (regPass.length() <= 5) {
                    txterror.text = "Please enter your check Password "
                }
            }
            else if (regPass != regCoPAss) {
                txterror.text = "Please enter your Name"
            } else

                if(handler.userPresent(mail.text.toString(), regPass.text.toString())){
                    Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "fail to Login", Toast.LENGTH_SHORT).show()
            }

---------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------


            val intent = Intent(this,LoginActivity)
            startActivity(intent)*/
// handle button click
/*
btnReg.setOnClickListener{
    //get text from edit texts
    var name =username.text.toString()
    var mail =mail.text.toString()
    var password =regPass.text.toString()

    val intent= Intent(this@RegisterActivity,LoginActivity::class.java)
    intent.putExtra("Name",name)
    intent.putExtra("Mail",mail)
    intent.putExtra("Password",password)

    startActivity(intent)
}
*/