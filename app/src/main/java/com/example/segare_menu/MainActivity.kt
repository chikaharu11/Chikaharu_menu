package com.example.segare_menu

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.os.Environment
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
import com.jakewharton.processphoenix.ProcessPhoenix
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    private lateinit var mRealm: Realm

    private lateinit var soundPool: SoundPool

    private var sound1 = 0

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val audioAttributes = AudioAttributes.Builder()

            .setUsage(AudioAttributes.USAGE_GAME)

            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder()

            .setAudioAttributes(audioAttributes)

            .setMaxStreams(1)
            .build()

        sound1 = soundPool.load(this, R.raw.ta, 1)

        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        mRealm = Realm.getInstance(realmConfig)

        val week1 = mRealm.where(Book5::class.java).equalTo("id", 0.toLong()).findFirst()?.name
        val week2 = mRealm.where(Book5::class.java).equalTo("id", 1.toLong()).findFirst()?.name
        val week3 = mRealm.where(Book5::class.java).equalTo("id", 2.toLong()).findFirst()?.name
        val week4 = mRealm.where(Book5::class.java).equalTo("id", 3.toLong()).findFirst()?.name
        val week5 = mRealm.where(Book5::class.java).equalTo("id", 4.toLong()).findFirst()?.name
        val week6 = mRealm.where(Book5::class.java).equalTo("id", 5.toLong()).findFirst()?.name
        val week7 = mRealm.where(Book5::class.java).equalTo("id", 6.toLong()).findFirst()?.name

        if(week1 != null){
            textView.text = week1
            textView2.text = week2
            textView3.text = week3
            textView4.text = week4
            textView5.text = week5
            textView6.text = week6
            textView7.text = week7
        }

        val item1 = mRealm.where(Book6::class.java).equalTo("id", 0.toLong()).findFirst()?.name
        val item2 = mRealm.where(Book6::class.java).equalTo("id", 1.toLong()).findFirst()?.name
        val item3 = mRealm.where(Book6::class.java).equalTo("id", 2.toLong()).findFirst()?.name
        val item4 = mRealm.where(Book6::class.java).equalTo("id", 3.toLong()).findFirst()?.name
        val item5 = mRealm.where(Book6::class.java).equalTo("id", 4.toLong()).findFirst()?.name

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
            supportActionBar?.title = item5
        }



        val cuisine1 = mutableSetOf(

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
            "肉じゃが",
            "牛丼",
            "豚バラ白菜",
            "カレー",
            "八宝菜",
            "ラーメン",
            "チーズ餃子",
            "焼きハム",
            "けんちん汁",
            "ラザニア",
            "サンドイッチ",
            "冷やし中華",
            "マーボー茄子",
            "あんかけ卵"
        )

        val item6 = mRealm.where(Book6::class.java).equalTo("id", 5.toLong()).findFirst()?.boolean

        val switch = findViewById<Switch>(R.id.switch3)
        if (item6 != null) {
            switch.isChecked = item6
        }

        if (item6 == true) {
            cuisine1.clear()
            cuisine1.add("")
        }

        val getCuisine1 = mRealm.where<Book>().findAll()


        for( i in getCuisine1 )
        if (getCuisine1 != null) {
            cuisine1.add(i.name)
        }

        val spinnerItems = cuisine1.sorted()

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)



        customSpinner.adapter = adapter


        customSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    editText8.hasFocus() -> editText8.setText(item, TextView.BufferType.NORMAL)
                    editText4.hasFocus() -> editText4.setText(item, TextView.BufferType.NORMAL)
                    editText.hasFocus() -> editText.setText(item, TextView.BufferType.NORMAL)
                    editText10.hasFocus() -> editText10.setText(item, TextView.BufferType.NORMAL)
                    editText11.hasFocus() -> editText11.setText(item, TextView.BufferType.NORMAL)
                    editText12.hasFocus() -> editText12.setText(item, TextView.BufferType.NORMAL)
                    editText13.hasFocus() -> editText13.setText(item, TextView.BufferType.NORMAL)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val cuisine2 = mutableSetOf(

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

         if (item6 == true) {
            cuisine2.clear()
             cuisine2.add("")
        }

        val getCuisine2 = mRealm.where<Book2>().findAll()


        for( i in getCuisine2 )
            if (getCuisine2 != null) {
                cuisine2.add(i.name)
            }

        val spinnerItems2 = cuisine2.sorted()

        val adapter2 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems2
        )

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        customSpinner2.adapter = adapter2


        customSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    editText9.hasFocus() -> editText9.setText(item, TextView.BufferType.NORMAL)
                    editText7.hasFocus() -> editText7.setText(item, TextView.BufferType.NORMAL)
                    editText14.hasFocus() -> editText14.setText(item, TextView.BufferType.NORMAL)
                    editText15.hasFocus() -> editText15.setText(item, TextView.BufferType.NORMAL)
                    editText16.hasFocus() -> editText16.setText(item, TextView.BufferType.NORMAL)
                    editText17.hasFocus() -> editText17.setText(item, TextView.BufferType.NORMAL)
                    editText18.hasFocus() -> editText18.setText(item, TextView.BufferType.NORMAL)
                }

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
            editText8.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText4.setOnLongClickListener {
            editText4.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText.setOnLongClickListener {
            editText.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText10.setOnLongClickListener {
            editText10.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText11.setOnLongClickListener {
            editText11.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText12.setOnLongClickListener {
            editText12.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText13.setOnLongClickListener {
            editText13.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner.performClick() }, 300)
            true
        }
        editText9.setOnLongClickListener {
            editText9.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }
        editText7.setOnLongClickListener {
            editText7.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }
        editText14.setOnLongClickListener {
            editText14.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }
        editText15.setOnLongClickListener {
            editText15.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }
        editText16.setOnLongClickListener {
            editText16.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }
        editText17.setOnLongClickListener {
            editText17.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }
        editText18.setOnLongClickListener {
            editText18.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner2.performClick() }, 300)
            true
        }

        val cuisine3 = mutableSetOf(

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

        if (item6 == true) {
            cuisine3.clear()
            cuisine3.add("")
        }

        val getCuisine3 = mRealm.where<Book3>().findAll()


        for( i in getCuisine3 )
            if (getCuisine3 != null) {
                cuisine3.add(i.name)
            }


        val spinnerItems3 = cuisine3.sorted()

        val adapter3 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems3
        )

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        customSpinner3.adapter = adapter3

        customSpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    editText8n.hasFocus() -> editText8n.setText(item, TextView.BufferType.NORMAL)
                    editText4n.hasFocus() -> editText4n.setText(item, TextView.BufferType.NORMAL)
                    editTextn.hasFocus() -> editTextn.setText(item, TextView.BufferType.NORMAL)
                    editText10n.hasFocus() -> editText10n.setText(item, TextView.BufferType.NORMAL)
                    editText11n.hasFocus() -> editText11n.setText(item, TextView.BufferType.NORMAL)
                    editText12n.hasFocus() -> editText12n.setText(item, TextView.BufferType.NORMAL)
                    editText13n.hasFocus() -> editText13n.setText(item, TextView.BufferType.NORMAL)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val cuisine4 = mutableSetOf(

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

        if (item6 == true) {
            cuisine4.clear()
            cuisine4.add("")
        }

        val getCuisine4 = mRealm.where<Book4>().findAll()


        for( i in getCuisine4 )
            if (getCuisine4 != null) {
                cuisine4.add(i.name)
            }


        val spinnerItems4 = cuisine4.sorted()

        val adapter4 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems4
        )

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        customSpinner4.adapter = adapter4

        customSpinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    editText9n.hasFocus() -> editText9n.setText(item, TextView.BufferType.NORMAL)
                    editText7n.hasFocus() -> editText7n.setText(item, TextView.BufferType.NORMAL)
                    editText14n.hasFocus() -> editText14n.setText(item, TextView.BufferType.NORMAL)
                    editText15n.hasFocus() -> editText15n.setText(item, TextView.BufferType.NORMAL)
                    editText16n.hasFocus() -> editText16n.setText(item, TextView.BufferType.NORMAL)
                    editText17n.hasFocus() -> editText17n.setText(item, TextView.BufferType.NORMAL)
                    editText18n.hasFocus() -> editText18n.setText(item, TextView.BufferType.NORMAL)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        editText8n.setOnLongClickListener {
            editText8n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editText4n.setOnLongClickListener {
            editText4n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editTextn.setOnLongClickListener {
            editTextn.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editText10n.setOnLongClickListener {
            editText10n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editText11n.setOnLongClickListener {
            editText11n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editText12n.setOnLongClickListener {
            editText12n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editText13n.setOnLongClickListener {
            editText13n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner3.performClick() }, 300)
            true
        }
        editText9n.setOnLongClickListener {
            editText9n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }
        editText7n.setOnLongClickListener {
            editText7n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }
        editText14n.setOnLongClickListener {
            editText14n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }
        editText15n.setOnLongClickListener {
            editText15n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }
        editText16n.setOnLongClickListener {
            editText16n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }
        editText17n.setOnLongClickListener {
            editText17n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }
        editText18n.setOnLongClickListener {
            editText18n.requestFocus()
            hideKeyboard()
            handler.postDelayed({ customSpinner4.performClick() }, 300)
            true
        }

        val menuList1 = mutableSetOf(
            "[選択したメニューを削除できます]"
        )

        val inMenuList1 = mRealm.where<Book>().findAll()


        for( i in inMenuList1 )
            if (inMenuList1 != null) {
                menuList1.add(i.name)
            }


        val spinnerItems5 = menuList1.sorted()

        val adapter5 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems5
        )

        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner1a.adapter = adapter5

        spinner1a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                mRealm.executeTransaction { mRealm.where<Book>().equalTo("name", item).findAll().deleteAllFromRealm() }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val menuList2 = mutableSetOf(
            "[選択したメニューを削除できます]"
        )

        val inMenuList2 = mRealm.where<Book2>().findAll()


        for( i in inMenuList2 )
            if (inMenuList2 != null) {
                menuList2.add(i.name)
            }


        val spinnerItems6 = menuList2.sorted()

        val adapter6 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems6
        )

        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner2a.adapter = adapter6

        spinner2a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                mRealm.executeTransaction { mRealm.where<Book2>().equalTo("name", item).findAll().deleteAllFromRealm() }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val menuList3 = mutableSetOf(
            "[選択したメニューを削除できます]"
        )

        val inMenuList3 = mRealm.where<Book3>().findAll()


        for( i in inMenuList3 )
            if (inMenuList3 != null) {
                menuList3.add(i.name)
            }


        val spinnerItems7 = menuList3.sorted()

        val adapter7 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems7
        )

        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner3a.adapter = adapter7

        spinner3a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                mRealm.executeTransaction { mRealm.where<Book3>().equalTo("name", item).findAll().deleteAllFromRealm() }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val menuList4 = mutableSetOf(
            "[選択したメニューを削除できます]"
        )

        val inMenuList4 = mRealm.where<Book4>().findAll()


        for( i in inMenuList4 )
            if (inMenuList4 != null) {
                menuList4.add(i.name)
            }


        val spinnerItems8 = menuList4.sorted()

        val adapter8 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems8
        )

        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner4a.adapter = adapter8

        spinner4a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                mRealm.executeTransaction { mRealm.where<Book4>().equalTo("name", item).findAll().deleteAllFromRealm() }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }


    @SuppressLint("SimpleDateFormat")
    private fun getBitmapFromView(view: View):Bitmap {
        val timeStamp: String = SimpleDateFormat("MM月dd日HH時mm分ss秒").format(Date())
        val path = getExternalFilesDir(Environment.DIRECTORY_DCIM)?.path + "/" + supportActionBar?.title + " " + timeStamp + ".png"
        val stream = FileOutputStream(path)
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()
        soundPool.play(sound1, 1.0f, 1.0f, 0, 0, 1.0f)
        Toast.makeText(applicationContext, "画面を保存しました。", Toast.LENGTH_LONG).show()
        return bitmap
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("終了しますか？")
            .setMessage("(入力したメニューは保存されません)")
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


    private fun delete() {
        mRealm.executeTransaction {
            mRealm.deleteAll()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_options_menu_list, menu)

        val menu1 = menu.findItem(R.id.MenuList5c)
        val item1a = mRealm.where(Book6::class.java).equalTo("id", 0.toLong()).findFirst()?.name

        if (item1a != null) {
            menu1.title = item1a + "の編集"
        }

        val menu2 = menu.findItem(R.id.MenuList5d)
        val item2a = mRealm.where(Book6::class.java).equalTo("id", 1.toLong()).findFirst()?.name

        if (item2a != null) {
            menu2.title = item2a + "の編集"
        }

        val menu3 = menu.findItem(R.id.MenuList5a)
        val item3a = mRealm.where(Book6::class.java).equalTo("id", 2.toLong()).findFirst()?.name

        if (item3a != null) {
            menu3.title = item3a + "の編集"
        }

        val menu4 = menu.findItem(R.id.MenuList5b)
        val item4a = mRealm.where(Book6::class.java).equalTo("id", 3.toLong()).findFirst()?.name

        if (item4a != null) {
            menu4.title = item4a + "の編集"
        }

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
                val dialogView = inflater.inflate(R.layout.dialog_week, null)

                builder.setView(dialogView)
                    .setTitle("各項目の名前を変更できます。")
                    .setPositiveButton("変更する") { _, _ ->
                        mRealm.executeTransaction {
                            mRealm.where(Book5::class.java).findAll().deleteAllFromRealm()
                            val week1 = mRealm.createObject<Book5>(0)
                            val a =
                                dialogView.findViewById<EditText>(R.id.textView_).text.toString()
                            week1.name = a
                            val week2 = mRealm.createObject<Book5>(1)
                            val a2 =
                                dialogView.findViewById<EditText>(R.id.textView_2).text.toString()
                            week2.name = a2
                            val week3 = mRealm.createObject<Book5>(2)
                            val a3 =
                                dialogView.findViewById<EditText>(R.id.textView_3).text.toString()
                            week3.name = a3
                            val week4 = mRealm.createObject<Book5>(3)
                            val a4 =
                                dialogView.findViewById<EditText>(R.id.textView_4).text.toString()
                            week4.name = a4
                            val week5 = mRealm.createObject<Book5>(4)
                            val a5 =
                                dialogView.findViewById<EditText>(R.id.textView_5).text.toString()
                            week5.name = a5
                            val week6 = mRealm.createObject<Book5>(5)
                            val a6 =
                                dialogView.findViewById<EditText>(R.id.textView_6).text.toString()
                            week6.name = a6
                            val week7 = mRealm.createObject<Book5>(6)
                            val a7 =
                                dialogView.findViewById<EditText>(R.id.textView_7).text.toString()
                            week7.name = a7
                        }

                        mRealm.executeTransaction {
                            mRealm.where(Book6::class.java).findAll().deleteAllFromRealm()
                            val item1 = mRealm.createObject<Book6>(0)
                            val a =
                                dialogView.findViewById<EditText>(R.id.editText_8n).text.toString()
                            item1.name = a
                            val item2 = mRealm.createObject<Book6>(1)
                            val a2 =
                                dialogView.findViewById<EditText>(R.id.editText_9n).text.toString()
                            item2.name = a2
                            val item3 = mRealm.createObject<Book6>(2)
                            val a3 =
                                dialogView.findViewById<EditText>(R.id.editText_8).text.toString()
                            item3.name = a3
                            val item4 = mRealm.createObject<Book6>(3)
                            val a4 =
                                dialogView.findViewById<EditText>(R.id.editText_9).text.toString()
                            item4.name = a4
                            val item5 = mRealm.createObject<Book6>(4)
                            val a5 =
                                dialogView.findViewById<EditText>(R.id.textView_8).text.toString()
                            item5.name = a5
                        }
                        Toast.makeText(applicationContext, "次にアプリを開いた時に変更されます。", Toast.LENGTH_LONG)
                            .show()
                    }
                    .setNegativeButton("キャンセル") { _, _ ->

                    }

                    .show()
                return true
            }

            R.id.MenuList2 -> {
                getBitmapFromView(allView)
                return true
            }

            R.id.MenuList3 -> {
                switch2.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) replaceFragment(fragment4)
                    else supportFragmentManager.popBackStack(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                }
                switch2.performClick()
                return true
            }

            R.id.MenuList4 -> {
                switch3.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) mRealm.executeTransaction {
                        val item6 = mRealm.createObject<Book6>(5)
                        val a6 = true
                        item6.boolean = a6
                        Toast.makeText(
                            applicationContext,
                            "次にアプリを開いた時から\n初期メニューを表示しません。",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else mRealm.executeTransaction {
                        mRealm.where(Book6::class.java).findAll().deleteLastFromRealm()
                        Toast.makeText(
                            applicationContext,
                            "次にアプリを開いた時から\n初期メニューを表示します。",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                switch3.performClick()
                return true
            }

            R.id.MenuList5a -> {
                val menuList1a = mutableSetOf(
                    "[選択したメニューを削除できます]"
                )

                val inMenuList1a = mRealm.where<Book>().findAll()


                for (i in inMenuList1a)
                    if (inMenuList1a != null) {
                        menuList1a.add(i.name)
                    }


                val spinnerItems5a = menuList1a.sorted()

                val adapter5a = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_item, spinnerItems5a
                )

                adapter5a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


                spinner1a.adapter = adapter5a
                handler.postDelayed({ spinner1a.performClick() }, 300)
                return true
            }

            R.id.MenuList5b -> {
                val menuList2a = mutableSetOf(
                    "[選択したメニューを削除できます]"
                )

                val inMenuList2a = mRealm.where<Book2>().findAll()


                for (i in inMenuList2a)
                    if (inMenuList2a != null) {
                        menuList2a.add(i.name)
                    }


                val spinnerItems6a = menuList2a.sorted()

                val adapter6a = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_item, spinnerItems6a
                )

                adapter6a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


                spinner2a.adapter = adapter6a
                handler.postDelayed({ spinner2a.performClick() }, 300)
                return true
            }

            R.id.MenuList5c -> {
                val menuList3a = mutableSetOf(
                    "[選択したメニューを削除できます]"
                )

                val inMenuList3a = mRealm.where<Book3>().findAll()


                for (i in inMenuList3a)
                    if (inMenuList3a != null) {
                        menuList3a.add(i.name)
                    }


                val spinnerItems7a = menuList3a.sorted()

                val adapter7a = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_item, spinnerItems7a
                )

                adapter7a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


                spinner3a.adapter = adapter7a
                handler.postDelayed({ spinner3a.performClick() }, 300)
                return true
            }

            R.id.MenuList5d -> {
                val menuList4a = mutableSetOf(
                    "[選択したメニューを削除できます]"
                )

                val inMenuList4a = mRealm.where<Book4>().findAll()


                for (i in inMenuList4a)
                    if (inMenuList4a != null) {
                        menuList4a.add(i.name)
                    }


                val spinnerItems8a = menuList4a.sorted()

                val adapter8a = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_item, spinnerItems8a
                )

                adapter8a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


                spinner4a.adapter = adapter8a
                handler.postDelayed({ spinner4a.performClick() }, 300)
                return true
            }


            R.id.MenuList6 -> {
                AlertDialog.Builder(this)
                    .setTitle("初期状態に戻しますか？")
                    .setMessage("(登録した内容が全て消去されます)")
                    .setPositiveButton("YES") { _, _ ->
                        delete()
                        Toast.makeText(applicationContext, "次にアプリを開いた時から\n初期状態に戻ります。", Toast.LENGTH_LONG)
                            .show()
                    }
                    .setNegativeButton("NO") { _, _ ->

                    }
                    .show()

                return true
            }

            R.id.MenuList7 -> {
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

                        Toast.makeText(applicationContext, "保存しました。\n次にアプリを開いた時に追加されます。", Toast.LENGTH_LONG).show()

                return true
            }

            R.id.MenuList8 -> {
                AlertDialog.Builder(this)
                    .setTitle("終了しますか？")
                    .setPositiveButton("YES") { _, _ ->
                        finish()
                    }
                    .setNegativeButton("NO") { _, _ ->

                    }
                    .show()

                return true
            }

            R.id.MenuList9 -> {
                AlertDialog.Builder(this)
                    .setTitle("再起動しますか？")
                    .setPositiveButton("YES") { _, _ ->
                        ProcessPhoenix.triggerRebirth(this)
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