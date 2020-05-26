package com.example.b

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_baby.*

class BabyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baby)

        val intent = intent
        val message = intent.extras?.getString(MainActivity.EXTRA_MESSAGE)?:""

        editText19.setText(message, TextView.BufferType.NORMAL)

        mainButton.setOnClickListener {
            finish()

        }
    }
}