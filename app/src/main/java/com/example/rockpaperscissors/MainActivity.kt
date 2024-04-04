package com.example.rockpaperscissors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockButton: Button = findViewById(R.id.rockButton)
        val scissorsButton: Button = findViewById(R.id.scissorsButton)
        val paperButton: Button = findViewById(R.id.paperButton)

        rockButton.setOnClickListener {
            startResultActivity("Камень")
        }

        scissorsButton.setOnClickListener {
            startResultActivity("Ножницы")
        }

        paperButton.setOnClickListener {
            startResultActivity("Бумага")
        }
    }

    private fun startResultActivity(choice: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("user_choice", choice)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}