package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_congrats.*
import kotlinx.android.synthetic.main.activity_splashscreenactivity.*

class congratsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)
        celeblottie.animate().translationY(1400f).setDuration(1000).setStartDelay(4000)
        val splash_time_out:Long = 4000

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },splash_time_out)

    }
}