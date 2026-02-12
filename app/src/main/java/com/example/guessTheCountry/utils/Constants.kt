package com.example.guessTheCountry.utils
import com.example.guessTheCountry.R
import com.example.guessTheCountry.modal.Question

object Constants {
    fun getQuestions() : MutableList<Question> {
        val questions = mutableListOf<Question>()
        val flags = mutableListOf<Int>(R.drawable.malaysia, R.drawable.england, R.drawable.singapore, R.drawable.japan, R.drawable.egypt)
        val questionName = "What is this country?"
        val options = mutableListOf<String>("Singapore", "Malaysia", "Egypt", "Japan", "England")
        val correctAns = mutableListOf<String>("Malaysia", "England", "Singapore", "Japan", "Egypt")
        val list = mutableListOf<Int>(0,1,2,3,4)
        val randomisedList = list.shuffled()

        for (i in randomisedList) {
            val question = Question(i, questionName, flags.get(i),options, correctAns.get(i))
            questions.add(question)
        }
        return questions
    }
}