package com.example.b

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_noon.*

class NoonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noon)

        class Lunch(val main: String, val ingre: List<String>)

        val lunches = arrayListOf(

            //Lunch("", listOf("", "")),

            Lunch("皿うどん\n",listOf("皿うどん、", "豚バラ肉、", "野菜炒め用野菜\n")),
            Lunch("ギョーザ\n",listOf("冷凍ギョーザ\n")),
            Lunch("焼きそば\n\n", listOf("豚こま肉、", "野菜炒め用野菜、\n", "焼きそばの麺\n")),
            Lunch("マーボー春雨\n", listOf("マーボー春雨\n")),
            Lunch("マーボー豆腐\n", listOf("マーボー豆腐\n")),
            Lunch("沖縄そば\n", listOf("かまぼこ、", "ネギ\n")),
            Lunch("冷凍パスタ\n", listOf("冷凍パスタ\n")),
            Lunch("すき焼き豆腐\n", listOf("豆腐、", "すき焼き豆腐の素\n")),
            Lunch("レトルトカレー\n", listOf("レトルトカレー\n")),
            Lunch("豚しょうが焼き\n", listOf("豚ロース肉、", "豚しょうが焼きの素\n")),
            Lunch("ハンバーグ\n", listOf("ハンバーグ\n"))
        )

        lunchbutton.setOnClickListener {

            val lunched = (lunches.shuffled())

            val noon = (lunched.map { it.main }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val noon1 = findViewById<EditText>(R.id.editText5)

                noon1.setText(noon, TextView.BufferType.NORMAL)

            val noon2 = (lunched.map { it.ingre }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val noon3 = findViewById<EditText>(R.id.editText6)

                noon3.setText(noon2, TextView.BufferType.NORMAL)

        }

        main2Button.setOnClickListener {
            finish()
        }
    }
}