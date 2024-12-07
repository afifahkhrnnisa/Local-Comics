package com.example.localcomics

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Comic>("key_hero", Comic::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Comic>("key_hero")
        }

        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvLikes: TextView = findViewById(R.id.tv_detail_likes)
        val tvGenre: TextView = findViewById(R.id.tv_detail_genre)
        val tvStatus: TextView = findViewById(R.id.tv_detail_status)
        val tvAuthor: TextView = findViewById(R.id.tv_detail_author)
        val shareIcon: ImageView = findViewById(R.id.icon_share)

        dataHero?.let {
            imgPhoto.setImageResource(it.photo)
            tvName.text = it.name
            tvDescription.text = it.description
            tvLikes.text = resources.getStringArray(R.array.data_rate)[intent.getIntExtra("position", 0)]
            tvGenre.text = resources.getStringArray(R.array.data_genre)[intent.getIntExtra("position", 0)]
            tvStatus.text = resources.getStringArray(R.array.data_status)[intent.getIntExtra("position", 0)]
            tvAuthor.text = resources.getStringArray(R.array.data_author)[intent.getIntExtra("position", 0)]
        }

        shareIcon.setOnClickListener {
            shareContent()
        }
    }

    private fun shareContent() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Check out this webtoon!")
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

}