package com.example.b

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_noon.*

class NoonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noon)

        class Lunch(val main: String, val ingre: String)

        val lunches = arrayListOf(

            //Lunch("\n", "\n"),

            Lunch("皿うどん\n", "皿うどん、豚バラ肉、野菜炒め用野菜\n"),
            Lunch("ギョーザ\n", "冷凍ギョーザ\n"),
            Lunch("焼きそば\n\n", "豚こま肉、野菜炒め用野菜、\n 焼きそばの麺\n"),
            Lunch("マーボー春雨\n", "マーボー春雨\n"),
            Lunch("マーボー豆腐\n", "マーボー豆腐\n"),
            Lunch("沖縄そば\n", "かまぼこ、ネギ\n"),
            Lunch("冷凍パスタ\n", "冷凍パスタ\n"),
            Lunch("すき焼き豆腐\n", "豆腐、すき焼き豆腐の素\n"),
            Lunch("レトルトカレー\n", "レトルトカレー\n"),
            Lunch("豚しょうが焼き\n", "豚ロース肉、豚しょうが焼きの素\n"),
            Lunch("ハンバーグ\n", "ハンバーグ\n")
        )

        lunchbutton.setOnClickListener {

            val lunched = (lunches.shuffled())

            val noon = (lunched.map { it.main }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val noon1 = findViewById<EditText>(R.id.editText5)

                noon1.setText(noon, TextView.BufferType.NORMAL)

            val noon2 = (lunched.map { it.ingre }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val noon3 = findViewById<EditText>(R.id.editText6)

                noon3.setText(noon2, TextView.BufferType.NORMAL)

        }

        class Babyhood(val main: String, val ingre: String)

        val baboon = arrayListOf(

            //Babyhood("\n", "\n"),

            Babyhood("角切りにんじん\n", "にんじん\n"),
            Babyhood("ブロックかぼちゃ\n", "かぼちゃ\n"),
            Babyhood("牛ひき肉\n", "牛ひき肉\n"),
            Babyhood("豚ひき肉\n", "豚ひき肉\n"),
            Babyhood("野菜ミックス\n", "野菜ミックス\n"),
            Babyhood("ゆでしらす\n", "しらす\n"),
            Babyhood("ゆでブロッコリー\n", "ブロッコリー\n"),
            Babyhood("ウインナー\n", "子供用ウインナー\n"),
            Babyhood("なす煮\n", "ナス、和風だし\n"),
            Babyhood("にんじんキャベツ千切り\n", "にんじん、キャベツ\n"),
            Babyhood("とり団子\n", "鳥ひき肉\n"),
            Babyhood("とりささみ\n", "とりささみ\n")
        )

        /*
ツナ
卵
ほうれん草
豆腐
たまねぎ
しめじ
えのき
しいたけ
大根
白菜
キャベツ
鮭
ひじき
マカロニ
パン
そうめん
うどん
トマト
 */

        button3.setOnClickListener {

            val lunched = (baboon.shuffled())

            val chairmen = (lunched.map { it.main }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val chairmen2 = findViewById<EditText>(R.id.editText2)

            chairmen2.setText(chairmen, TextView.BufferType.NORMAL)

            val chairmen3 = (lunched.map { it.ingre }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val chairmen4 = findViewById<EditText>(R.id.editText3)

            chairmen4.setText(chairmen3, TextView.BufferType.NORMAL)

        }

        main2Button.setOnClickListener {
            finish()
        }

        listButton.setOnClickListener {
            val intent = Intent(application, BabyActivity::class.java)
            startActivity(intent)
        }
    }
}

/*
にんじん
かぼちゃ
さつまいも
豚ひき肉
牛ひき肉
野菜ミックス
なす
ツナ
卵
ほうれん草
しらす
とりささみ
豆腐
ブロッコリー
ウインナー
たまねぎ
しめじ
えのき
しいたけ
大根
白菜
キャベツ
鮭
ひじき
マカロニ
パン
そうめん
うどん
トマト
 */