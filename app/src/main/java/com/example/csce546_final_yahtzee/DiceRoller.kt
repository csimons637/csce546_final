package com.example.csce546_final_yahtzee

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity allows users to roll five dice for a Yahtzee style game
 */
class DiceRoller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val roll: Button = findViewById(R.id.roll_button)
        roll.setOnClickListener{rollDice()}
    }

    /**
     * Rolls each of five dice
     * Then updates TextViews with rolled numbers
     */
    private fun rollDice() {
        // die declarations
        val die1 = Dice(6)
        val die2 = Dice(6)
        val die3 = Dice(6)
        val die4 = Dice(6)
        val die5 = Dice(6)
        // dice are rolled
        val diceRoll1 = die1.roll()
        val diceRoll2 = die2.roll()
        val diceRoll3 = die3.roll()
        val diceRoll4 = die4.roll()
        val diceRoll5 = die5.roll()
        // TextViews are created
        val resultText1: TextView = findViewById(R.id.res_window1)
        val resultText2: TextView = findViewById(R.id.res_window2)
        val resultText3: TextView = findViewById(R.id.res_window3)
        val resultText4: TextView = findViewById(R.id.res_window4)
        val resultText5: TextView = findViewById(R.id.res_window5)
        // TextViews are populated with data
        resultText1.text = diceRoll1.toString()
        resultText2.text = diceRoll2.toString()
        resultText3.text = diceRoll3.toString()
        resultText4.text = diceRoll4.toString()
        resultText5.text = diceRoll5.toString()
    }
}

/**
 * A die with a fixed number of sides
 */
class Dice(private val numSides: Int) {
    /**
     * Rolls a random number from 1 to the number of sides
     * then returns the result
     */
    fun roll(): Int {
        return(1..numSides).random()
    }
}
