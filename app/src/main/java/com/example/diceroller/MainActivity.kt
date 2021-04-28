package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice() // Dice roll when app starts

    }
    private fun rollDice() {
        val dice = Dice(numSides = 6) // makes var dice from original class Dice
        val diceRoll = dice.roll() // Rolls dice from roll() function in Class dice and then sets diceRoll var to the value
        val diceImage: ImageView = findViewById(R.id.imageView) // Sets diceImage to the correct I.D for the imageView
        val diceNumber = when (diceRoll) { // on dice roll {number} store the correct image in diceNumber when the dice is rolled
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6 // when has to be exhaustive
        }
        diceImage.setImageResource(diceNumber) // set the imageView to the diceNumber (the number rolled and the correct image)
        diceImage.contentDescription = diceRoll.toString() // Sets the content description of the image to the correct number
    }
}
class Dice(private val numSides: Int) { //creates private class Dice and declares the numSides as an integer
    fun roll(): Int { // creates function roll()
        return (1..numSides).random() //generated the random number for the dice depending on how many sides the dice has
    }
}