package com.example.basic1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.basic1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            val intent = Intent(this, Basic1WeekActivity::class.java)
            startActivity(intent)
        }

        binding.btnClick2.btn1Click.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hyelan-note.tistory.com/128"))
            startActivity(intent)
        }

        binding.btnClick3.btn1Click.setOnClickListener {
            val intent = Intent(this, Basic3WeekActivity::class.java)
            startActivity(intent)
        }
    }
}