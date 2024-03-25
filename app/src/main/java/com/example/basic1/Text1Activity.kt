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

    //    val randomValue = (1..100).random()
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
//      randomTextView.text = randomValue.toString()
//      setText > EditText(입력받는 위젯)에 쓰이는 함수
    }

    private fun setJobAndLaunch() {
        val textView = findViewById<TextView>(R.id.spartaTextView)

        job = lifecycleScope.launch {
            for (i in 1..100) {
                if (isActive) {
                    textView.text = i.toString()
//                    if (i == randomValue) {
//                        toast()
//                        break
//                    }
                    delay(500)
                }
            }

        }
    }

//    private fun toast() {
//        Toast.makeText(this, "같은 값 입니다", Toast.LENGTH_SHORT).show()
//    }

    private fun checkAnswerAndShowToast() {
        val textView = findViewById<TextView>(R.id.spartaTextView)
        val randomTextView = findViewById<TextView>(R.id.textViewRandom)
        if (textView.text.toString().toInt() == randomTextView.text.toString().toInt()) {
            Toast.makeText(this, "같은 값 입니다", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this,"같은 값이 아닙니다",Toast.LENGTH_SHORT).show()
    }
}