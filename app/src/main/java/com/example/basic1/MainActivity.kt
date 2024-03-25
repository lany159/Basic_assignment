package com.example.basic1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<LinearLayout>(R.id.btn_click)

        btn.setOnClickListener {
            val intent = Intent(this, Text1Activity::class.java)
            startActivity(intent)
        }
    }
}