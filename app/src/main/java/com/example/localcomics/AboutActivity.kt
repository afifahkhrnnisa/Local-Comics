package com.example.localcomics

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.hide()

        val imgProfile: ImageView = findViewById(R.id.img_profile)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvEmail: TextView = findViewById(R.id.tv_email)


        imgProfile.setImageResource(R.drawable.moon_flower)
        tvName.text = "Your Name"
        tvEmail.text = "your.email@dicoding.com"
    }
}
