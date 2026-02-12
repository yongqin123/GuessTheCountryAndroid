package com.example.guessTheCountry

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val submit = findViewById<Button>(R.id.submit)
        val name = findViewById<EditText>(R.id.name)
        submit.setOnClickListener {
            if (name.text.toString().isEmpty() == false) {
                val intent = Intent(this@MainActivity, Quiz::class.java)
                intent.putExtra("name",name.text.toString())
                startActivity(intent)
                //finish()
            }
            else {
                Toast.makeText(this@MainActivity, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}