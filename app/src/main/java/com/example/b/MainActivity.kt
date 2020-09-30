package com.example.b

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Runnable {

    private val handler = Handler()

    private lateinit var mRealm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler.post(this)

        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        mRealm = Realm.getInstance(realmConfig)

        val week1 = mRealm.where(Book5::class.java).equalTo("id",0.toLong()).findFirst()?.name
        val week2 = mRealm.where(Book5::class.java).equalTo("id",1.toLong()).findFirst()?.name
        val week3 = mRealm.where(Book5::class.java).equalTo("id",2.toLong()).findFirst()?.name
        val week4 = mRealm.where(Book5::class.java).equalTo("id",3.toLong()).findFirst()?.name
        val week5 = mRealm.where(Book5::class.java).equalTo("id",4.toLong()).findFirst()?.name
        val week6 = mRealm.where(Book5::class.java).equalTo("id",5.toLong()).findFirst()?.name
        val week7 = mRealm.where(Book5::class.java).equalTo("id",6.toLong()).findFirst()?.name

        if(week1 != null){
            textView.text = week1
            textView2.text = week2
            textView3.text = week3
            textView4.text = week4
            textView5.text = week5
            textView6.text = week6
            textView7.text = week7
        }

        val item1 = mRealm.where(Book6::class.java).equalTo("id",0.toLong()).findFirst()?.name
        val item2 = mRealm.where(Book6::class.java).equalTo("id",1.toLong()).findFirst()?.name
        val item3 = mRealm.where(Book6::class.java).equalTo("id",2.toLong()).findFirst()?.name
        val item4 = mRealm.where(Book6::class.java).equalTo("id",3.toLong()).findFirst()?.name

        if(item1 != null) {
            editText8n.hint = item1
            editText4n.hint = item1
            editText13n.hint = item1
            editTextn.hint = item1
            editText11n.hint = item1
            editText10n.hint = item1
            editText12n.hint = item1
            editText9n.hint = item2
            editText7n.hint = item2
            editText15n.hint = item2
            editText16n.hint = item2
            editText18n.hint = item2
            editText17n.hint = item2
            editText14n.hint = item2
            editText8.hint = item3
            editText4.hint = item3
            editText13.hint = item3
            editText.hint = item3
            editText11.hint = item3
            editText10.hint = item3
            editText12.hint = item3
            editText9.hint = item4
            editText7.hint = item4
            editText15.hint = item4
            editText16.hint = item4
            editText18.hint = item4
            editText17.hint = item4
            editText14.hint = item4
        }



        val cuisines = mutableSetOf(

            "",
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


        val getcuisines = mRealm.where<Book>().findAll()


        for( i in getcuisines )
        if (getcuisines != null) {
            cuisines.add(i.name)
        }


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

                editText8.setText(item, TextView.BufferType.NORMAL)

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

                editText4.setText(item, TextView.BufferType.NORMAL)

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

                editText.setText(item, TextView.BufferType.NORMAL)

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

                editText10.setText(item, TextView.BufferType.NORMAL)

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

                editText11.setText(item, TextView.BufferType.NORMAL)

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

                editText12.setText(item, TextView.BufferType.NORMAL)

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

                editText13.setText(item, TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val clumsiness = mutableSetOf(

            "",
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

        val getclumsiness = mRealm.where<Book2>().findAll()


        for( i in getclumsiness )
            if (getclumsiness != null) {
                clumsiness.add(i.name)
            }

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

                editText9.setText(item, TextView.BufferType.NORMAL)
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

                editText7.setText(item, TextView.BufferType.NORMAL)
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

                editText14.setText(item, TextView.BufferType.NORMAL)
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

                editText15.setText(item, TextView.BufferType.NORMAL)
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

                editText16.setText(item, TextView.BufferType.NORMAL)
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

                editText17.setText(item, TextView.BufferType.NORMAL)
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

                editText18.setText(item, TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        fun hideKeyboard() {
            val view = currentFocus
            if (view != null) {
                val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }


        editText8.setOnLongClickListener {
            run()
            hideKeyboard()
            spinner1.performClick()
            true
        }
        editText4.setOnLongClickListener {
            hideKeyboard()
            spinner4.performClick()
            true
        }
        editText.setOnLongClickListener {
            hideKeyboard()
            spinner3.performClick()
            true
        }
        editText10.setOnLongClickListener {
            hideKeyboard()
            spinner7.performClick()
            true
        }
        editText11.setOnLongClickListener {
            hideKeyboard()
            spinner6.performClick()
            true
        }
        editText12.setOnLongClickListener {
            hideKeyboard()
            spinner2.performClick()
            true
        }
        editText13.setOnLongClickListener {
            hideKeyboard()
            spinner5.performClick()
            true
        }
        editText9.setOnLongClickListener {
            hideKeyboard()
            spinnerB.performClick()
            true
        }
        editText7.setOnLongClickListener {
            hideKeyboard()
            spinnerF.performClick()
            true
        }
        editText14.setOnLongClickListener {
            hideKeyboard()
            spinnerG.performClick()
            true
        }
        editText15.setOnLongClickListener {
            hideKeyboard()
            spinnerD.performClick()
            true
        }
        editText16.setOnLongClickListener {
            hideKeyboard()
            spinnerE.performClick()
            true
        }
        editText17.setOnLongClickListener {
            hideKeyboard()
            spinnerC.performClick()
            true
        }
        editText18.setOnLongClickListener {
            hideKeyboard()
            spinnerA.performClick()
            true
        }

        val lunches = mutableSetOf(

            "",
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


        val getlunches = mRealm.where<Book3>().findAll()


        for( i in getlunches )
            if (getlunches != null) {
                lunches.add(i.name)
            }


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

                editText8n.setText(item, TextView.BufferType.NORMAL)

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

                editText4n.setText(item, TextView.BufferType.NORMAL)

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

                editTextn.setText(item, TextView.BufferType.NORMAL)

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

                editText10n.setText(item, TextView.BufferType.NORMAL)

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

                editText11n.setText(item, TextView.BufferType.NORMAL)

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

                editText12n.setText(item, TextView.BufferType.NORMAL)

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

                editText13n.setText(item, TextView.BufferType.NORMAL)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val baboon = mutableSetOf(

            "",
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

        val getbaboon = mRealm.where<Book4>().findAll()


        for( i in getbaboon )
            if (getbaboon != null) {
                baboon.add(i.name)
            }


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

                editText9n.setText(item, TextView.BufferType.NORMAL)
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

                editText7n.setText(item, TextView.BufferType.NORMAL)
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

                editText14n.setText(item, TextView.BufferType.NORMAL)
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

                editText15n.setText(item, TextView.BufferType.NORMAL)
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

                editText16n.setText(item, TextView.BufferType.NORMAL)
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

                editText17n.setText(item, TextView.BufferType.NORMAL)
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

                editText18n.setText(item, TextView.BufferType.NORMAL)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        editText8n.setOnLongClickListener {
            hideKeyboard()
            spinner1n.performClick()
            true
        }
        editText4n.setOnLongClickListener {
            hideKeyboard()
            spinner4n.performClick()
            true
        }
        editTextn.setOnLongClickListener {
            hideKeyboard()
            spinner3n.performClick()
            true
        }
        editText10n.setOnLongClickListener {
            hideKeyboard()
            spinner7n.performClick()
            true
        }
        editText11n.setOnLongClickListener {
            hideKeyboard()
            spinner6n.performClick()
            true
        }
        editText12n.setOnLongClickListener {
            hideKeyboard()
            spinner2n.performClick()
            true
        }
        editText13n.setOnLongClickListener {
            hideKeyboard()
            spinner5n.performClick()
            true
        }
        editText9n.setOnLongClickListener {
            hideKeyboard()
            spinnerBn.performClick()
            true
        }
        editText7n.setOnLongClickListener {
            hideKeyboard()
            spinnerFn.performClick()
            true
        }
        editText14n.setOnLongClickListener {
            hideKeyboard()
            spinnerGn.performClick()
            true
        }
        editText15n.setOnLongClickListener {
            hideKeyboard()
            spinnerDn.performClick()
            true
        }
        editText16n.setOnLongClickListener {
            hideKeyboard()
            spinnerEn.performClick()
            true
        }
        editText17n.setOnLongClickListener {
            hideKeyboard()
            spinnerCn.performClick()
            true
        }
        editText18n.setOnLongClickListener {
            hideKeyboard()
            spinnerAn.performClick()
            true
        }

    }

    override fun run() {
        handler.postDelayed(this, 5000)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("終了しますか？")
            .setPositiveButton("YES") { _, _ ->
                finish()
            }
            .setNegativeButton("NO") { _, _ ->

            }
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }

    private fun create(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book>().max("id")
            var newId: Long = 0
            if (max != null) {
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    private fun create2(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book2>().max("id")
            var newId: Long = 0
            if (max != null) {
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book2>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    private fun create3(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book3>().max("id")
            var newId: Long = 0
            if (max != null) {
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book3>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    private fun create4(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book4>().max("id")
            var newId: Long = 0
            if (max != null) {
                newId = max.toLong() + 1
            }
            val book = mRealm.createObject<Book4>(primaryKeyValue = newId)
            book.name = name
            mRealm.copyToRealm(book)
        }
    }

    /*private fun read(): RealmResults<Book> {
        return mRealm.where(Book::class.java).findAll()
    }
*/
    private fun delete() {
        mRealm.executeTransaction {
            mRealm.deleteAll()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_options_menu_list, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val fragment4 = MenuListFragmentActivity4()


        fun replaceFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.replace(R.id.container, fragment)
            fragmentTransaction.commit()
        }

        when (item.itemId) {

            R.id.MenuList1 -> {
                val builder = android.app.AlertDialog.Builder(this)
                val inflater = layoutInflater
                val signinView = inflater.inflate(R.layout.dialog_week, null)

                builder.setView(signinView)
                    .setTitle("曜日の変更")
                    .setPositiveButton("変更する") { _, _ ->
                        mRealm.executeTransaction {
                            mRealm.where(Book5::class.java).findAll().deleteAllFromRealm()
                            val week1 = mRealm.createObject<Book5>(0)
                            val a = signinView.findViewById<EditText>(R.id.textView_).text.toString()
                            week1.name = a
                            val week2 = mRealm.createObject<Book5>(1)
                            val a2 = signinView.findViewById<EditText>(R.id.textView_2).text.toString()
                            week2.name = a2
                            val week3 = mRealm.createObject<Book5>(2)
                            val a3 = signinView.findViewById<EditText>(R.id.textView_3).text.toString()
                            week3.name = a3
                            val week4 = mRealm.createObject<Book5>(3)
                            val a4 = signinView.findViewById<EditText>(R.id.textView_4).text.toString()
                            week4.name = a4
                            val week5 = mRealm.createObject<Book5>(4)
                            val a5 = signinView.findViewById<EditText>(R.id.textView_5).text.toString()
                            week5.name = a5
                            val week6 = mRealm.createObject<Book5>(5)
                            val a6 = signinView.findViewById<EditText>(R.id.textView_6).text.toString()
                            week6.name = a6
                            val week7 = mRealm.createObject<Book5>(6)
                            val a7 = signinView.findViewById<EditText>(R.id.textView_7).text.toString()
                            week7.name = a7
                        }
                        Toast.makeText(applicationContext, "変更は次回起動時に反映されます。", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("キャンセル") { _, _ ->

                    }

                    .show()
                return true
            }

            R.id.MenuList2 -> {
                val builder = android.app.AlertDialog.Builder(this)
                val inflater = layoutInflater
                val signinView2 = inflater.inflate(R.layout.dialog_item, null)

                builder.setView(signinView2)
                    .setTitle("項目の変更")
                    .setPositiveButton("変更する") { _, _ ->
                        mRealm.executeTransaction {
                            mRealm.where(Book6::class.java).findAll().deleteAllFromRealm()
                            val item1 = mRealm.createObject<Book6>(0)
                            val a = signinView2.findViewById<EditText>(R.id.editText8n).text.toString()
                            item1.name = a
                            val item2 = mRealm.createObject<Book6>(1)
                            val a2 = signinView2.findViewById<EditText>(R.id.editText9n).text.toString()
                            item2.name = a2
                            val item3 = mRealm.createObject<Book6>(2)
                            val a3 = signinView2.findViewById<EditText>(R.id.editText8).text.toString()
                            item3.name = a3
                            val item4 = mRealm.createObject<Book6>(3)
                            val a4 = signinView2.findViewById<EditText>(R.id.editText9).text.toString()
                            item4.name = a4
                        }
                        Toast.makeText(applicationContext, "変更は次回起動時に反映されます。", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("キャンセル") { _, _ ->

                    }

                    .show()
                return true
            }

            R.id.MenuList3 -> {
                switch2.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) replaceFragment(fragment4)
                    else supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                }
                switch2.performClick()
                return true
            }
            

            R.id.MenuList6 -> {
                AlertDialog.Builder(this)
                    .setTitle("初期状態に戻しますか？")
                    .setMessage("(曜日、項目、登録したメニューが\n全て消去されます)")
                    .setPositiveButton("YES") { _, _ ->
                        delete()
                        Toast.makeText(applicationContext, "次回起動時から初期状態に戻ります。", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("NO") { _, _ ->

                    }
                    .show()

                return true
            }

            R.id.MenuList7 -> {
                AlertDialog.Builder(this)
                    .setTitle("終了しますか？")
                    .setMessage("(入力したメニューは保存されます)")
                    .setPositiveButton("YES") { _, _ ->
                        val stringText11 = editText8.text.toString()
                        create(stringText11)
                        val stringText12 = editText4.text.toString()
                        create(stringText12)
                        val stringText13 = editText13.text.toString()
                        create(stringText13)
                        val stringText14 = editText.text.toString()
                        create(stringText14)
                        val stringText15 = editText11.text.toString()
                        create(stringText15)
                        val stringText16 = editText10.text.toString()
                        create(stringText16)
                        val stringText17 = editText12.text.toString()
                        create(stringText17)

                        val stringText21 = editText9.text.toString()
                        create2(stringText21)
                        val stringText22 = editText7.text.toString()
                        create2(stringText22)
                        val stringText23 = editText15.text.toString()
                        create2(stringText23)
                        val stringText24 = editText16.text.toString()
                        create2(stringText24)
                        val stringText25 = editText18.text.toString()
                        create2(stringText25)
                        val stringText26 = editText17.text.toString()
                        create2(stringText26)
                        val stringText27 = editText14.text.toString()
                        create2(stringText27)

                        val stringText31 = editText8n.text.toString()
                        create3(stringText31)
                        val stringText32 = editText4n.text.toString()
                        create3(stringText32)
                        val stringText33 = editText13n.text.toString()
                        create3(stringText33)
                        val stringText34 = editTextn.text.toString()
                        create3(stringText34)
                        val stringText35 = editText11n.text.toString()
                        create3(stringText35)
                        val stringText36 = editText10n.text.toString()
                        create3(stringText36)
                        val stringText37 = editText12n.text.toString()
                        create3(stringText37)

                        val stringText41 = editText9n.text.toString()
                        create4(stringText41)
                        val stringText42 = editText7n.text.toString()
                        create4(stringText42)
                        val stringText43 = editText15n.text.toString()
                        create4(stringText43)
                        val stringText44 = editText16n.text.toString()
                        create4(stringText44)
                        val stringText45 = editText18n.text.toString()
                        create4(stringText45)
                        val stringText46 = editText17n.text.toString()
                        create4(stringText46)
                        val stringText47 = editText14n.text.toString()
                        create4(stringText47)

                        Toast.makeText(applicationContext, "終了しました。", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    .setNegativeButton("NO") { _, _ ->

                    }
                    .show()

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}