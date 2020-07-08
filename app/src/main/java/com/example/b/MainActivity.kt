package com.example.b

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cuisines = arrayListOf(

            "[空にする]",
            "ハンバーグ",
            "ギョーザ",
            "焼きウインナー",
            "肉野菜炒め",
            "唐揚げ",
            "豚汁",
            "マーボー豆腐",
            "マーボー春雨",
            "人参しりしり",
            "煮付け",
            "焼きそば",
            "焼きワンタン",
            "チャーハン",
            "豚生姜焼き",
            "エビフライ",
            "キノコ炒め",
            "ビーフン炒め",
            "チキングラタン",
            "ミートグラタン",
            "シチュー",
            "ビーフシチュー",
            "うどん",
            "パスタ",
            "鯖マヨ",
            "ジャガチーズ焼き",
            "ハムカツ",
            "サイコロステーキ",
            "チキンステーキ",
            "オムライス",
            "肉じゃが㋬",
            "牛丼",
            "豚バラ白菜㋬",
            "カレー㋬",
            "八宝菜",
            "ラーメン",
            "チーズ餃子",
            "焼きハム",
            "けんちん汁㋬",
            "ラザニア",
            "サンドイッチ",
            "冷やし中華",
            "マーボー茄子",
            "あんかけ卵"
        )

        val spinnerItems = cuisines.sorted()

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner1.adapter = adapter
        spinner2.adapter = adapter
        spinner3.adapter = adapter
        spinner4.adapter = adapter
        spinner5.adapter = adapter
        spinner6.adapter = adapter
        spinner7.adapter = adapter


        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText8.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText4.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText10.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText11.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText12.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText13.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val clumsiness = arrayListOf(

            "[空にする]",
            "生野菜",
            "豆腐",
            "パウチサラダ",
            "レンジ野菜",
            "シューマイ",
            "きゅうり酢和え",
            "ツナレタスサラダ",
            "ショーロンポー",
            "こんぶキャベツ",
            "レンジ豚もやし",
            "のりきゅうり",
            "茶碗むし",
            "レンジコロッケ",
            "じゃがブロッコリー",
            "スティックサラダ",
            "味噌田楽",
            "かぼちゃチーズ",
            "マカロニサラダ",
            "フライドポテト",
            "大学いも",
            "卵豆腐",
            "レンジ青椒肉絲",
            "春巻",
            "レンジ唐揚げ",
            "コーンスープ"
        )

        val spinnerItems2 = clumsiness.sorted()

        val adapter2 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems2
        )

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinnerA.adapter = adapter2
        spinnerB.adapter = adapter2
        spinnerC.adapter = adapter2
        spinnerD.adapter = adapter2
        spinnerE.adapter = adapter2
        spinnerF.adapter = adapter2
        spinnerG.adapter = adapter2


        spinnerB.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText9.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerF.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText7.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerG.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText14.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerD.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText15.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerE.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText16.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerC.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText17.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerA.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText18.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        editText8.setOnLongClickListener {
            spinner1.performClick()
            true
        }
        editText4.setOnLongClickListener {
            spinner4.performClick()
            true
        }
        editText.setOnLongClickListener {
            spinner3.performClick()
            true
        }
        editText10.setOnLongClickListener {
            spinner7.performClick()
            true
        }
        editText11.setOnLongClickListener {
            spinner6.performClick()
            true
        }
        editText12.setOnLongClickListener {
            spinner2.performClick()
            true
        }
        editText13.setOnLongClickListener {
            spinner5.performClick()
            true
        }
        editText9.setOnLongClickListener {
            spinnerB.performClick()
            true
        }
        editText7.setOnLongClickListener {
            spinnerF.performClick()
            true
        }
        editText14.setOnLongClickListener {
            spinnerG.performClick()
            true
        }
        editText15.setOnLongClickListener {
            spinnerD.performClick()
            true
        }
        editText16.setOnLongClickListener {
            spinnerE.performClick()
            true
        }
        editText17.setOnLongClickListener {
            spinnerC.performClick()
            true
        }
        editText18.setOnLongClickListener {
            spinnerA.performClick()
            true
        }

        val lunches = arrayListOf(

            "[空にする]",
            "皿うどん",
            "ギョーザ",
            "焼きそば",
            "マーボー春雨",
            "マーボー豆腐",
            "沖縄そば",
            "冷凍パスタ",
            "すき焼き豆腐",
            "レトルトカレー",
            "豚しょうが焼き",
            "ハンバーグ",
            "あんかけ卵",
            "肉野菜炒め",
            "ビーフン炒め"
        )

        val spinnerItems3 = lunches.sorted()

        val adapter3 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems3
        )

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1n.adapter = adapter3
        spinner2n.adapter = adapter3
        spinner3n.adapter = adapter3
        spinner4n.adapter = adapter3
        spinner5n.adapter = adapter3
        spinner6n.adapter = adapter3
        spinner7n.adapter = adapter3

        spinner1n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText8n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner4n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText4n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner3n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editTextn.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner7n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText10n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner6n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText11n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText12n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner5n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText13n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val baboon = arrayListOf(

            "[空にする]",
            "生野菜",
            "シューマイ",
            "ショーロンポー",
            "コロッケ",
            "春巻",
            "レンジ野菜",
            "パウチサラダ",
            "お湯スープ",
            "沖縄そば",
            "冷凍唐揚げ",
            "茶碗蒸し",
            "レンジ豚もやし"
        )

        val spinnerItems4 = baboon.sorted()

        val adapter4 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems4
        )

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerAn.adapter = adapter4
        spinnerBn.adapter = adapter4
        spinnerCn.adapter = adapter4
        spinnerDn.adapter = adapter4
        spinnerEn.adapter = adapter4
        spinnerFn.adapter = adapter4
        spinnerGn.adapter = adapter4

        spinnerBn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText9n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerFn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText7n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerGn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText14n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerDn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText15n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerEn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText16n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerCn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText17n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerAn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText18n.setText(item.replace("[空にする]", ""), TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        editText8n.setOnLongClickListener {
            spinner1n.performClick()
            true
        }
        editText4n.setOnLongClickListener {
            spinner4n.performClick()
            true
        }
        editTextn.setOnLongClickListener {
            spinner3n.performClick()
            true
        }
        editText10n.setOnLongClickListener {
            spinner7n.performClick()
            true
        }
        editText11n.setOnLongClickListener {
            spinner6n.performClick()
            true
        }
        editText12n.setOnLongClickListener {
            spinner2n.performClick()
            true
        }
        editText13n.setOnLongClickListener {
            spinner5n.performClick()
            true
        }
        editText9n.setOnLongClickListener {
            spinnerBn.performClick()
            true
        }
        editText7n.setOnLongClickListener {
            spinnerFn.performClick()
            true
        }
        editText14n.setOnLongClickListener {
            spinnerGn.performClick()
            true
        }
        editText15n.setOnLongClickListener {
            spinnerDn.performClick()
            true
        }
        editText16n.setOnLongClickListener {
            spinnerEn.performClick()
            true
        }
        editText17n.setOnLongClickListener {
            spinnerCn.performClick()
            true
        }
        editText18n.setOnLongClickListener {
            spinnerAn.performClick()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //オプションメニュー用xmlファイルをインフレイト。
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        // ───❶//親クラスの同名メソッドを呼び出し、その戻り値を返却。
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val cuisines2 = arrayListOf(

            "ハンバーグ　　　　[ハンバーグ]\n\n",
            "ギョーザ　　　　　[冷凍ギョーザ]\n\n",
            "焼きウインナー　　[ウインナー]\n\n",
            "肉野菜炒め　　　　[豚こま肉、\n野菜炒め用野菜]\n\n",
            "唐揚げ　　　　　　[鳥もも肉、\n唐揚げ粉]\n\n",
            "豚汁　　　　　　　[豚こま肉、\n豚汁の素]\n\n",
            "マーボー豆腐　　　[豆腐、\nマーボー豆腐の素]\n\n",
            "マーボー春雨　　　[マーボー春雨]\n\n",
            "人参しりしり　　　[ニンジン、\n卵、\nシーチキン]\n\n",
            "煮付け　　　　　　[油ふ、\nニンジン、\nこんにゃく、\nさつま揚げ、\nキャベツ]\n\n",
            "焼きそば　　　　　[豚こま肉、\n野菜炒め用野菜、\n焼きそばの麺、\n天かす]\n\n",
            "焼きワンタン　　　[ワンタン、\nごま油]\n\n",
            "チャーハン　　　　[焼き豚、\n卵]\n\n",
            "豚生姜焼き　　　　[豚ロース、\n生姜焼きの素]\n\n",
            "エビフライ　　　　[冷凍エビフライ]\n\n",
            "キノコ炒め　　　　[しめじ、\nエリンギ、\n豚こま肉、\nキノコ炒めの素]\n\n",
            "ビーフン炒め　　　[冷凍ビーフン]\n\n",
            "チキングラタン　　[鳥もも肉、\nタマネギ、\nとろけるチーズ、\n粉チーズ、\nグラタンの素、\n牛乳]\n\n",
            "ミートグラタン　　[合い挽き肉、\nタマネギ、\n牛乳、\nとろけるチーズ、\n粉チーズ、\nグラタンの素]\n\n",
            "シチュー　　　　　[鶏もも、\n人参、\nジャガイモ、\nタマネギ、\n牛乳、\nシチューの素]\n\n",
            "ビーフシチュー　　[シチュー用牛肉、\nジャガイモ、\nタマネギ、\nニンジン、\nビーフシチューの素]\n\n",
            "うどん　　　　　　[うどん玉、\nネギ、\nかき揚げ天ぷら、\nかまぼこ、\nめんつゆ]\n\n",
            "パスタ　　　　　　[パスタ、\nパスタソース]\n\n",
            "鯖マヨ　　　　　　[鯖缶]\n\n",
            "ジャガチーズ焼き　[ジャガイモ、\n合い挽き肉、\nとろけるチーズ、\nチーズ焼きの素]\n\n",
            "ハムカツ　　　　　[ハムカツ]\n\n",
            "サイコロステーキ　[サイコロステーキ]\n\n",
            "チキンステーキ　　[チキンステーキ]\n\n",
            "オムライス　　　　[ハム、\nミックスベジタブル、\n卵]\n\n",
            "肉じゃが㋬　　　　[ジャガイモ、\n豚or牛こま肉、\nタマネギ、\nニンジン]\n\n",
            "牛丼　　　　　　　[牛薄切り肉、\nタマネギ、\n牛丼のタレ]\n\n",
            "豚バラ白菜㋬　　　[和風だしorコンソメ、\n白菜、\n豚バラ肉]\n\n",
            "カレー㋬　　　　　[カレー用牛肉or豚肉、\nジャガイモ、\n人参、\nタマネギ、\nカレールー]\n\n",
            "八宝菜　　　　　　\n\n",
            "ラーメン　　　　　\n\n",
            "チーズ餃子　　　　\n\n",
            "焼きハム　　　　　\n\n",
            "けんちん汁㋬　　　\n\n",
            "ラザニア　　　　　\n\n",
            "サンドイッチ　　　\n\n",
            "冷やし中華　　　　\n\n",
            "マーボー茄子　　　\n\n",
            "あんかけ卵　　　　\n\n"
        )

        val clumsiness2 = arrayListOf(

            "生野菜　　　　　　　[生野菜]\n\n",
            "豆腐　　　　　　　　[絹ごし豆腐]\n\n",
            "パウチサラダ　　　　[パウチサラダ]\n\n",
            "レンジ野菜　　　　　[レンジ野菜]\n\n",
            "シューマイ　　　　　[シューマイ]\n\n",
            "きゅうり酢和え　　　[玉ふ、\nきゅうり]\n\n",
            "ツナレタスサラダ　　[ツナ缶、\nきゅうり、\nレタス]\n\n",
            "ショーロンポー　　　[ショーロンポー]\n\n",
            "こんぶキャベツ　　　[キャベツ、\n塩こんぶ]\n\n",
            "レンジ豚もやし　　　[豚ばら肉、\nもやし]\n\n",
            "のりきゅうり　　　　[海苔、\nきゅうり]\n\n",
            "茶碗むし　　　　　　[茶碗むし]\n\n",
            "レンジコロッケ　　　[冷凍コロッケ]\n\n",
            "じゃがブロッコリー　[ブロッコリー、\nじゃがいも]\n\n",
            "スティックサラダ　　[にんじん、\n大根、\nきゅうり]\n\n",
            "味噌田楽　　　　　　[味噌田楽]\n\n",
            "かぼちゃチーズ　　　[かぼちゃ、\nスライスチーズ]\n\n",
            "マカロニサラダ　　　[マカロニ、\nカニカマ、\nハム、\nツナコーン]\n\n",
            "フライドポテト　　　[フライドポテト]\n\n",
            "大学いも　　　　　　[さつまいも、\n大学いもの素、\nごま]\n\n",
            "卵豆腐　　　　　　　\n\n",
            "レンジ青椒肉絲　　　\n\n",
            "春巻　　　　　　　　\n\n",
            "レンジ唐揚げ　　　　\n\n",
            "コーンスープ　　　　\n\n"
        )

        val lunches2 = arrayListOf(

            "皿うどん　　　　　[皿うどん、\n豚バラ肉、\n野菜炒め用野菜]\n\n",
            "ギョーザ　　　　　[冷凍ギョーザ]\n\n",
            "焼きそば　　　　　[豚こま肉、\n野菜炒め用野菜、\n焼きそばの麺]\n\n",
            "マーボー春雨　　　[マーボー春雨]\n\n",
            "マーボー豆腐　　　[マーボー豆腐]\n\n",
            "沖縄そば　　　　　[かまぼこ、\nネギ]\n\n",
            "冷凍パスタ　　　　[冷凍パスタ]\n\n",
            "すき焼き豆腐　　　[豆腐、\nすき焼き豆腐の素]\n\n",
            "レトルトカレー　　[レトルトカレー]\n\n",
            "豚しょうが焼き　　[豚ロース肉、\n豚しょうが焼きの素]\n\n",
            "ハンバーグ　　　　[ハンバーグ]\n\n",
            "あんかけ卵　　　　\n\n",
            "肉野菜炒め　　　　\n\n",
            "ビーフン炒め　　　\n\n"
        )

        val baboon2 = arrayListOf(

            "生野菜　　　　　　[生野菜]\n\n",
            "シューマイ　　　　[冷凍シューマイ]\n\n",
            "ショーロンポー　　[冷凍ショーロンポー]\n\n",
            "コロッケ　　　　　[冷凍コロッケ]\n\n",
            "春巻　　　　　　　[冷凍春巻]\n\n",
            "レンジ野菜　　　　[冷凍野菜]\n\n",
            "パウチサラダ　　　[パウチサラダ]\n\n",
            "お湯スープ　　　　[お湯スープの素]\n\n",
            "沖縄そば　　　　　[]\n\n",
            "冷凍唐揚げ　　　　[冷凍唐揚げ]\n\n",
            "茶碗蒸し　　　　　[茶碗蒸し]\n\n",
            "レンジ豚もやし　　[レンジ豚もやし]\n\n"
        )

        val listView1 = ListView(this)

        val arrayAdapter1 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, cuisines2.sorted())

        val listView2 = ListView(this)

        val arrayAdapter2 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, clumsiness2.sorted())

        val listView3 = ListView(this)

        val arrayAdapter3 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, lunches2.sorted())

        val listView4 = ListView(this)

        val arrayAdapter4 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, baboon2.sorted())

        listView1.adapter = arrayAdapter1
        listView2.adapter = arrayAdapter2
        listView3.adapter = arrayAdapter3
        listView4.adapter = arrayAdapter4

        val intent = Intent(applicationContext, MainActivity::class.java)

        when (item.itemId) {
            //作成ボタンを押したとき
            R.id.MenuList1 -> {
                setContentView(listView3)
                return true
            }
            //削除ボタンを押したとき
            R.id.MenuList2 -> {
                setContentView(listView4)
                return true
            }

            R.id.MenuList3 -> {
                setContentView(listView1)
                return true
            }

            R.id.MenuList4 -> {
                setContentView(listView2)
                return true
            }
            R.id.MenuList5 -> {
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
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


tapHere.setOnClickListener {

            val chiseled = (cuisines.shuffled())

            val random1 = (chiseled.map { it.main + it.ingre }[0])
            val random2 = (chiseled.map { it.main + it.ingre }[1])
            val random3 = (chiseled.map { it.main + it.ingre }[2])
            val random4 = (chiseled.map { it.main + it.ingre }[3])
            val random5 = (chiseled.map { it.main + it.ingre }[4])
            val random6 = (chiseled.map { it.main + it.ingre }[5])
            val random7 = (chiseled.map { it.main + it.ingre }[6])

            editText8.setText(random1.take(9).replace("　", ""), TextView.BufferType.NORMAL)
            editText4.setText(random2.take(9).replace("　", ""), TextView.BufferType.NORMAL)
            editText.setText(random3.take(9).replace("　", ""), TextView.BufferType.NORMAL)
            editText10.setText(random4.take(9).replace("　", ""), TextView.BufferType.NORMAL)
            editText11.setText(random5.take(9).replace("　", ""), TextView.BufferType.NORMAL)
            editText12.setText(random6.take(9).replace("　", ""), TextView.BufferType.NORMAL)
            editText13.setText(random7.take(9).replace("　", ""), TextView.BufferType.NORMAL)

            intent.putExtra(EXTRA_MENU1, random1.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU2, random2.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU3, random3.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU4, random4.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU5, random5.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU6, random6.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU7, random7.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            val chiselers = (clumsiness.shuffled())

            val randomA = (chiselers.map { it.mains + it.ingres }[0])
            val randomB = (chiselers.map { it.mains + it.ingres }[1])
            val randomC = (chiselers.map { it.mains + it.ingres }[2])
            val randomD = (chiselers.map { it.mains + it.ingres }[3])
            val randomE = (chiselers.map { it.mains + it.ingres }[4])
            val randomF = (chiselers.map { it.mains + it.ingres }[5])
            val randomG = (chiselers.map { it.mains + it.ingres }[6])

            editText9.setText(randomA.take(12).replace("　", ""), TextView.BufferType.NORMAL)
            editText7.setText(randomB.take(12).replace("　", ""), TextView.BufferType.NORMAL)
            editText14.setText(randomC.take(12).replace("　", ""), TextView.BufferType.NORMAL)
            editText15.setText(randomD.take(12).replace("　", ""), TextView.BufferType.NORMAL)
            editText16.setText(randomE.take(12).replace("　", ""), TextView.BufferType.NORMAL)
            editText17.setText(randomF.take(12).replace("　", ""), TextView.BufferType.NORMAL)
            editText18.setText(randomG.take(12).replace("　", ""), TextView.BufferType.NORMAL)

            intent.putExtra(EXTRA_MENU01, randomA.drop(12).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU02, randomB.drop(12).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU03, randomC.drop(12).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU04, randomD.drop(12).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU05, randomE.drop(12).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU06, randomF.drop(12).replace("[", "").replace("]", "").replace("、", ""))
            intent.putExtra(EXTRA_MENU07, randomG.drop(12).replace("[", "").replace("]", "").replace("、", ""))

            editText8.setOnClickListener { view == mButton) {
			mSpinner.performClick();
		} }

        }*/
