package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class drawMAtchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_match)
        Handler().postDelayed({
            val l=Intent(this,MainActivity::class.java)
            startActivity(l)
        },2000)
    }
}