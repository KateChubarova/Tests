package com.example.tests.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tests.R
import com.example.tests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.setTextColor(Color.RED)
        binding.textView.tag = 100
        binding.button.setOnClickListener {
            var text = binding.editText.text.toString()
            if (text.isEmpty()) {
                text = getString(R.string.empty_text)
            }
            binding.textView.text = text
        }
    }
}