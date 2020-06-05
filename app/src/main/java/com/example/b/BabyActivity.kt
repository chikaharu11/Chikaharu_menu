package com.example.b

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_baby.*

class BabyActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baby)

        val intent = intent

        val menu1 = intent.extras?.getString(MainActivity.EXTRA_MENU1)?:""
        val menu2 = intent.extras?.getString(MainActivity.EXTRA_MENU2)?:""
        val menu3 = intent.extras?.getString(MainActivity.EXTRA_MENU3)?:""
        val menu4 = intent.extras?.getString(MainActivity.EXTRA_MENU4)?:""
        val menu5 = intent.extras?.getString(MainActivity.EXTRA_MENU5)?:""
        val menu6 = intent.extras?.getString(MainActivity.EXTRA_MENU6)?:""
        val menu7 = intent.extras?.getString(MainActivity.EXTRA_MENU7)?:""

        val menu01 = intent.extras?.getString(MainActivity.EXTRA_MENU01)?:""
        val menu02 = intent.extras?.getString(MainActivity.EXTRA_MENU02)?:""
        val menu03 = intent.extras?.getString(MainActivity.EXTRA_MENU03)?:""
        val menu04 = intent.extras?.getString(MainActivity.EXTRA_MENU04)?:""
        val menu05 = intent.extras?.getString(MainActivity.EXTRA_MENU05)?:""
        val menu06 = intent.extras?.getString(MainActivity.EXTRA_MENU06)?:""
        val menu07 = intent.extras?.getString(MainActivity.EXTRA_MENU07)?:""

        val menu1n = intent.extras?.getString(NoonActivity.EXTRA_MENU1n)?:""
        val menu2n = intent.extras?.getString(NoonActivity.EXTRA_MENU2n)?:""
        val menu3n = intent.extras?.getString(NoonActivity.EXTRA_MENU3n)?:""
        val menu4n = intent.extras?.getString(NoonActivity.EXTRA_MENU4n)?:""
        val menu5n = intent.extras?.getString(NoonActivity.EXTRA_MENU5n)?:""
        val menu6n = intent.extras?.getString(NoonActivity.EXTRA_MENU6n)?:""
        val menu7n = intent.extras?.getString(NoonActivity.EXTRA_MENU7n)?:""

        val menu01n = intent.extras?.getString(NoonActivity.EXTRA_MENU01n)?:""
        val menu02n = intent.extras?.getString(NoonActivity.EXTRA_MENU02n)?:""
        val menu03n = intent.extras?.getString(NoonActivity.EXTRA_MENU03n)?:""
        val menu04n = intent.extras?.getString(NoonActivity.EXTRA_MENU04n)?:""
        val menu05n = intent.extras?.getString(NoonActivity.EXTRA_MENU05n)?:""
        val menu06n = intent.extras?.getString(NoonActivity.EXTRA_MENU06n)?:""
        val menu07n = intent.extras?.getString(NoonActivity.EXTRA_MENU07n)?:""

        editText19.setText(menu1 + menu2 + menu3 + menu4 + menu5 + menu6 + menu7 + menu1n + menu2n + menu3n + menu4n + menu5n + menu6n + menu7n, TextView.BufferType.NORMAL)

        editText20.setText(menu01 + menu02 + menu03 + menu04 + menu05 + menu06 + menu07 + menu01n + menu02n + menu03n + menu04n + menu05n + menu06n + menu07n, TextView.BufferType.NORMAL)

        mainButton.setOnClickListener {
            finish()

        }
    }
}