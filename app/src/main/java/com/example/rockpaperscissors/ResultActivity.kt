package com.example.rockpaperscissors

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val userChoice = intent.getStringExtra("user_choice")

        val resultTextView: TextView = findViewById(R.id.resultTextView)

        if (userChoice != null) {
            val computerChoice = getComputerChoice()
            val result = determineWinner(userChoice, computerChoice)
            val message = "Ваш выбор: $userChoice\nВыбор компьютера: $computerChoice\nРезультат: $result"
            resultTextView.text = message
        } else {
            resultTextView.text = "Ошибка: выбор пользователя отсутствует"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getComputerChoice(): String {
        val options = arrayOf("Камень", "Ножницы", "Бумага")
        return options[(0..2).random()]
    }

    private fun determineWinner(userChoice: String, computerChoice: String): String {
        return when {
            userChoice == computerChoice -> "Ничья!"
            (userChoice == "Камень" && computerChoice == "Ножницы") ||
                    (userChoice == "Ножницы" && computerChoice == "Бумага") ||
                    (userChoice == "Бумага" && computerChoice == "Камень") -> "Вы победили!"
            else -> "Компьютер победил!"
        }
    }
}