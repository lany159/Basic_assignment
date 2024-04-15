package com.example.basic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.basic1.databinding.ActivityBasic3WeekBinding
import com.example.basic1.databinding.ActivityMainBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class Basic3WeekActivity : AppCompatActivity() {

    private var randomValue = (1..100).random()
    private var job: Job? = null
    private lateinit var binding: ActivityBasic3WeekBinding
    private val TAG = "MainActivity"
    private var counter = 1
    private var isChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBasic3WeekBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(binding.root)

        if (savedInstanceState != null) {
            randomValue = savedInstanceState.getInt("random")
            counter = savedInstanceState.getInt("counter")
            if (counter > 100) {
                counter = 100
            }
            binding.spartaTextView.text = counter.toString()

            isChecked = savedInstanceState.getBoolean("isCheck")
            if (isChecked == true) {
                binding.spartaTextView.text = counter.toString()
            }
            Log.i(TAG, "$isChecked")
            Log.i(TAG, "$counter")
            Log.i(TAG, "$randomValue")

        }

        setupButton()
        setRandomValueBetweenOneToHundred()
//        setJobAndLaunch()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
        job?.cancel()
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
        setJobAndLaunch()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
        outState.putInt("counter", counter)
        outState.putInt("random", randomValue)
        outState.putBoolean("isCheck", isChecked)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
    }

    private fun setupButton() {
        binding.clickButton.setOnClickListener {
            checkAnswerAndShowToast()
            job?.cancel()
            isChecked = true
        }
    }

    private fun setRandomValueBetweenOneToHundred() {
        binding.textViewRandom.text = randomValue.toString()
    }

    private fun setJobAndLaunch() {
        job?.cancel()
        job = lifecycleScope.launch {
            if (isActive) {
                while (counter <= 100) {
                    binding.spartaTextView.text = counter.toString()
                    if (isChecked == true) {
                        break
                        //job?.cancel()
                    }
                    delay(500)
                    counter += 1
                }
            }
        }
    }

    private fun checkAnswerAndShowToast() {
        val spartaText = binding.spartaTextView.text.toString()
        val randomText = binding.textViewRandom.text.toString()

        if (spartaText == randomText) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }
}