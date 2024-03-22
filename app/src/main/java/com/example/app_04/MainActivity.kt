package com.example.app_04

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var txtResult: TextView
    private lateinit var btnScissors: ImageButton
    private lateinit var btnRock: ImageButton
    private lateinit var btnPaper: ImageButton
    private lateinit var imageView: ImageView


    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResult = findViewById(R.id.txtResult)
        btnScissors = findViewById(R.id.imbtnScissor)
        btnRock = findViewById(R.id.imbtnRock)
        btnPaper = findViewById(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageView)

        btnScissors.setOnClickListener {
            playGame(Choice.SCISSORS)
        }
        btnRock.setOnClickListener {
            playGame(Choice.ROCK)
        }
        btnPaper.setOnClickListener {
            playGame(Choice.PAPER)
        }
    }
    enum class Choice{
        SCISSORS, ROCK, PAPER
    }
    private fun playGame(playerChoice: Choice){
        val choices = Choice.values()
        val computerChoice = choices[Random().nextInt(choices.size)]

        when{
            computerChoice == Choice.SCISSORS -> {
                imageView.setImageResource(R.drawable.scissor)
            }
            computerChoice == Choice.ROCK -> {
                imageView.setImageResource(R.drawable.rock)
            }
            computerChoice == Choice.PAPER -> {
                imageView.setImageResource(R.drawable.paper)
            }
        }

        when{
            playerChoice == computerChoice -> {
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice ==Choice.ROCK)  -> {
                txtResult.setText(R.string.win)
            }
            else -> {
                txtResult.setText(R.string.lose)
            }
        }
    }
    private fun getChoiceString(choice: Choice): Int{
        return when(choice){
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }
}