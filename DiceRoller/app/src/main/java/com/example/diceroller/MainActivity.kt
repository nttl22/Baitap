package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var diceImage_1: ImageView
    lateinit var diceImage_2: ImageView
    lateinit var diceImage_3: ImageView
    lateinit var resultText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage_1 = findViewById(R.id.dice_image_1)
        diceImage_2 = findViewById(R.id.dice_image_2)
        diceImage_3 = findViewById(R.id.dice_image_3)
        resultText = findViewById(R.id.result_text)
        val rollButton: Button = findViewById(R.id.roll_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        resetButton.setOnClickListener {
            reset()
        }
    }

    private fun rollDice() {

        var dice_1 = (1..6).random()
        var dice_2 = (1..6).random()
        var dice_3 = (1..6).random()
        diceImage_1.setImageResource(getRandomDiceImage(dice_1))
        diceImage_2.setImageResource(getRandomDiceImage(dice_2))
        diceImage_3.setImageResource(getRandomDiceImage(dice_3))
        resultText.text = "Result: "+(dice_1 + dice_2 + dice_3).toString()
    }

    private fun getRandomDiceImage(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun reset() {
        diceImage_1.setImageResource(R.drawable.dice_1)
        diceImage_2.setImageResource(R.drawable.dice_1)
        diceImage_3.setImageResource(R.drawable.dice_1)
        resultText.text = "Hello!!"
    }
}