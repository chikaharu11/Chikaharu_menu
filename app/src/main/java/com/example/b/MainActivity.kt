package com.example.b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class Cooking(val main: String, val ingre: List<String>)

        val cuisines = arrayListOf(

            //Cooking("\n", listOf("", "")),

            Cooking("ハンバーグ\n", listOf("ハンバーグ\n")),
            Cooking("ギョーザ\n", listOf("冷凍ギョーザ\n")),
            Cooking("肉野菜炒め\n", listOf("豚こま肉200g、", "野菜炒め用野菜\n")),
            Cooking("唐揚げ\n", listOf("鳥もも肉、", "唐揚げ粉\n")),
            Cooking("豚汁\n", listOf("豚こま肉250g、", "豚汁の素\n")),
            Cooking("マーボー豆腐\n", listOf("豆腐、", "マーボー豆腐の素\n")),
            Cooking("マーボー春雨\n", listOf("マーボー春雨\n")),
            Cooking("人参しりしり\n", listOf("ニンジン", "卵", "シーチキン\n")),
            Cooking("煮付け\n", listOf("油ふ", "ニンジン", "こんにゃく", "さつま揚げ", "キャベツ\n")),
            Cooking("焼きそば\n", listOf("豚こま肉", "野菜炒め用野菜", "焼きそばの麺", "天かす\n")),
            Cooking("焼きワンタン\n", listOf("ワンタン", "ごま油\n"))
        )

        tapHere.setOnClickListener {

            val chiseled = (cuisines.shuffled())

            val text4 = (chiseled.map { it.main }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text5 = findViewById<EditText>(R.id.editText8)

            text5.setText(text4, TextView.BufferType.NORMAL)

            val text6 = (chiseled.map { it.ingre }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text7 = findViewById<EditText>(R.id.editText9)

            text7.setText(text6, TextView.BufferType.NORMAL)

        }

        class Choking(val mains: String, val ingres: List<String>)

        val clumsiness = arrayListOf(

            //Choking("", listOf("", "")),

            Choking("ハンバーグ\n", listOf("ハンバーグ\n")),
            Choking("ギョーザ\n", listOf("冷凍ギョーザ\n")),
            Choking("肉野菜炒め\n", listOf("豚こま肉200g、", "野菜炒め用野菜\n")),
            Choking("唐揚げ\n", listOf("鳥もも肉、", "唐揚げ粉\n")),
            Choking("豚汁\n", listOf("豚こま肉250g、", "豚汁の素\n")),
            Choking("きゅうり酢和え\n", listOf("玉ふ、", "きゅうり\n")),
            Choking("ツナレタスサラダ\n", listOf("ツナ缶、", "レタス\n"))
        )

        button2.setOnClickListener {

            val chiselers = (clumsiness.shuffled())

            val text = (chiselers.map { it.mains }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text1 = findViewById<EditText>(R.id.editText4)

            text1.setText(text, TextView.BufferType.NORMAL)

            val text2 = (chiselers.map { it.ingres }.take(7).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text3 = findViewById<EditText>(R.id.editText7)

            text3.setText(text2, TextView.BufferType.NORMAL)

        }

        class Lunch(val main: String, val ingre: List<String>)

        val lunches = arrayListOf(

            //Lunch("", listOf("", "")),

            Lunch("皿うどん\n",listOf("皿うどん、", "豚バラ肉、", "野菜炒め用野菜\n")),
            Lunch("ギョーザ\n",listOf("冷凍ギョーザ\n"))
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

        noonButton.setOnClickListener {
            val intent = Intent(application, NoonActivity::class.java)
            startActivity(intent)
        }

        babyButton.setOnClickListener {
            val intent = Intent(application, BabyActivity::class.java)
            startActivity(intent)
        }
    }
}
/*
            val menu = arrayListOf("ハンバーグ\n", "冷魚\n", "ギョーザ\n", "肉野菜炒め\n","からあげ\n","豚汁\n","マーボー豆腐\n","マーボー春雨\n","キーマカレー\n","煮つけ\n"
                    ,"焼きそば\n","人参しりしり\n","焼きワンタン\n","チャーハン\n","豚しょうが焼き\n","エビフライ\n","きのこ炒め\n","ビーフン\n","グラタン\n","シチュー\n","うどん\n"
                    ,"パスタ\n","さばマヨ\n","ハムカツ\n","チキンステーキ\n","肉団子\n","じゃがいものチーズ焼き\n","春巻き\n","エビフライ\n","オムライス\n","サイコロステーキ\n","手作りパスタ\n"
                    ,"手作りハンバーグ\n","焼きハム\n","八宝菜\n","ラザニア\n","青椒肉絲\n","トースト\n")

            val menu2 = arrayListOf("生野菜\n", "豆腐\n", "パウチサラダ\n", "レンジ野菜\n","シューマイ\n","ショーロンポー\n","買う惣菜\n","こんぶキャベツ\n","ゆでもやし\n"
                    ,"ツナレタスサラダ\n","きゅうり酢あえ\n","茶わん蒸し\n","ブロッコリーじゃがいもマヨ\n","レンジコロッケ\n","スティックサラダ\n","味噌田楽\n"
                    ,"かぼちゃサラダ・チーズせんべい付き\n","大学いも\n","マカロニサラダ\n","フライドポテト\n","ホウレンソウのバター炒め\n","甘いもの\n")

        tapHere.setOnClickListener{

            textView2.text = (menu.shuffled().take(7).toString())

            textView.text = (menu2.shuffled().take(7).toString())

 */
