package com.example.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import vcmsa.ci.flashcardsapp.R


class FlashcardActivity : AppCompatActivity() {


    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button


    private val questions = arrayOf(
        "Nelson Mandela was South Africa's first Black president.",
        "The apartheid system officially ended in 1994.",
        "The discovery of gold in Johannesburg in 1880s had no major impact on South Africa's economy.",
        "The Anglo-Zulu War took place in the 20th century.",
        "The Truth and Reconciliation Commission was established to address human rights violations during apartheid."
    )

    private val answers = arrayOf(true, true, false, false, true)


    private var currentQuestionIndex = 0
    private var score = 0
    private var answerSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard_model)


        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)


        feedbackTextView.visibility = View.INVISIBLE
        nextButton.isEnabled = false


        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener { moveToNextQuestion() }


        displayQuestion()
    }


    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.visibility = View.INVISIBLE
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false
        answerSelected = false
    }


    private fun checkAnswer(userAnswer: Boolean) {

        if (answerSelected) return

        answerSelected = true
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct!"
            score++
        } else {
            feedbackTextView.text = "Incorrect"
        }

        feedbackTextView.visibility = View.VISIBLE
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }

    private fun moveToNextQuestion() {
        currentQuestionIndex++

        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {

            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL_QUESTIONS", questions.size)
            startActivity(intent)
            finish()
        }
    }
}