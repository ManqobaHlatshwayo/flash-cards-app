package com.example.flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.flashcardsapp.R


class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)


        val questions = arrayOf(
            "Nelson Mandela was South Africa's first Black president.",
            "The apartheid system officially ended in 1994.",
            "The discovery of gold in Johannesburg in 1880s had no major impact on South Africa's economy.",
            "The Anglo-Zulu War took place in the 20th century.",
            "The Truth and Reconciliation Commission was established to address human rights violations during apartheid."
        )

        val answers = arrayOf(true, true, false, false, true)


        val reviewLinearLayout = findViewById<LinearLayout>(R.id.reviewLinearLayout)


        for (i in questions.indices) {
            val questionTextView = TextView(this)
            questionTextView.text = getString(R.string.review_question, i + 1, questions[i])
            questionTextView.textSize = 16f
            questionTextView.setPadding(0, 16, 0, 8)
            reviewLinearLayout.addView(questionTextView)

            val answerTextView = TextView(this)
            val answerText = if (answers[i]) "True" else "False"
            answerTextView.text = getString(R.string.review_answer, answerText)
            answerTextView.textSize = 16f
            answerTextView.setPadding(32, 0, 0, 24)
            reviewLinearLayout.addView(answerTextView)
        }


        val backButton = findViewById<Button>(R.id.backToScoreButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}