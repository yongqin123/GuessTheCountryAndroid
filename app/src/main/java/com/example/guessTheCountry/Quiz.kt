package com.example.guessTheCountry
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.example.guessTheCountry.modal.Question
import com.example.guessTheCountry.utils.Constants

class Quiz : ComponentActivity() {
    private var question = 0
    private var progress = 20
    private var score = 0
    private lateinit var allQuestions : MutableList<Question>
    private lateinit var progressBar : ProgressBar
    private lateinit var progressBarIndicator: TextView
    private lateinit var title: TextView
    private lateinit var optionOne : Button
    private lateinit var optionTwo : Button
    private lateinit var optionThree : Button
    private lateinit var optionFour : Button
    private lateinit var optionFive : Button
    private lateinit var flag : ImageView
    private lateinit var bg : NestedScrollView
    private lateinit var scoreTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        allQuestions = Constants.getQuestions()
        title = findViewById<TextView>(R.id.question)
        optionOne = findViewById<Button>(R.id.optionOne)
        optionTwo = findViewById<Button>(R.id.optionTwo)
        optionThree = findViewById<Button>(R.id.optionThree)
        optionFour = findViewById<Button>(R.id.optionFour)
        optionFive = findViewById<Button>(R.id.optionFive)
        flag = findViewById<ImageView>(R.id.flag)
        scoreTextView = findViewById<TextView>(R.id.score)
        bg = findViewById<NestedScrollView>(R.id.bg)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBarIndicator = findViewById<TextView>(R.id.progressBarIndicator)

        progressBar.setProgress(20)

        if (progressBar.progress == 20) {
            progressBarIndicator.text = "1/5"
        }

        optionOne.setText(allQuestions.get(0).optionArray.get(0))
        optionTwo.setText(allQuestions.get(0).optionArray.get(1))
        optionThree.setText(allQuestions.get(0).optionArray.get(2))
        optionFour.setText(allQuestions.get(0).optionArray.get(3))
        optionFive.setText(allQuestions.get(0).optionArray.get(4))
        createQuestion()
    }


    fun createQuestion() {
        flag.setBackgroundResource(allQuestions.get(question).image)
        if (allQuestions.get(question).correctAnswer == "Singapore") {
            title.setTextColor(ContextCompat.getColor(this,R.color.white))
            bg.setBackgroundResource(R.drawable.singapore_bg)
            optionOne.alpha = 0.5.toFloat()
            optionTwo.alpha = 0.5.toFloat()
            optionThree.alpha = 0.5.toFloat()
            optionFour.alpha = 0.5.toFloat()
            optionFive.alpha = 0.5.toFloat()
            scoreTextView.setTextColor(ContextCompat.getColor(this,R.color.white))
            progressBarIndicator.setTextColor(ContextCompat.getColor(this,R.color.white))
            //val progressDrawable = getResources().getDrawable(R.drawable.custom_progressbar)
            //progressBar.setProgressDrawable(progressDrawable)

        }

        if (allQuestions.get(question).correctAnswer == "England") {
            bg.setBackgroundResource(R.drawable.london)
            title.setTextColor(ContextCompat.getColor(this,R.color.black))
            scoreTextView.setTextColor(ContextCompat.getColor(this,R.color.black))
            progressBarIndicator.setTextColor(ContextCompat.getColor(this,R.color.black))

        }
        if (allQuestions.get(question).correctAnswer == "Malaysia") {
            title.setTextColor(ContextCompat.getColor(this,R.color.white))
            progressBarIndicator.setTextColor(ContextCompat.getColor(this,R.color.white))
            bg.setBackgroundResource(R.drawable.malaysia_bg_1)
        }
        if (allQuestions.get(question).correctAnswer == "Egypt") {
            title.setTextColor(ContextCompat.getColor(this,R.color.white))
            scoreTextView.setTextColor(ContextCompat.getColor(this,R.color.white))
            progressBarIndicator.setTextColor(ContextCompat.getColor(this,R.color.white))
            bg.setBackgroundResource(R.drawable.egypt_bg)
        }
        if (allQuestions.get(question).correctAnswer == "Japan") {
            title.setTextColor(ContextCompat.getColor(this,R.color.black))
            scoreTextView.setTextColor(ContextCompat.getColor(this,R.color.black))
            bg.setBackgroundResource(R.drawable.japan_wave)
            title.setTextColor(ContextCompat.getColor(this,R.color.black))
            progressBarIndicator.setTextColor(ContextCompat.getColor(this,R.color.black))
        }
    }

    fun clickCountryButton(view: View) {

        if (question < 5) {
            val userClickOptionButton = findViewById<Button>(view.id)
            progress += 20
            progressBar.setProgress(progress)
            if (progressBar.progress == 40) {
                progressBarIndicator.text = "2/5"
            }
            if (progressBar.progress == 60) {
                progressBarIndicator.text = "3/5"
            }
            if (progressBar.progress == 80) {
                progressBarIndicator.text = "4/5"
            }
            if (progressBar.progress == 100) {
                progressBarIndicator.text = "5/5"
            }
            if (userClickOptionButton.text.toString() == allQuestions.get(question).correctAnswer) {
                score += 20
                scoreTextView.text = "$score / 100"
            }
            question += 1
            if (question == 5) {
                val intent = Intent(this@Quiz, Congratulations::class.java)
                intent.putExtra("score", score)
                intent.putExtra("name",getIntent().getStringExtra("name"))
                startActivity(intent)
                finish()
            }
            else {
                createQuestion()
            }

        }


    }
}