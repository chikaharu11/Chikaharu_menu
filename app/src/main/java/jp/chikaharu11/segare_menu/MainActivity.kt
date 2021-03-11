package jp.chikaharu11.segare_menu

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioAttributes
import android.media.SoundPool
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.provider.DocumentsContract
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.FileProvider
import com.jakewharton.processphoenix.ProcessPhoenix
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var container: ConstraintLayout

    private lateinit var inputMethodManager: InputMethodManager

    private val handler = Handler()

    private lateinit var mRealm: Realm

    private lateinit var soundPool: SoundPool

    private var sound1 = 0

    private var count = 16.toFloat()

    companion object {
        private const val READ_REQUEST_CODE: Int = 42
    }

    private fun selectMenu() {
        val saf = Uri.parse("content://com.android.externalstorage.documents/document/primary%3AAndroid%2Fdata%2Fjp.chikaharu11.segare_menu%2Ffiles%2FDCIM")
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(DocumentsContract.EXTRA_INITIAL_URI, saf)
            type = "image/*"
        }
        startActivityForResult(intent, READ_REQUEST_CODE)
    }

    fun menuList1() {
        val builder = android.app.AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_week, null)

        builder.setView(dialogView)
            .setTitle("項目の名前を変更できます。")
            .setPositiveButton("変更する") { _, _ ->

                mRealm.executeTransaction {
                    mRealm.where(Book6::class.java).findAll().deleteAllFromRealm()
                    val item1 = mRealm.createObject<Book6>(0)
                    item1.name =
                        dialogView.findViewById<EditText>(R.id.editText_8n).text.toString()

                    val item2 = mRealm.createObject<Book6>(1)
                    item2.name =
                        dialogView.findViewById<EditText>(R.id.editText_9n).text.toString()

                    val item3 = mRealm.createObject<Book6>(2)
                    item3.name =
                        dialogView.findViewById<EditText>(R.id.editText_8).text.toString()

                    val item4 = mRealm.createObject<Book6>(3)
                    item4.name =
                        dialogView.findViewById<EditText>(R.id.editText_9).text.toString()

                    editText8n.hint = item1.name + "　　　　"
                    editText4n.hint = item1.name + "　　　　"
                    editText13n.hint = item1.name + "　　　　"
                    editTextn.hint = item1.name + "　　　　"
                    editText11n.hint = item1.name + "　　　　"
                    editText10n.hint = item1.name + "　　　　"
                    editText12n.hint = item1.name + "　　　　"
                    editText9n.hint = item2.name + "　　　　"
                    editText7n.hint = item2.name + "　　　　"
                    editText15n.hint = item2.name + "　　　　"
                    editText16n.hint = item2.name + "　　　　"
                    editText18n.hint = item2.name + "　　　　"
                    editText17n.hint = item2.name + "　　　　"
                    editText14n.hint = item2.name + "　　　　"
                    editText8.hint = item3.name + "　　　　"
                    editText4.hint = item3.name + "　　　　"
                    editText13.hint = item3.name + "　　　　"
                    editText.hint = item3.name + "　　　　"
                    editText11.hint = item3.name + "　　　　"
                    editText10.hint = item3.name + "　　　　"
                    editText12.hint = item3.name + "　　　　"
                    editText9.hint = item4.name + "　　　　"
                    editText7.hint = item4.name + "　　　　"
                    editText15.hint = item4.name + "　　　　"
                    editText16.hint = item4.name + "　　　　"
                    editText18.hint = item4.name + "　　　　"
                    editText17.hint = item4.name + "　　　　"
                    editText14.hint = item4.name + "　　　　"
                }
                Toast.makeText(applicationContext, "項目の名前を変更しました。", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("キャンセル") { _, _ ->

            }

            .show()
        return
    }

    fun menuList10() {
        val builder = android.app.AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView2 = inflater.inflate(R.layout.dialog_title, null)

        builder.setView(dialogView2)
            .setTitle("タイトルを変更できます。")
            .setPositiveButton("変更する") { _, _ ->
                mRealm.executeTransaction {
                    mRealm.where(Book7::class.java).equalTo("id", 0.toLong()).findFirst()
                        ?.deleteFromRealm()
                    val item5 = mRealm.createObject<Book7>(0)
                    item5.name =
                        dialogView2.findViewById<EditText>(R.id.editText_title).text.toString().replace(
                            "/",
                            " "
                        )

                    supportActionBar?.title = item5.name
                }
                Toast.makeText(applicationContext, "タイトルを変更しました。", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("キャンセル") { _, _ ->

            }

            .show()
        return
    }

    fun menuList13() {

        count++

        textView.textSize = count
        textView2.textSize = count
        textView3.textSize = count
        textView4.textSize = count
        textView5.textSize = count
        textView6.textSize = count
        textView7.textSize = count
        editText8.textSize = count
        editText4.textSize = count
        editText13.textSize = count
        editText13n.textSize = count
        editText9.textSize = count
        editText7.textSize = count
        editText8n.textSize = count
        editText4n.textSize = count
        editTextn.textSize = count
        editText10n.textSize = count
        editText10.textSize = count
        editText.textSize = count
        editText12n.textSize = count
        editText12.textSize = count
        editText11n.textSize = count
        editText11.textSize = count
        editText9n.textSize = count
        editText7n.textSize = count
        editText15n.textSize = count
        editText15.textSize = count
        editText17n.textSize = count
        editText14n.textSize = count
        editText16.textSize = count
        editText14.textSize = count
        editText18.textSize = count
        editText17.textSize = count
        editText18n.textSize = count
        editText16n.textSize = count

        return
    }

    fun menuList14() {

        count--

        textView.textSize = count
        textView2.textSize = count
        textView3.textSize = count
        textView4.textSize = count
        textView5.textSize = count
        textView6.textSize = count
        textView7.textSize = count
        editText8.textSize = count
        editText4.textSize = count
        editText13.textSize = count
        editText13n.textSize = count
        editText9.textSize = count
        editText7.textSize = count
        editText8n.textSize = count
        editText4n.textSize = count
        editTextn.textSize = count
        editText10n.textSize = count
        editText10.textSize = count
        editText.textSize = count
        editText12n.textSize = count
        editText12.textSize = count
        editText11n.textSize = count
        editText11.textSize = count
        editText9n.textSize = count
        editText7n.textSize = count
        editText15n.textSize = count
        editText15.textSize = count
        editText17n.textSize = count
        editText14n.textSize = count
        editText16.textSize = count
        editText14.textSize = count
        editText18.textSize = count
        editText17.textSize = count
        editText18n.textSize = count
        editText16n.textSize = count

        return
    }

    fun menuList15() {

        findViewById<EditText>(R.id.textView).visibility = View.INVISIBLE
        findViewById<EditText>(R.id.textView2).visibility = View.INVISIBLE
        findViewById<EditText>(R.id.textView3).visibility = View.INVISIBLE
        findViewById<EditText>(R.id.textView4).visibility = View.INVISIBLE
        findViewById<EditText>(R.id.textView5).visibility = View.INVISIBLE
        findViewById<EditText>(R.id.textView6).visibility = View.INVISIBLE
        findViewById<EditText>(R.id.textView7).visibility = View.INVISIBLE

        val constraintSet = ConstraintSet()
        constraintSet.clone(allView)

        constraintSet.connect(editText12.id, ConstraintSet.START, view10.id, ConstraintSet.END, 2)

        constraintSet.applyTo(allView)

        return
    }

    fun menuList12() {

        view1.visibility = View.VISIBLE
        view2.visibility = View.VISIBLE
        view3.visibility = View.VISIBLE
        view4.visibility = View.VISIBLE
        view5.visibility = View.VISIBLE
        view.visibility = View.VISIBLE
        view7.visibility = View.VISIBLE
        view8.visibility = View.VISIBLE
        view6.visibility = View.VISIBLE
        view9.visibility = View.VISIBLE
        view10.visibility = View.VISIBLE
        Toast.makeText(applicationContext, "ラインはタッチすると消すことができます。", Toast.LENGTH_LONG)
            .show()

        return
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.allView)

        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

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
            textView.setText(week1, TextView.BufferType.NORMAL)
            textView2.setText(week2, TextView.BufferType.NORMAL)
            textView3.setText(week3, TextView.BufferType.NORMAL)
            textView4.setText(week4, TextView.BufferType.NORMAL)
            textView5.setText(week5, TextView.BufferType.NORMAL)
            textView6.setText(week6, TextView.BufferType.NORMAL)
            textView7.setText(week7, TextView.BufferType.NORMAL)
        }

        val item1 = mRealm.where(Book6::class.java).equalTo("id", 0.toLong()).findFirst()?.name
        val item2 = mRealm.where(Book6::class.java).equalTo("id", 1.toLong()).findFirst()?.name
        val item3 = mRealm.where(Book6::class.java).equalTo("id", 2.toLong()).findFirst()?.name
        val item4 = mRealm.where(Book6::class.java).equalTo("id", 3.toLong()).findFirst()?.name

        val item5 = mRealm.where(Book7::class.java).equalTo("id", 0.toLong()).findFirst()?.name

        if(item1 != null) {
            editText8n.hint = "$item1　　　　"
            editText4n.hint = "$item1　　　　"
            editText13n.hint = "$item1　　　　"
            editTextn.hint = "$item1　　　　"
            editText11n.hint = "$item1　　　　"
            editText10n.hint = "$item1　　　　"
            editText12n.hint = "$item1　　　　"
            editText9n.hint = "$item2　　　　"
            editText7n.hint = "$item2　　　　"
            editText15n.hint = "$item2　　　　"
            editText16n.hint = "$item2　　　　"
            editText18n.hint = "$item2　　　　"
            editText17n.hint = "$item2　　　　"
            editText14n.hint = "$item2　　　　"
            editText8.hint = "$item3　　　　"
            editText4.hint = "$item3　　　　"
            editText13.hint = "$item3　　　　"
            editText.hint = "$item3　　　　"
            editText11.hint = "$item3　　　　"
            editText10.hint = "$item3　　　　"
            editText12.hint = "$item3　　　　"
            editText9.hint = "$item4　　　　"
            editText7.hint = "$item4　　　　"
            editText15.hint = "$item4　　　　"
            editText16.hint = "$item4　　　　"
            editText18.hint = "$item4　　　　"
            editText17.hint = "$item4　　　　"
            editText14.hint = "$item4　　　　"
        }
        if(item5 != null){
            supportActionBar?.title = item5
        }

        view1.setOnClickListener{
            view1.visibility = View.INVISIBLE
        }
        view2.setOnClickListener{
            view2.visibility = View.INVISIBLE
        }
        view3.setOnClickListener{
            view3.visibility = View.INVISIBLE
        }
        view4.setOnClickListener{
            view4.visibility = View.INVISIBLE
        }
        view5.setOnClickListener{
            view5.visibility = View.INVISIBLE
        }
        view.setOnClickListener{
            view.visibility = View.INVISIBLE
        }
        view7.setOnClickListener{
            view7.visibility = View.INVISIBLE
        }
        view8.setOnClickListener{
            view8.visibility = View.INVISIBLE
        }
        view6.setOnClickListener{
            view6.visibility = View.INVISIBLE
        }
        view9.setOnClickListener{
            view9.visibility = View.INVISIBLE
        }
        view10.setOnClickListener{
            view10.visibility = View.INVISIBLE
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
                    editText8.hasFocus() -> { editText8.setText(item, TextView.BufferType.NORMAL)
                        editText8.clearFocus() }
                    editText4.hasFocus() -> { editText4.setText(item, TextView.BufferType.NORMAL)
                        editText4.clearFocus() }
                    editText.hasFocus() -> { editText.setText(item, TextView.BufferType.NORMAL)
                        editText.clearFocus() }
                    editText10.hasFocus() -> { editText10.setText(item, TextView.BufferType.NORMAL)
                        editText10.clearFocus() }
                    editText11.hasFocus() -> { editText11.setText(item, TextView.BufferType.NORMAL)
                        editText11.clearFocus() }
                    editText12.hasFocus() -> { editText12.setText(item, TextView.BufferType.NORMAL)
                        editText12.clearFocus() }
                    editText13.hasFocus() -> { editText13.setText(item, TextView.BufferType.NORMAL)
                        editText13.clearFocus() }
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
                    editText9.hasFocus() -> { editText9.setText(item, TextView.BufferType.NORMAL)
                        editText9.clearFocus() }
                    editText7.hasFocus() -> { editText7.setText(item, TextView.BufferType.NORMAL)
                        editText7.clearFocus() }
                    editText14.hasFocus() -> { editText14.setText(item, TextView.BufferType.NORMAL)
                        editText14.clearFocus() }
                    editText15.hasFocus() -> { editText15.setText(item, TextView.BufferType.NORMAL)
                        editText15.clearFocus() }
                    editText16.hasFocus() -> { editText16.setText(item, TextView.BufferType.NORMAL)
                        editText16.clearFocus() }
                    editText17.hasFocus() -> { editText17.setText(item, TextView.BufferType.NORMAL)
                        editText17.clearFocus() }
                    editText18.hasFocus() -> { editText18.setText(item, TextView.BufferType.NORMAL)
                        editText18.clearFocus() }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        editText8.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText8.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText4.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText4.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText10.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText10.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText11.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText11.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText12.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText12.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText13.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText13.setTextIsSelectable(true)
                customSpinner.performClick()
            }
        }
        editText9.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText9.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText7.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText7.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText14.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText14.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText15.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText15.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText16.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText16.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText17.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText17.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText18.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText18.setTextIsSelectable(true)
                customSpinner2.performClick()
            }
        }
        editText8n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText8n.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editText4n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText4n.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editTextn.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editTextn.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editText10n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText10n.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editText11n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText11n.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editText12n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText12n.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editText13n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText13n.setTextIsSelectable(true)
                customSpinner3.performClick()
            }
        }
        editText9n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText9n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
        }
        editText7n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText7n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
        }
        editText14n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText14n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
        }
        editText15n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText15n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
        }
        editText16n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText16n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
        }
        editText17n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText17n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
        }
        editText18n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (switch1.isChecked && hasFocus) {
                editText18n.setTextIsSelectable(true)
                customSpinner4.performClick()
            }
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
                    editText8n.hasFocus() -> { editText8n.setText(item, TextView.BufferType.NORMAL)
                        editText8n.clearFocus() }
                    editText4n.hasFocus() -> { editText4n.setText(item, TextView.BufferType.NORMAL)
                        editText4n.clearFocus() }
                    editTextn.hasFocus() -> { editTextn.setText(item, TextView.BufferType.NORMAL)
                        editTextn.clearFocus() }
                    editText10n.hasFocus() -> { editText10n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText10n.clearFocus() }
                    editText11n.hasFocus() -> { editText11n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText11n.clearFocus() }
                    editText12n.hasFocus() -> { editText12n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText12n.clearFocus() }
                    editText13n.hasFocus() -> { editText13n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText13n.clearFocus() }
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
                    editText9n.hasFocus() -> { editText9n.setText(item, TextView.BufferType.NORMAL)
                        editText9n.clearFocus() }
                    editText7n.hasFocus() -> { editText7n.setText(item, TextView.BufferType.NORMAL)
                        editText7n.clearFocus() }
                    editText14n.hasFocus() -> { editText14n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText14n.clearFocus() }
                    editText15n.hasFocus() -> { editText15n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText15n.clearFocus() }
                    editText16n.hasFocus() -> { editText16n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText16n.clearFocus() }
                    editText17n.hasFocus() -> { editText17n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText17n.clearFocus() }
                    editText18n.hasFocus() -> { editText18n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        editText18n.clearFocus() }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
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

        val menu1 = listOf(
            "タイトルの編集",
            "項目の編集",
            "文字を大きくする",
            "文字を小さくする",
            "ラインを引く",
            "曜日を隠す"
        )

        val menuSpinner = findViewById<Spinner>(R.id.customSpinner5)

        val adapterM = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, menu1
        )

        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)



        menuSpinner.adapter = adapterM


        menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                if (!menuSpinner.isFocusable) {
                    menuSpinner.isFocusable = true
                    return
                }
                when(position){
                    0 -> menuList10()
                    1 -> menuList1()
                    2 -> menuList13()
                    3 -> menuList14()
                    4 -> menuList12()
                    5 -> menuList15()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        menuSpinner.isFocusable = false

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        inputMethodManager.hideSoftInputFromWindow(
            container.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )

        container.requestFocus()

        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        if (resultCode != RESULT_OK) {
            return
        }
        when (requestCode) {
            READ_REQUEST_CODE -> {

                resultData?.data?.also { uri ->

                    val inputStream = contentResolver?.openInputStream(uri)
                    val image = BitmapFactory.decodeStream(inputStream)

                    val cachePath = File(this.cacheDir, "images")
                    cachePath.mkdirs()
                    val filePath = File(cachePath, "cache.png")
                    val fos = FileOutputStream(filePath.absolutePath)
                    image.compress(Bitmap.CompressFormat.PNG, 100, fos)
                    fos.close()

                    val contentUri = FileProvider.getUriForFile(
                        this,
                        applicationContext.packageName + ".fileprovider",
                        filePath
                    )

                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    shareIntent.setDataAndType(contentUri, contentResolver.getType(contentUri))
                    shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri)
                    startActivity(Intent.createChooser(shareIntent, "アプリを選ぶ"))
                }

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

        val menuLamp = menu.findItem(R.id.MenuList1)
        if (menuSwitch) {
            menuLamp.setIcon(R.drawable.ic_create_white_24dp)
        } else {
            menuLamp.setIcon(R.drawable.ic_baseline_content_paste_24)
        }

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

    override fun onPrepareOptionsMenu(menu: Menu?):Boolean {

        super.onPrepareOptionsMenu(menu)

        val menu1 = menu?.findItem(R.id.MenuList5c)
        val item1a = mRealm.where(Book6::class.java).equalTo("id", 0.toLong()).findFirst()?.name

        if (item1a != null) {
            if (menu1 != null) {
                menu1.title = item1a + "の編集"
            }
        }

        val menu2 = menu?.findItem(R.id.MenuList5d)
        val item2a = mRealm.where(Book6::class.java).equalTo("id", 1.toLong()).findFirst()?.name

        if (item2a != null) {
            if (menu2 != null) {
                menu2.title = item2a + "の編集"
            }
        }

        val menu3 = menu?.findItem(R.id.MenuList5a)
        val item3a = mRealm.where(Book6::class.java).equalTo("id", 2.toLong()).findFirst()?.name

        if (item3a != null) {
            if (menu3 != null) {
                menu3.title = item3a + "の編集"
            }
        }

        val menu4 = menu?.findItem(R.id.MenuList5b)
        val item4a = mRealm.where(Book6::class.java).equalTo("id", 3.toLong()).findFirst()?.name

        if (item4a != null) {
            if (menu4 != null) {
                menu4.title = item4a + "の編集"
            }
        }
        return true

    }

    private var menuSwitch = true

    @SuppressLint("SetTextI18n")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        MenuListFragmentActivity4()


        when (item.itemId) {

            R.id.MenuList1 -> {
                if (switch1.isChecked) {
                    menuSwitch = true
                    invalidateOptionsMenu()
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6200EE")))
                    Toast.makeText(applicationContext, "入力モード", Toast.LENGTH_SHORT).show()
                    switch1.isChecked = false
                } else {
                    menuSwitch = false
                    invalidateOptionsMenu()
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#EED100")))
                    val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                    Toast.makeText(applicationContext, "貼り付けモード", Toast.LENGTH_SHORT).show()
                    switch1.isChecked = true
                }
                return true
            }

            R.id.MenuList2 -> {
                getBitmapFromView(allView)
                return true
            }

            R.id.MenuList3 -> {
                selectMenu()
                return true
            }

            R.id.MenuList3a -> {
                customSpinner5.performClick()
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
                    .setMessage("(登録した内容を全て消去して、\n再起動します。)")
                    .setPositiveButton("YES") { _, _ ->
                        delete()
                        ProcessPhoenix.triggerRebirth(this)

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

                mRealm.executeTransaction {
                    mRealm.where(Book5::class.java).findAll().deleteAllFromRealm()
                    val week1 = mRealm.createObject<Book5>(0)
                    week1.name = textView.text.toString()

                    val week2 = mRealm.createObject<Book5>(1)
                    week2.name = textView2.text.toString()

                    val week3 = mRealm.createObject<Book5>(2)
                    week3.name = textView3.text.toString()

                    val week4 = mRealm.createObject<Book5>(3)
                    week4.name = textView4.text.toString()

                    val week5 = mRealm.createObject<Book5>(4)
                    week5.name = textView5.text.toString()

                    val week6 = mRealm.createObject<Book5>(5)
                    week6.name = textView6.text.toString()

                    val week7 = mRealm.createObject<Book5>(6)
                    week7.name = textView7.text.toString()
                }

                Toast.makeText(
                    applicationContext,
                    "保存しました。\n次にアプリを開いた時から追加されます。",
                    Toast.LENGTH_LONG
                ).show()

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