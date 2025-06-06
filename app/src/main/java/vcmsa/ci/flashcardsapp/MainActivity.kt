package com.example.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import vcmsa.ci.flashcardsapp.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the Start button and set its click listener
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            // Create an intent to start the FlashcardActivity
            val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
        }
    }
}