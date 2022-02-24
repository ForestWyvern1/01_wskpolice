package com.example.myapplication

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityNewPhotoRobotBinding
import com.example.myapplication.models.FileModel

class NewPhotoRobotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewPhotoRobotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewPhotoRobotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val files = getFileList(this)

        binding.topVp.adapter = PhotoRobotVPAdapter(this, files.topList)
        binding.middleVp.adapter = PhotoRobotVPAdapter(this, files.midleList)
        binding.bottomVp.adapter = PhotoRobotVPAdapter(this, files.bottomList)

        clicks()

        binding.backBtn.setOnClickListener {
            super.onBackPressed()
        }

        binding.saveBtn.setOnClickListener {
            super.onBackPressed()
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

    }

    private fun clicks(){

        binding.topStart.setOnClickListener {
            binding.topVp.currentItem --
        }
        binding.topEnd.setOnClickListener {
            binding.topVp.currentItem ++
        }
        binding.middleStart.setOnClickListener {
            binding.middleVp.currentItem --
        }
        binding.middleEnd.setOnClickListener {
            binding.middleVp.currentItem ++
        }
        binding.bottomStart.setOnClickListener {
            binding.bottomVp.currentItem --
        }
        binding.bottomEnd.setOnClickListener {
            binding.bottomVp.currentItem ++
        }

    }

    private fun getFileList(context: Context) : FileModel {

        val topFiles = ArrayList<Drawable>()
        val middleFiles = ArrayList<Drawable>()
        val bottomFiles = ArrayList<Drawable>()
        val assetManager = context.assets

        for(i in assetManager.list("")!!){

            if (i.contains("top")){
                val drawable = Drawable.createFromStream(assetManager.open(i), "")
                topFiles.add(drawable)
            }
            if (i.contains("middle")){
                val drawable = Drawable.createFromStream(assetManager.open(i), "")
                middleFiles.add(drawable)
            }
            if (i.contains("bottom")){
                val drawable = Drawable.createFromStream(assetManager.open(i), "")
                bottomFiles.add(drawable)
            }

        }

        return FileModel(topFiles, middleFiles, bottomFiles)

    }
}