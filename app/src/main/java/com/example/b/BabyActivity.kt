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

        editText19.setText(menu1 + menu2 + menu3 + menu4 + menu5 + menu6 + menu7, TextView.BufferType.NORMAL)

        editText20.setText(menu01 + menu02 + menu03 + menu04 + menu05 + menu06 + menu07, TextView.BufferType.NORMAL)

        mainButton.setOnClickListener {
            finish()

        }
    }
}