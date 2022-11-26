package com.myapp.androidexcercisesdeo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.androidexcercisesdeo.R
import com.myapp.androidexcercisesdeo.models.Content

class ContentListAdapter(private val context: Context, private val tour: ArrayList<Content>, val listener: (Content) -> Unit)
    : RecyclerView.Adapter<ContentListAdapter.TourViewHolder>() {

    class TourViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivPhoto: ImageView = itemView.findViewById(R.id.ivPhoto)

        fun bindView(tour: Content, listener: (Content) -> Unit) {
            tvName.text = tour.name
            tvDescription.text = tour.description
            ivPhoto.setImageResource(tour.photo)

            itemView.setOnClickListener {
                listener(tour)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_list_item, parent, false)
        return TourViewHolder(view)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bindView(tour[position], listener)
    }

    override fun getItemCount(): Int {
        return tour.size
    }
}