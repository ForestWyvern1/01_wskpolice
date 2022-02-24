package com.example.myapplication

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.PhotoRobotVpBinding

class PhotoRobotVPAdapter(
    private val context: Context,
    private val listImages: ArrayList<Drawable>
) : RecyclerView.Adapter<PhotoRobotVPAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.photo_robot_vp, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = PhotoRobotVpBinding.bind(holder.itemView)

        binding.image.setImageDrawable(listImages[position])

    }

    override fun getItemCount(): Int = listImages.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}