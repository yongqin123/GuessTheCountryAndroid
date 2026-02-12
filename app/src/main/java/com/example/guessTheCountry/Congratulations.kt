package com.example.guessTheCountry

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class Congratulations : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations)

        val extras = intent.extras
        val nameEnd = findViewById<TextView>(R.id.nameEnd)
        val scoreEnd = findViewById<TextView>(R.id.scoreEnd)
        val end = findViewById<Button>(R.id.end)

        extras?.let {
            val name = extras.getString("name")
            val score = extras.getInt("score")
            nameEnd.text = name.toString()
            scoreEnd.text = "$score / 100"

        }



        end.setOnClickListener {
            finish()
        }

    }
}