package com.myapp.androidexcercisesdeo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.androidexcercisesdeo.R
import com.myapp.androidexcercisesdeo.models.Content
import com.myapp.androidexcercisesdeo.adapters.ContentListAdapter

class RecycleviewActivity : AppCompatActivity() {

    private lateinit var rvTours: RecyclerView
    private val list = ArrayList<Content>()
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyleview)

        // Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "RecyclerView"

        list.addAll(listTours)

        rvTours = findViewById(R.id.rvTours)
        rvTours.setHasFixedSize(true)
        rvTours.layoutManager = LinearLayoutManager(this)
        rvTours.adapter = ContentListAdapter(this, list){
            val intent = Intent (this, DetailContentActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

    private val listTours: ArrayList<Content>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

            val lists = ArrayList<Content>()
            for (i in dataName.indices) {
                val tour = Content(
                    dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1)
                )
                lists.add(tour)
            }
            return lists
        }

}