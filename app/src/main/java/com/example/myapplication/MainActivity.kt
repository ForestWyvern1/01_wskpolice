package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.MainRvModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Attention")
            .setMessage("You signed in as a Guest")
            .show()

        val dataList = listOf<MainRvModel>(
            MainRvModel("Departments", R.drawable.ic_departments),
            MainRvModel("Wanted", R.drawable.ic_wanted),
            MainRvModel("PhotoRobot", R.drawable.ic_photo_robot),
            MainRvModel("Paint", R.drawable.ic_paint)
        )

        binding.mainRv.layoutManager = LinearLayoutManager(this)
        binding.mainRv.adapter = MainRvAdapter(this, dataList)

        binding.aboutUsBtn.setOnClickListener {

            startActivity(Intent(this, AboutUsActivity::class.java))

        }

        binding.backBtn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

    }
}