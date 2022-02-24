package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.guestBtn.setOnClickListener {

            binding.guestBtn.visibility = View.GONE
            binding.signInBtn.visibility = View.GONE

            binding.captchaBar.visibility = View.VISIBLE

        }

        binding.okBtn.setOnClickListener {

            if (binding.enterCaptcha.text.toString() == "ic8") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else Toast.makeText(this, "Incorrect Captcha", Toast.LENGTH_SHORT).show()

        }

    }
}