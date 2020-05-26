package com.example.b

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_MESSAGE = "com.example.b.MESSAGE"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class Cooking(val main: String, val ingre: String)

        val cuisines = arrayListOf(

            //Cooking("\n", "\n"),

            Cooking("ハンバーグ　　　　", "ハンバーグ"),
            Cooking("ギョーザ　　　　　", "冷凍ギョーザ"),
            Cooking("焼きウインナー　　", "ウインナー"),
            Cooking("肉野菜炒め　　　　", "豚こま肉　野菜炒め用野菜"),
            Cooking("唐揚げ　　　　　　", "鳥もも肉　唐揚げ粉"),
            Cooking("豚汁　　　　　　　", "豚こま肉　豚汁の素"),
            Cooking("マーボー豆腐　　　", "豆腐　マーボー豆腐の素"),
            Cooking("マーボー春雨　　　", "マーボー春雨"),
            Cooking("人参しりしり　　　", "ニンジン　卵　シーチキン"),
            Cooking("煮付け　　　　　　", "油ふ　ニンジン　こんにゃく　\nさつま揚げ　キャベツ\n"),
            Cooking("焼きそば　　　　　", "豚こま肉　野菜炒め用野菜　\n焼きそばの麺　天かす\n"),
            Cooking("焼きワンタン　　　", "ワンタン　ごま油"),
            Cooking("チャーハン　　　　", "焼き豚　卵"),
            Cooking("豚生姜焼き　　　　", "豚ロース　生姜焼きの素"),
            Cooking("エビフライ　　　　", "冷凍エビフライ"),
            Cooking("キノコ炒め　　　　", "しめじ　エリンギ　豚こま肉　\nキノコ炒めの素\n"),
            Cooking("ビーフン炒め　　　", "冷凍ビーフン"),
            Cooking("チキングラタン　　", "鳥もも肉　タマネギ　とろけるチーズ　\n粉チーズ　グラタンの素　牛乳\n"),
            Cooking("ミートグラタン　　", "合い挽き肉　タマネギ　牛乳　とろけるチーズ　粉チーズ　グラタンの素"),
            Cooking("シチュー　　　　　", "鶏もも肉、人参、ジャガイモ、\n タマネギ、牛乳、シチューの素\n"),
            Cooking("ビーフシチュー　　", "シチュー用牛肉、ジャガイモ、タマネギ、\n 人参、ビーフシチューの素\n"),
            Cooking("うどん　　　　　　", "うどん玉、ネギ、かき揚げ天ぷら、\n かまぼこ、めんつゆ\n"),
            Cooking("パスタ　　　　　　", "パスタ、パスタソース"),
            Cooking("鯖マヨ　　　　　　", "鯖缶"),
            Cooking("ジャガチーズ焼き　", "ジャガイモ、合い挽き肉、\n とろけるチーズ、チーズ焼きの素\n"),
            Cooking("ハムカツ　　　　　", "ハムカツ"),
            Cooking("サイコロステーキ　", "サイコロステーキ"),
            Cooking("チキンステーキ　　", "チキンステーキ"),
            Cooking("オムライス　　　　", "ハム、ミックスベジタブル、卵"),
            Cooking("肉じゃが㋬　　　　", "ジャガイモ、豚or牛こま肉、タマネギ、\n ニンジン\n"),
            Cooking("牛丼　　　　　　　", "牛薄切り肉、タマネギ、牛丼のタレ"),
            Cooking("豚バラ白菜㋬　　　", "和風だしの素orコンソメ顆粒、\n 白菜、豚バラ肉\n"),
            Cooking("カレー㋬　　　　　", "カレー用牛肉or豚肉、ジャガイモ、人参、\n タマネギ、カレールー\n")
        )

        val spinnerItems = cuisines.map { it.main + it.ingre }

        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter
        spinner4.adapter = adapter
        spinner5.adapter = adapter
        spinner6.adapter = adapter
        spinner7.adapter = adapter


        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText8.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText4.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText10.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText11.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText12.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText13.setText(item.take(9), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        class Choking(val mains: String, val ingres: String)

        val clumsiness = arrayListOf(

            //Choking("\n", "\n"),

            Choking("生野菜　　　　　　　　　", "生野菜"),
            Choking("豆腐　　　　　　　　　　", "絹ごし豆腐"),
            Choking("パウチサラダ　　　　　　", "パウチサラダ"),
            Choking("レンジ野菜　　　　　　　", "レンジ野菜"),
            Choking("シューマイ　　　　　　　", "シューマイ"),
            Choking("きゅうり酢和え　　　　　", "玉ふ、きゅうり"),
            Choking("ツナレタスサラダ　　　　", "ツナ缶、きゅうり、レタス"),
            Choking("ショーロンポー　　　　　", "ショーロンポー"),
            Choking("こんぶキャベツ　　　　　", "キャベツ、塩こんぶ"),
            Choking("レンジ豚もやし　　　　　", "豚ばら肉、もやし"),
            Choking("のりきゅうり　　　　　　", "海苔、きゅうり"),
            Choking("茶碗むし　　　　　　　　", "茶碗むし"),
            Choking("レンジコロッケ　　　　　", "冷凍コロッケ"),
            Choking("ブロッコリーじゃがいも　", "ブロッコリー、じゃがいも"),
            Choking("スティックサラダ　　　　", "にんじん、大根、きゅうり"),
            Choking("味噌田楽　　　　　　　　", "味噌田楽"),
            Choking("かぼちゃチーズサラダ　　", "かぼちゃ、スライスチーズ"),
            Choking("マカロニサラダ　　　　　", "マカロニ、, カニカマ、ハム、ツナコーン"),
            Choking("フライドポテト　　　　　", "フライドポテト"),
            Choking("大学いも　　　　　　　　", "さつまいも、大学いもの素、ごま")
        )

        val spinnerItems2 = clumsiness.map { it.mains +it.ingres }

        val adapter2 = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems2)

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinnerA.adapter = adapter2
        spinnerB.adapter = adapter2
        spinnerC.adapter = adapter2
        spinnerD.adapter = adapter2
        spinnerE.adapter = adapter2
        spinnerF.adapter = adapter2
        spinnerG.adapter = adapter2


        spinnerB.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText9.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerF.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText7.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerG.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText14.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerD.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText15.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerE.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText16.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerC.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText17.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerA.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText18.setText(item.take(12), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        tapHere.setOnClickListener {

            val chiseled = (cuisines.shuffled())

            val random1 = (chiseled.map { it.main }[0])
            val random2 = (chiseled.map { it.main }[1])
            val random3 = (chiseled.map { it.main }[2])
            val random4 = (chiseled.map { it.main }[3])
            val random5 = (chiseled.map { it.main }[4])
            val random6 = (chiseled.map { it.main }[5])
            val random7 = (chiseled.map { it.main }[6])

            editText8.setText(random1, TextView.BufferType.NORMAL)
            editText4.setText(random2, TextView.BufferType.NORMAL)
            editText.setText(random3, TextView.BufferType.NORMAL)
            editText10.setText(random4, TextView.BufferType.NORMAL)
            editText11.setText(random5, TextView.BufferType.NORMAL)
            editText12.setText(random6, TextView.BufferType.NORMAL)
            editText13.setText(random7, TextView.BufferType.NORMAL)

            val chiselers = (clumsiness.shuffled())

            val randomA = (chiselers.map { it.mains }[0])
            val randomB = (chiselers.map { it.mains }[1])
            val randomC = (chiselers.map { it.mains }[2])
            val randomD = (chiselers.map { it.mains }[3])
            val randomE = (chiselers.map { it.mains }[4])
            val randomF = (chiselers.map { it.mains }[5])
            val randomG = (chiselers.map { it.mains }[6])

            editText9.setText(randomA, TextView.BufferType.NORMAL)
            editText7.setText(randomB, TextView.BufferType.NORMAL)
            editText14.setText(randomC, TextView.BufferType.NORMAL)
            editText15.setText(randomD, TextView.BufferType.NORMAL)
            editText16.setText(randomE, TextView.BufferType.NORMAL)
            editText17.setText(randomF, TextView.BufferType.NORMAL)
            editText18.setText(randomG, TextView.BufferType.NORMAL)

        }

        button2.setOnClickListener {

                val intent = Intent(applicationContext, BabyActivity::class.java)
                val str = editText8.text.toString()

                intent.putExtra(EXTRA_MESSAGE, str)
                startActivity(intent)

        }

        noonButton.setOnClickListener {
            val intentM = Intent(application, NoonActivity::class.java)
            startActivity(intentM)
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
editText5.setText(item.drop(9), TextView.BufferType.NORMAL)

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

intent.putExtra(EXTRA_MESSAGE, item.drop(9))
        */
