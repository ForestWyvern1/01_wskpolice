package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MainRvBinding
import com.example.myapplication.models.MainRvModel

class MainRvAdapter(private val context: Context, private val dataList: List<MainRvModel>) :
    RecyclerView.Adapter<MainRvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.main_rv, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = MainRvBinding.bind(holder.itemView)

        binding.itemTitle.text = dataList[position].title
        binding.itemIcon.setImageResource(dataList[position].icon)

        binding.itemView.setOnClickListener {
            if (dataList[position].title == "PhotoRobot") {
                context.startActivity(Intent(context, PhotoRobotActivity::class.java))
            }
            if (dataList[position].title == "Paint") {
                context.startActivity(Intent(context, PaintActivity::class.java))
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}