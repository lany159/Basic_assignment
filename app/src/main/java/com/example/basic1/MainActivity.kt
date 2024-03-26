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
        val btn2 = findViewById<LinearLayout>(R.id.btn1_click)
//include는 참조하는 태그일뿐 뷰가 아니기 때문에  findViewById로 사용할 수 없음
        btn.setOnClickListener {
            val intent = Intent(this, Text1Activity::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, Text2Activity::class.java)
            startActivity(intent)
        }
    }
}