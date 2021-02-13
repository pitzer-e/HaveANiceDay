package com.example.pitzerhaveanice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

private lateinit var enteredName: TextView
private lateinit var enteredPassword: TextView
private lateinit var failMessage: TextView
private var calendar = Calendar.getInstance(TimeZone.getDefault())
private var dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enteredName = findViewById(R.id.nameField)
        enteredPassword = findViewById(R.id.passwordField)
        failMessage = findViewById(R.id.loginFailure)
    }

    fun login(view: View) {
        Log.i("myApp", "user pressed " + (view as Button).text)

        //  password accepted
        if (enteredPassword.text.toString() == "testme" &&
            enteredName.text.toString() == "testu") {

            //  is the day of the week on the weekend?
            if ( dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
                val myIntent = Intent(this, WeekendActivity::class.java)
                startActivity(myIntent)
            }

            //  is the day of the week on a weekday?
            else {
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)
            }
        }

        //  password rejected
        else {
            failMessage.text = "Invalid Credentials"
        }
    }
}