package com.example.tamagotchiappfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SecActivity : AppCompatActivity() {


    lateinit var Fbutton : Button
    lateinit var Cbutton : Button
    lateinit var Pbutton : Button
    lateinit var CareButton: Button
    lateinit var Iview : ImageView
    lateinit var HealthTextView: TextView

    var petHealth: Int = 100
    val healthDecayRate = 10 // Health decreases every time
    val healthRecoveryRate = 20 // Health increases when cared for


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        Fbutton=findViewById(R.id.FeedButton)
        Cbutton=findViewById(R.id.cleanButton)
        Pbutton=findViewById(R.id.playbutton)
        CareButton = findViewById(R.id.carebutton)
        Iview=findViewById(R.id.imageView)
        HealthTextView = findViewById(R.id.healthTextView)

        // Button actions

        Fbutton.setOnClickListener {
            Iview.setImageResource(R.drawable.feeding_dog)
        }

                Cbutton.setOnClickListener {
                    Iview.setImageResource(R.drawable.clean_dog)
                }

                    Pbutton.setOnClickListener {
                        Iview.setImageResource(R.drawable.playing_dog)
                    }

        CareButton.setOnClickListener {
            careForPet()
        }

        // Start health decay
        startHealthDecay()
    }

    private fun updateHealthDisplay() {
        HealthTextView.text = "Health: $petHealth%"
    }

    private fun careForPet() {
        if (petHealth < 100) {
            petHealth += healthRecoveryRate
            if (petHealth > 100) {
                petHealth = 100 // Cap the health at 100
            }
            updateHealthDisplay()
        }
    }

    private fun startHealthDecay() {
        val handler = Handler()
        val decayRunnable = object : Runnable {
            override fun run() {
                if (petHealth > 0) {
                    petHealth -= healthDecayRate
                    if (petHealth < 0) petHealth = 0
                    updateHealthDisplay()
                }
                handler.postDelayed(this, 10000) // Reduce health every 10 seconds
            }
        }
        handler.post(decayRunnable)
    }
}









