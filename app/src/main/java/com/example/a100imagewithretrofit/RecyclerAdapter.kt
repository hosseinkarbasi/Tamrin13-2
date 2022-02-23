package com.example.a100imagewithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(private val homeFeed: FlickrResult) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.show_image, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return homeFeed.photos.photo.count()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val photos = homeFeed.photos.photo[position]
        holder.tvTitle.text = photos.title

        Glide
            .with(holder.view.context)
            .load(photos.url_s)
            .into(holder.imgView)
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    var tvTitle: TextView = view.findViewById(R.id.title)
    var imgView: ImageView = view.findViewById(R.id.Img01)
}