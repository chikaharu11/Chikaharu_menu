package com.example.b

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mRealm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        mRealm = Realm.getInstance(realmConfig)

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

    override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }

    private fun create(name: String) {
        mRealm.executeTransaction {
            val max = mRealm.where<Book>().max("id")
            var newId: Long = 0
            if (max != null) {//nullチェック
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
            if (max != null) {//nullチェック
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
            if (max != null) {//nullチェック
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
            if (max != null) {//nullチェック
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

        val fragment1 = MenuListFragmentActivity1()
        val fragment2 = MenuListFragmentActivity2()
        val fragment3 = MenuListFragmentActivity3()
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
                replaceFragment(fragment1)
                return true
            }

            R.id.MenuList2 -> {
                replaceFragment(fragment2)
                return true
            }

            R.id.MenuList3 -> {
                replaceFragment(fragment3)
                return true
            }

            R.id.MenuList4 -> {
                replaceFragment(fragment4)
                return true
            }

            R.id.MenuList5 -> {
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                return true
            }

            R.id.MenuList6 -> {
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

                finish()
                return true
            }

            R.id.MenuList7 -> {
                delete()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}