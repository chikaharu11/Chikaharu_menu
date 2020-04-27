package com.example.b

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_baby.*

class BabyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baby)

        class Babyhood(val main: String, val ingre: List<String>)

        val baboon = arrayListOf(

            //Babyhood("", listOf("", "")),

            Babyhood("皿うどん\n",listOf("皿うどん、", "豚バラ肉、", "野菜炒め用野菜\n")),
            Babyhood("ギョーザ\n",listOf("冷凍ギョーザ\n"))
        )

        button3.setOnClickListener {

            val lunched = (baboon.shuffled())

            val chairmen = (lunched.map { it.main }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val chairmen2 = findViewById<EditText>(R.id.editText2)

            chairmen2.setText(chairmen, TextView.BufferType.NORMAL)

            val chairmen3 = (lunched.map { it.ingre }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val chairmen4 = findViewById<EditText>(R.id.editText3)

            chairmen4.setText(chairmen3, TextView.BufferType.NORMAL)

        }

        mainButton.setOnClickListener {
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)

        }
    }
}