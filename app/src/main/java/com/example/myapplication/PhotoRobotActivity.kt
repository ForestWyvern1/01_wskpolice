package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityPhotoRobotBinding
import com.example.myapplication.models.FileModel
import java.io.InputStream

class PhotoRobotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoRobotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPhotoRobotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            startActivity(Intent(this, NewPhotoRobotActivity::class.java))
        }

        binding.backBtn.setOnClickListener {
            super.onBackPressed()
        }

    }


}