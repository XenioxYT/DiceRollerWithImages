package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() } //this is test

    }
    private fun rollDice() {
        val dice = Dice(numSides = 6) // makes var dice from original class Dice
        val dice2 = Dice(numSides = 6) //makes var Dice2 from original class Dice
        val diceRoll = dice.roll() //makes diceRoll2 from Dice function
        val diceRoll2 = dice2.roll() //makes diceRoll2 from Dice function
        val resultTextView: TextView = findViewById(R.id.firstDice) //target change in textView to first dice.
        resultTextView.text = diceRoll.toString() //pushes the change in text to var diceRoll and converts to string
        val resultTextView2: TextView = findViewById(R.id.secondDice/* specifies the textView that changes*/) //target change in textView to second dice.
        resultTextView2.text = diceRoll2.toString() // pushes the change in text to var diceRoll and converts to string

    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}