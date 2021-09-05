package com.example.tic_tac_toe


import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buClick(view: View) {

        val buSelected=view as Button
        var cellID=0
        when(buSelected.id){
            R.id.btn1->cellID=1
            R.id.btn2->cellID=2
            R.id.btn3->cellID=3
            R.id.btn4->cellID=4
            R.id.btn5->cellID=5
            R.id.btn6->cellID=6
            R.id.btn7->cellID=7
            R.id.btn8->cellID=8
            R.id.btn9->cellID=9

        }
        playGame(cellID,buSelected)

    }
    var player1= arrayListOf<Int>()
    var player2= arrayListOf<Int>()
    var activeplayer=1


    private fun playGame(cellID: Int, buSelected: Button) {
        if(activeplayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(resources.getColor(R.color.orange))
            player1.add(cellID)
            activeplayer=2
            AutoPlay()
        }
        else{
            buSelected.text="0"
            buSelected.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.color1))
            player2.add(cellID)
            activeplayer=1
        }
        buSelected.isEnabled=false
        checkWinner()
    }

    fun checkWinner() {
        var winner=-1
        //row1
        if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1
        }
        if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2
        }
        //row2
        if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1
        }
        if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2
        }
        //row3
        if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1
        }
        if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2
        }
        //col1
        if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1
        }
        if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2
        }
        //col2
        if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1
        }
        if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2
        }
        //col3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2
        }
        //diagonal1
        if (player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1
        }
        if (player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2
        }
        //diagonal2

        if (player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1
        }
        if (player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2
        }
        if (winner!=-1){
            if (winner==1){

                val i =Intent(this,congratsActivity::class.java)
                startActivity(i)
                finish()
            }
            else{
                val i =Intent(this,congratsActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }

    fun playAgain(view: View) {
        val intent=Intent(this,drawMAtchActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun AutoPlay(){
        var emptyCells= ArrayList<Int>()
        for(cellID in 1..9){
            if (!(player1.contains(cellID)||player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }
        val r=Random()
        val randIndex=r.nextInt(emptyCells.size-0)
        val cellID=emptyCells[randIndex]
        val buSelected:Button
        when(cellID){
            1->buSelected=btn1
            2->buSelected=btn2
            3->buSelected=btn3
            4->buSelected=btn4
            5->buSelected=btn5
            6->buSelected=btn6
            7->buSelected=btn7
            8->buSelected=btn8
            9->buSelected=btn9
            else->buSelected=btn1
        }
        playGame(cellID,buSelected)
    }


}