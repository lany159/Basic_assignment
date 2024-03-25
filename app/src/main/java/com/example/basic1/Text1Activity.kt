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
    val randomValue = (1..100).random()
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
            job?.cancel()
        }
    }

    private fun setRandomValueBetweenOneToHundred() {
        val randomTextView = findViewById<TextView>(R.id.textViewRandom)
        randomTextView.setText(randomValue.toString())
    }

    private fun setJobAndLaunch() {
        val textView = findViewById<TextView>(R.id.spartaTextView)

        job = lifecycleScope.launch {
            for (i in 1..100) {
                if (isActive) {
                    textView.text = i.toString()
                    if (i == randomValue) {
                        toast()
                        break
                    }
                    delay(500)
                }
            }

        }
    }

    private fun toast() {
        Toast.makeText(this, "같은 값 입니다", Toast.LENGTH_SHORT).show()
    }
}
