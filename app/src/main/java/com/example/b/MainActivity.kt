package com.example.b

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class Cooking(val main: String, val ingre: String)

        val cuisines = arrayListOf(

            //Cooking("\n", "\n"),

            Cooking("ハンバーグ\n", "ハンバーグ\n"),
            Cooking("ギョーザ\n", "冷凍ギョーザ\n"),
            Cooking("焼きウインナー\n", "ウインナー\n"),
            Cooking("肉野菜炒め\n", "豚こま肉、野菜炒め用野菜\n"),
            Cooking("唐揚げ\n", "鳥もも肉、唐揚げ粉\n"),
            Cooking("豚汁\n", "豚こま肉、豚汁の素\n"),
            Cooking("マーボー豆腐\n", "豆腐、マーボー豆腐の素\n"),
            Cooking("マーボー春雨\n", "マーボー春雨\n"),
            Cooking("人参しりしり\n", "ニンジン、卵、シーチキン\n"),
            Cooking("煮付け\n\n", "油ふ、ニンジン、こんにゃく、\n さつま揚げ、キャベツ\n"),
            Cooking("焼きそば\n\n", "豚こま肉、野菜炒め用野菜、\n 焼きそばの麺、天かす\n"),
            Cooking("焼きワンタン\n", "ワンタン、ごま油\n"),
            Cooking("チャーハン\n", "焼き豚、卵\n"),
            Cooking("豚生姜焼き\n", "豚ロース、生姜焼きの素\n"),
            Cooking("エビフライ\n", "冷凍エビフライ\n"),
            Cooking("キノコ炒め\n\n", "しめじ、エリンギ、豚こま肉、\n キノコ炒めの素\n"),
            Cooking("ビーフン炒め\n", "冷凍ビーフン\n"),
            Cooking("チキングラタン\n\n", "鳥もも肉、タマネギ、とろけるチーズ、\n 粉チーズ、グラタンの素、牛乳\n"),
            Cooking("ミートグラタン\n\n", "合い挽き肉、タマネギ、牛乳、\n とろけるチーズ、粉チーズ、グラタンの素\n"),
            Cooking("シチュー\n\n", "鶏もも肉、人参、ジャガイモ、\n タマネギ、牛乳、シチューの素\n"),
            Cooking("ビーフシチュー\n\n", "シチュー用牛肉、ジャガイモ、タマネギ、\n 人参、ビーフシチューの素\n"),
            Cooking("うどん\n\n", "うどん玉、ネギ、かき揚げ天ぷら、\n かまぼこ、めんつゆ\n"),
            Cooking("パスタ\n", "パスタ、パスタソース\n"),
            Cooking("鯖マヨ\n", "鯖缶\n"),
            Cooking("ジャガイモのチーズ焼き\n\n", "ジャガイモ、合い挽き肉、\n とろけるチーズ、チーズ焼きの素\n"),
            Cooking("ハムカツ\n", "ハムカツ\n"),
            Cooking("サイコロステーキ\n", "サイコロステーキ\n"),
            Cooking("チキンステーキ\n", "チキンステーキ\n"),
            Cooking("オムライス\n", "ハム、ミックスベジタブル、卵\n"),
            Cooking("肉じゃが㋬\n\n", "ジャガイモ、豚or牛こま肉、タマネギ、\n ニンジン\n"),
            Cooking("牛丼\n", "牛薄切り肉、タマネギ、牛丼のタレ\n"),
            Cooking("豚バラ白菜㋬\n\n", "和風だしの素orコンソメ顆粒、\n 白菜、豚バラ肉\n"),
            Cooking("カレー㋬\n\n", "カレー用牛肉or豚肉、ジャガイモ、人参、\n タマネギ、カレールー\n")
        )

        val spinnerItems = cuisines.map { it.main + it.ingre }

        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinner に adapter をセット
        // Kotlin Android Extensions
        spinner.adapter = adapter

        // リスナーを登録
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                editText8.setText(item, TextView.BufferType.NORMAL)
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        tapHere.setOnClickListener {

            val chiseled = (cuisines.shuffled())

            val text4 = (chiseled.map { it.main }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text5 = findViewById<EditText>(R.id.editText8)

            text5.setText(text4, TextView.BufferType.NORMAL)

            val text6 = (chiseled.map { it.ingre }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text7 = findViewById<EditText>(R.id.editText9)

            text7.setText(text6, TextView.BufferType.NORMAL)

        }

        class Choking(val mains: String, val ingres: String)

        val clumsiness = arrayListOf(

            //Choking("\n", "\n"),

            Choking("生野菜\n", "生野菜\n"),
            Choking("豆腐\n", "絹ごし豆腐\n"),
            Choking("パウチサラダ\n", "パウチサラダ\n"),
            Choking("レンジ野菜\n", "レンジ野菜\n"),
            Choking("シューマイ\n", "シューマイ\n"),
            Choking("きゅうり酢和え\n", "玉ふ、きゅうり\n"),
            Choking("ツナレタスサラダ\n", "ツナ缶、きゅうり、レタス\n"),
            Choking("ショーロンポー\n", "ショーロンポー\n"),
            Choking("こんぶキャベツ\n", "キャベツ、塩こんぶ\n"),
            Choking("レンジ豚もやし\n", "豚ばら肉、もやし\n"),
            Choking("のりきゅうり\n", "海苔、きゅうり\n"),
            Choking("茶碗むし\n", "茶碗むし\n"),
            Choking("レンジコロッケ\n", "冷凍コロッケ\n"),
            Choking("ブロッコリーじゃがいも\n", "ブロッコリー、じゃがいも\n"),
            Choking("スティックサラダ\n", "にんじん、大根、きゅうり\n"),
            Choking("味噌田楽\n", "味噌田楽\n"),
            Choking("かぼちゃチーズサラダ\n", "かぼちゃ、スライスチーズ\n"),
            Choking("マカロニサラダ\n", "マカロニ、, カニカマ、ハム、ツナコーン\n"),
            Choking("フライドポテト\n", "フライドポテト\n"),
            Choking("大学いも\n", "さつまいも、大学いもの素、ごま\n")
        )

        button2.setOnClickListener {

            val chiselers = (clumsiness.shuffled())

            val text = (chiselers.map { it.mains }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text1 = findViewById<EditText>(R.id.editText4)

            text1.setText(text, TextView.BufferType.NORMAL)

            val text2 = (chiselers.map { it.ingres }.take(10).toString()
                .replace("[", "").replace("]", "").replace(",", "")
                .fold(" ") { initial, value -> initial + value })

            val text3 = findViewById<EditText>(R.id.editText7)

            text3.setText(text2, TextView.BufferType.NORMAL)

        }

        noonButton.setOnClickListener {
            val intent = Intent(application, NoonActivity::class.java)
            startActivity(intent)
        }

        babyButton.setOnClickListener {
            finish()
        }
    }
}
/*
            val menu = arrayListOf("ハンバーグ\n", "冷魚\n", "ギョーザ\n", "肉野菜炒め\n","からあげ\n","豚汁\n","マーボー豆腐\n","マーボー春雨\n","キーマカレー\n","煮つけ\n"
                    ,"焼きそば\n","人参しりしり\n","焼きワンタン\n","チャーハン\n","豚しょうが焼き\n","エビフライ\n","きのこ炒め\n","ビーフン\n","グラタン\n","シチュー\n","うどん\n"
                    ,"パスタ\n","さばマヨ\n","ハムカツ\n","チキンステーキ\n","肉団子\n","じゃがいものチーズ焼き\n","春巻き\n","エビフライ\n","オムライス\n","サイコロステーキ\n","手作りパスタ\n"
                    ,"手作りハンバーグ\n","焼きハム\n","八宝菜\n","ラザニア\n","青椒肉絲\n","トースト\n")

            /*
            val menu2 = arrayListOf("生野菜\n", "豆腐\n", "パウチサラダ\n", "レンジ野菜\n","シューマイ\n","ショーロンポー\n","買う惣菜\n","こんぶキャベツ\n","ゆでもやし\n"
                    ,"ツナレタスサラダ\n","きゅうり酢あえ\n","茶わん蒸し\n","ブロッコリーじゃがいもマヨ\n","レンジコロッケ\n","スティックサラダ\n","味噌田楽\n"
                    ,"かぼちゃサラダ・チーズせんべい付き\n","大学いも\n","マカロニサラダ\n","フライドポテト\n","ホウレンソウのバター炒め\n","甘いもの\n")

 */
    tapHere.setOnClickListener{

        textView2.text = (menu.shuffled().take(7).toString())

        textView.text = (menu2.shuffled().take(7).toString())



        val spinnerItems = cuisines.map { it.main }

        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinner に adapter をセット
        // Kotlin Android Extensions
        spinner.adapter = adapter

        // リスナーを登録
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                editText8.setText(item, TextView.BufferType.NORMAL)
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        */
