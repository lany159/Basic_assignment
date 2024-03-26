package com.example.basic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job


class Text1Activity : AppCompatActivity() {
    private var job: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        setRandomValueBetweenOneToHundred()
        setupButton()
        setJobAndLaunch()
    }
    private fun setupButton() {
        val button = findViewById<Button>(R.id.clickButton)
        button.setOnClickListener {
            Log.d("activity", "stop")
            job?.cancel()
            checkAnswerAndShowToast()
        }
    }
    private fun setRandomValueBetweenOneToHundred() {
        val randomTextView = findViewById<TextView>(R.id.textViewRandom)
        val randomValue = (1..100).random()
        randomTextView.setText(randomValue.toString())
    }
    private fun setJobAndLaunch() {
        val textView = findViewById<TextView>(R.id.spartaTextView)

        job = lifecycleScope.launch {
            for (i in 1..100) {
                if (isActive) {
                    textView.text = i.toString()
                    delay(500)
                }
            }
        }
    }
    private fun checkAnswerAndShowToast() {
        val textView = findViewById<TextView>(R.id.spartaTextView)
        val randomTextView = findViewById<TextView>(R.id.textViewRandom)
        if (textView.text.toString() == randomTextView.text.toString()) {
            Toast.makeText(this, "같은 값 입니다", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this,"같은 값이 아닙니다",Toast.LENGTH_SHORT).show()
    }
}
