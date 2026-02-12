package com.example.guessTheCountry.modal

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val optionArray: List<String>,
    val correctAnswer: String
)

