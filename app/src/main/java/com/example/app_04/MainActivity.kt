package com.example.app_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var imcomputer: TextView
    private lateinit var txtResult: TextView
    private lateinit var imbtnScissors: ImageView
    private lateinit var imbtnRock: ImageView
    private lateinit var imbtnPaper: ImageView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imcomputer = findViewById(R.id.imcomputer)
        txtResult = findViewById(R.id.txtResult)
        imbtnScissors = findViewById(R.id.imbtnScissor)
        imbtnRock = findViewById(R.id.imbtnRock)
        imbtnPaper = findViewById(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageView)

        imbtnScissors.setOnClickListener {
            imageView.setImageResource(R.drawable.scissor)
            playGame(Choice.SCISSORS)
        }
        imbtnRock.setOnClickListener {
            playGame(Choice.ROCK)
        }
        imbtnPaper.setOnClickListener {
            playGame(Choice.PAPER)
        }
    }
    enum class Choice{
        SCISSORS, ROCK, PAPER
    }
    fun playGame(playerChoice: Choice){
        val choices = Choice.values()
        val computerChoice = choices[Random().nextInt(choices.size)]

        when{
            playerChoice == computerChoice -> {
                imcomputer.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS)||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) -> {
                imcomputer.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.win)
            }
            else -> {
                imcomputer.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
            }
        }
    }
    fun getChoiceString(choice: Choice): Int{
        return when(choice){
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }
}