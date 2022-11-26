package com.myapp.androidexcercisesdeo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.myapp.androidexcercisesdeo.R
import com.myapp.androidexcercisesdeo.models.Content

class DetailContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_content)

        // Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get Data
        val tour = intent.getParcelableExtra<Content>(RecycleviewActivity.INTENT_PARCELABLE)

        // Set Data
        val tvName: TextView = findViewById(R.id.tvDetailName)
        val tvDescription: TextView = findViewById(R.id.tvDetailDescription)
        val ivPhoto: ImageView = findViewById(R.id.ivDetailPhoto)

        ivPhoto.setImageResource(tour?.photo!!)
        tvName.text = tour.name
        tvDescription.text = tour.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}