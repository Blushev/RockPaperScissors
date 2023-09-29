package com.example.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rockButton: Button
    private lateinit var scissorsButton: Button
    private lateinit var paperButton: Button
    private lateinit var playButton: Button
    private lateinit var resultTextView: TextView

    private var userChoice: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rockButton = findViewById(R.id.rockButton)
        scissorsButton = findViewById(R.id.scissorsButton)
        paperButton = findViewById(R.id.paperButton)
        playButton = findViewById(R.id.playButton)
        resultTextView = findViewById(R.id.resultTextView)

        playButton.setOnClickListener {
            playGame()
        }

        rockButton.setOnClickListener {
            onRockButtonClick()
        }

        scissorsButton.setOnClickListener {
            onScissorsButtonClick()
        }

        paperButton.setOnClickListener {
            onPaperButtonClick()
        }
    }


    private fun playGame() {
        val options = arrayOf("Камень", "Ножницы", "Бумага")
        val random = Random()
        val computerChoice = random.nextInt(3) // Генерируем случайный выбор компьютера

        val computerChoiceText = options[computerChoice]

        // Отображаем выбор пользователя и выбор компьютера перед результатом
        val userChoiceMessage = "Ваш выбор: $userChoice"
        val result = determineWinner(userChoice, computerChoiceText)

        // Отображаем результат игры
        val message = "$userChoiceMessage\nВыбор компьютера: $computerChoiceText\nРезультат: $result"
        resultTextView.text = message
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

    private fun onRockButtonClick() {
        userChoice = "Камень"
        updateButtonState(rockButton)
    }

    private fun onScissorsButtonClick() {
        userChoice = "Ножницы"
        updateButtonState(scissorsButton)
    }

    private fun onPaperButtonClick() {
        userChoice = "Бумага"
        updateButtonState(paperButton)
    }

    private fun updateButtonState(selectedButton: Button) {
        rockButton.isEnabled = true
        scissorsButton.isEnabled = true
        paperButton.isEnabled = true
        selectedButton.isEnabled = false
    }
}