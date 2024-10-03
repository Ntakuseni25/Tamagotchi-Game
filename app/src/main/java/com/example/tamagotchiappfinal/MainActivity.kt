package com.example.tamagotchiappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var sbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sbutton = findViewById(R.id.startButton)

        sbutton.setOnClickListener {
            val intent1 = Intent(this, SecActivity::class.java)
            startActivity(intent1)

        }
    }
}