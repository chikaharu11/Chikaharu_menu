package jp.chikaharu11.chikaharu_menu

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
import com.google.gson.Gson
import com.jakewharton.processphoenix.ProcessPhoenix
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import jp.chikaharu11.chikaharu_menu.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var container: ConstraintLayout

    private lateinit var inputMethodManager: InputMethodManager

    private lateinit var binding: ActivityMainBinding

    private val handler = Handler()

    private lateinit var mRealm: Realm

    private lateinit var soundPool: SoundPool

    private var sound1 = 0

    private var count = 16.toFloat()

    companion object {
        private const val READ_REQUEST_CODE: Int = 42
    }

    private fun selectMenu() {
        val saf = Uri.parse("content://com.android.externalstorage.documents/document/primary%3AAndroid%2Fdata%2Fjp.chikaharu11.chikaharu_menu%2Ffiles%2FDCIM")
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

                    binding.editText8n.hint = item1.name + "　　　　"
                    binding.editText4n.hint = item1.name + "　　　　"
                    binding.editText13n.hint = item1.name + "　　　　"
                    binding.editTextn.hint = item1.name + "　　　　"
                    binding.editText11n.hint = item1.name + "　　　　"
                    binding.editText10n.hint = item1.name + "　　　　"
                    binding.editText12n.hint = item1.name + "　　　　"
                    binding.editText9n.hint = item2.name + "　　　　"
                    binding.editText7n.hint = item2.name + "　　　　"
                    binding.editText15n.hint = item2.name + "　　　　"
                    binding.editText16n.hint = item2.name + "　　　　"
                    binding.editText18n.hint = item2.name + "　　　　"
                    binding.editText17n.hint = item2.name + "　　　　"
                    binding.editText14n.hint = item2.name + "　　　　"
                    binding.editText8.hint = item3.name + "　　　　"
                    binding.editText4.hint = item3.name + "　　　　"
                    binding.editText13.hint = item3.name + "　　　　"
                    binding.editText.hint = item3.name + "　　　　"
                    binding.editText11.hint = item3.name + "　　　　"
                    binding.editText10.hint = item3.name + "　　　　"
                    binding.editText12.hint = item3.name + "　　　　"
                    binding.editText9.hint = item4.name + "　　　　"
                    binding.editText7.hint = item4.name + "　　　　"
                    binding.editText15.hint = item4.name + "　　　　"
                    binding.editText16.hint = item4.name + "　　　　"
                    binding.editText18.hint = item4.name + "　　　　"
                    binding.editText17.hint = item4.name + "　　　　"
                    binding.editText14.hint = item4.name + "　　　　"
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

        binding.textView.textSize = count
        binding.textView2.textSize = count
        binding.textView3.textSize = count
        binding.textView4.textSize = count
        binding.textView5.textSize = count
        binding.textView6.textSize = count
        binding.textView7.textSize = count
        binding.editText8.textSize = count
        binding.editText4.textSize = count
        binding.editText13.textSize = count
        binding.editText13n.textSize = count
        binding.editText9.textSize = count
        binding.editText7.textSize = count
        binding.editText8n.textSize = count
        binding.editText4n.textSize = count
        binding.editTextn.textSize = count
        binding.editText10n.textSize = count
        binding.editText10.textSize = count
        binding.editText.textSize = count
        binding.editText12n.textSize = count
        binding.editText12.textSize = count
        binding.editText11n.textSize = count
        binding.editText11.textSize = count
        binding.editText9n.textSize = count
        binding.editText7n.textSize = count
        binding.editText15n.textSize = count
        binding.editText15.textSize = count
        binding.editText17n.textSize = count
        binding.editText14n.textSize = count
        binding.editText16.textSize = count
        binding.editText14.textSize = count
        binding.editText18.textSize = count
        binding.editText17.textSize = count
        binding.editText18n.textSize = count
        binding.editText16n.textSize = count

        return
    }

    fun menuList14() {

        count--

        binding.textView.textSize = count
        binding.textView2.textSize = count
        binding.textView3.textSize = count
        binding.textView4.textSize = count
        binding.textView5.textSize = count
        binding.textView6.textSize = count
        binding.textView7.textSize = count
        binding.editText8.textSize = count
        binding.editText4.textSize = count
        binding.editText13.textSize = count
        binding.editText13n.textSize = count
        binding.editText9.textSize = count
        binding.editText7.textSize = count
        binding.editText8n.textSize = count
        binding.editText4n.textSize = count
        binding.editTextn.textSize = count
        binding.editText10n.textSize = count
        binding.editText10.textSize = count
        binding.editText.textSize = count
        binding.editText12n.textSize = count
        binding.editText12.textSize = count
        binding.editText11n.textSize = count
        binding.editText11.textSize = count
        binding.editText9n.textSize = count
        binding.editText7n.textSize = count
        binding.editText15n.textSize = count
        binding.editText15.textSize = count
        binding.editText17n.textSize = count
        binding.editText14n.textSize = count
        binding.editText16.textSize = count
        binding.editText14.textSize = count
        binding.editText18.textSize = count
        binding.editText17.textSize = count
        binding.editText18n.textSize = count
        binding.editText16n.textSize = count

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
        constraintSet.clone(binding.allView)

        constraintSet.connect(binding.editText12.id, ConstraintSet.START, binding.view10.id, ConstraintSet.END, 2)

        constraintSet.applyTo(binding.allView)

        return
    }

    fun menuList12() {

        binding.view1.visibility = View.VISIBLE
        binding.view2.visibility = View.VISIBLE
        binding.view3.visibility = View.VISIBLE
        binding.view4.visibility = View.VISIBLE
        binding.view5.visibility = View.VISIBLE
        binding.view.visibility = View.VISIBLE
        binding.view7.visibility = View.VISIBLE
        binding.view8.visibility = View.VISIBLE
        binding.view6.visibility = View.VISIBLE
        binding.view9.visibility = View.VISIBLE
        binding.view10.visibility = View.VISIBLE
        binding.view11.visibility = View.VISIBLE
        binding.view12.visibility = View.VISIBLE
        binding.view13.visibility = View.VISIBLE
        binding.view14.visibility = View.VISIBLE
        binding.view15.visibility = View.VISIBLE
        binding.view16.visibility = View.VISIBLE
        binding.view17.visibility = View.VISIBLE
        Toast.makeText(applicationContext, "ラインはタッチすると消すことができます。", Toast.LENGTH_LONG)
            .show()

        return
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
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

        val modelList: List<Model> = readFromAsset()

        val customDropDownAdapter = CustomDropDownAdapter(this, modelList)
        binding.spinner04.adapter = customDropDownAdapter

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
            binding.textView.setText(week1, TextView.BufferType.NORMAL)
            binding.textView2.setText(week2, TextView.BufferType.NORMAL)
            binding.textView3.setText(week3, TextView.BufferType.NORMAL)
            binding.textView4.setText(week4, TextView.BufferType.NORMAL)
            binding.textView5.setText(week5, TextView.BufferType.NORMAL)
            binding.textView6.setText(week6, TextView.BufferType.NORMAL)
            binding.textView7.setText(week7, TextView.BufferType.NORMAL)
        }

        val item1 = mRealm.where(Book6::class.java).equalTo("id", 0.toLong()).findFirst()?.name
        val item2 = mRealm.where(Book6::class.java).equalTo("id", 1.toLong()).findFirst()?.name
        val item3 = mRealm.where(Book6::class.java).equalTo("id", 2.toLong()).findFirst()?.name
        val item4 = mRealm.where(Book6::class.java).equalTo("id", 3.toLong()).findFirst()?.name

        val item5 = mRealm.where(Book7::class.java).equalTo("id", 0.toLong()).findFirst()?.name

        if(item1 != null) {
            binding.editText8n.hint = "$item1　　　　"
            binding.editText4n.hint = "$item1　　　　"
            binding.editText13n.hint = "$item1　　　　"
            binding.editTextn.hint = "$item1　　　　"
            binding.editText11n.hint = "$item1　　　　"
            binding.editText10n.hint = "$item1　　　　"
            binding.editText12n.hint = "$item1　　　　"
            binding.editText9n.hint = "$item2　　　　"
            binding.editText7n.hint = "$item2　　　　"
            binding.editText15n.hint = "$item2　　　　"
            binding.editText16n.hint = "$item2　　　　"
            binding.editText18n.hint = "$item2　　　　"
            binding.editText17n.hint = "$item2　　　　"
            binding.editText14n.hint = "$item2　　　　"
            binding.editText8.hint = "$item3　　　　"
            binding.editText4.hint = "$item3　　　　"
            binding.editText13.hint = "$item3　　　　"
            binding.editText.hint = "$item3　　　　"
            binding.editText11.hint = "$item3　　　　"
            binding.editText10.hint = "$item3　　　　"
            binding.editText12.hint = "$item3　　　　"
            binding.editText9.hint = "$item4　　　　"
            binding.editText7.hint = "$item4　　　　"
            binding.editText15.hint = "$item4　　　　"
            binding.editText16.hint = "$item4　　　　"
            binding.editText18.hint = "$item4　　　　"
            binding.editText17.hint = "$item4　　　　"
            binding.editText14.hint = "$item4　　　　"
        }
        if(item5 != null){
            supportActionBar?.title = item5
        } else {
            supportActionBar?.title = "Menu"
        }

        binding.view1.setOnClickListener{
            binding.view1.visibility = View.INVISIBLE
        }
        binding.view2.setOnClickListener{
            binding.view2.visibility = View.INVISIBLE
        }
        binding.view3.setOnClickListener{
            binding.view3.visibility = View.INVISIBLE
        }
        binding.view4.setOnClickListener{
            binding.view4.visibility = View.INVISIBLE
        }
        binding.view5.setOnClickListener{
            binding.view5.visibility = View.INVISIBLE
        }
        binding.view.setOnClickListener{
            binding.view.visibility = View.INVISIBLE
        }
        binding.view7.setOnClickListener{
            binding.view7.visibility = View.INVISIBLE
        }
        binding.view8.setOnClickListener{
            binding.view8.visibility = View.INVISIBLE
        }
        binding.view6.setOnClickListener{
            binding.view6.visibility = View.INVISIBLE
        }
        binding.view9.setOnClickListener{
            binding.view9.visibility = View.INVISIBLE
        }
        binding.view10.setOnClickListener{
            binding.view10.visibility = View.INVISIBLE
        }
        binding.view11.setOnClickListener{
            binding.view11.visibility = View.INVISIBLE
        }
        binding.view12.setOnClickListener{
            binding.view12.visibility = View.INVISIBLE
        }
        binding.view13.setOnClickListener{
            binding.view13.visibility = View.INVISIBLE
        }
        binding.view14.setOnClickListener{
            binding.view14.visibility = View.INVISIBLE
        }
        binding.view15.setOnClickListener{
            binding.view15.visibility = View.INVISIBLE
        }
        binding.view16.setOnClickListener{
            binding.view16.visibility = View.INVISIBLE
        }
        binding.view17.setOnClickListener{
            binding.view17.visibility = View.INVISIBLE
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



        binding.customSpinner.adapter = adapter


        binding.customSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    binding.editText8.hasFocus() -> { binding.editText8.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8.clearFocus() }
                    binding.editText4.hasFocus() -> { binding.editText4.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4.clearFocus() }
                    binding.editText.hasFocus() -> { binding.editText.setText(item, TextView.BufferType.NORMAL)
                        binding.editText.clearFocus() }
                    binding.editText10.hasFocus() -> { binding.editText10.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10.clearFocus() }
                    binding.editText11.hasFocus() -> { binding.editText11.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11.clearFocus() }
                    binding.editText12.hasFocus() -> { binding.editText12.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12.clearFocus() }
                    binding.editText13.hasFocus() -> { binding.editText13.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13.clearFocus() }
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


        binding.customSpinner2.adapter = adapter2


        binding.customSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    binding.editText9.hasFocus() -> { binding.editText9.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9.clearFocus() }
                    binding.editText7.hasFocus() -> { binding.editText7.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7.clearFocus() }
                    binding.editText14.hasFocus() -> { binding.editText14.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14.clearFocus() }
                    binding.editText15.hasFocus() -> { binding.editText15.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15.clearFocus() }
                    binding.editText16.hasFocus() -> { binding.editText16.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16.clearFocus() }
                    binding.editText17.hasFocus() -> { binding.editText17.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17.clearFocus() }
                    binding.editText18.hasFocus() -> { binding.editText18.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18.clearFocus() }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        binding.editText8.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText8.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText4.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText4.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText10.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText10.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText11.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText11.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText12.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText12.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText13.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText13.setTextIsSelectable(true)
                binding.customSpinner.performClick()
            }
        }
        binding.editText9.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText9.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText7.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText7.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText14.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText14.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText15.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText15.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText16.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText16.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText17.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText17.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText18.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText18.setTextIsSelectable(true)
                binding.customSpinner2.performClick()
            }
        }
        binding.editText8n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText8n.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editText4n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText4n.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editTextn.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editTextn.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editText10n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText10n.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editText11n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText11n.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editText12n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText12n.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editText13n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText13n.setTextIsSelectable(true)
                binding.customSpinner3.performClick()
            }
        }
        binding.editText9n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText9n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
            }
        }
        binding.editText7n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText7n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
            }
        }
        binding.editText14n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText14n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
            }
        }
        binding.editText15n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText15n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
            }
        }
        binding.editText16n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText16n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
            }
        }
        binding.editText17n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText17n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
            }
        }
        binding.editText18n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (binding.switch1.isChecked && hasFocus) {
                binding.editText18n.setTextIsSelectable(true)
                binding.customSpinner4.performClick()
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

        binding.customSpinner3.adapter = adapter3

        binding.customSpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    binding.editText8n.hasFocus() -> { binding.editText8n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8n.clearFocus() }
                    binding.editText4n.hasFocus() -> { binding.editText4n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4n.clearFocus() }
                    binding.editTextn.hasFocus() -> { binding.editTextn.setText(item, TextView.BufferType.NORMAL)
                        binding.editTextn.clearFocus() }
                    binding.editText10n.hasFocus() -> { binding.editText10n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10n.clearFocus() }
                    binding.editText11n.hasFocus() -> { binding.editText11n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11n.clearFocus() }
                    binding.editText12n.hasFocus() -> { binding.editText12n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12n.clearFocus() }
                    binding.editText13n.hasFocus() -> { binding.editText13n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13n.clearFocus() }
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

        binding.customSpinner4.adapter = adapter4

        binding.customSpinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                when {
                    binding.editText9n.hasFocus() -> { binding.editText9n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9n.clearFocus() }
                    binding.editText7n.hasFocus() -> { binding.editText7n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7n.clearFocus() }
                    binding.editText14n.hasFocus() -> { binding.editText14n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        binding.editText14n.clearFocus() }
                    binding.editText15n.hasFocus() -> { binding.editText15n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        binding.editText15n.clearFocus() }
                    binding.editText16n.hasFocus() -> { binding.editText16n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        binding.editText16n.clearFocus() }
                    binding.editText17n.hasFocus() -> { binding.editText17n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        binding.editText17n.clearFocus() }
                    binding.editText18n.hasFocus() -> { binding.editText18n.setText(
                        item,
                        TextView.BufferType.NORMAL
                    )
                        binding.editText18n.clearFocus() }
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


        binding.spinner1a.adapter = adapter5

        binding.spinner1a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

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


        binding.spinner2a.adapter = adapter6

        binding.spinner2a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

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


        binding.spinner3a.adapter = adapter7

        binding.spinner3a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

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


        binding.spinner4a.adapter = adapter8

        binding.spinner4a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

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


            binding.spinner04.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                if (!binding.spinner04.isFocusable) {
                    binding.spinner04.isFocusable = true
                    return
                }
                when(position){
                    0 -> {

                    }
                    1 -> { menuList10()
                        binding.spinner04.setSelection(0)
                    }
                    2 -> { menuList1()
                        binding.spinner04.setSelection(0)
                    }
                    3 -> { menuList13()
                        binding.spinner04.setSelection(0)
                    }
                    4 -> { menuList14()
                        binding.spinner04.setSelection(0)
                    }
                    5 -> { menuList12()
                        binding.spinner04.setSelection(0)
                    }
                    6 -> { menuList15()
                        binding.spinner04.setSelection(0)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        binding.spinner04.isFocusable = false
    }

    private fun readFromAsset(): List<Model> {
        val filename = "android_version.json"

        val bufferReader = application.assets.open(filename).bufferedReader()

        val jsonstring = bufferReader.use {
            it.readText()
        }
        val gson = Gson()
        return gson.fromJson(jsonstring, Array<Model>::class.java).toList()
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
                if (binding.switch1.isChecked) {
                    menuSwitch = true
                    invalidateOptionsMenu()
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6200EE")))
                    Toast.makeText(applicationContext, "入力モード", Toast.LENGTH_SHORT).show()
                    binding.switch1.isChecked = false
                } else {
                    menuSwitch = false
                    invalidateOptionsMenu()
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#EED100")))
                    val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
                    Toast.makeText(applicationContext, "貼り付けモード", Toast.LENGTH_SHORT).show()
                    binding.switch1.isChecked = true
                }
                return true
            }

            R.id.MenuList2 -> {
                getBitmapFromView(binding.allView)
                return true
            }

            R.id.MenuList3 -> {
                selectMenu()
                return true
            }

            R.id.MenuList3a -> {
                binding.spinner04.performClick()
                return true
            }

            R.id.MenuList4 -> {
                binding.switch3.setOnCheckedChangeListener { _, isChecked ->
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
                binding.switch3.performClick()
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


                binding.spinner1a.adapter = adapter5a
                handler.postDelayed({ binding.spinner1a.performClick() }, 300)
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


                binding.spinner2a.adapter = adapter6a
                handler.postDelayed({ binding.spinner2a.performClick() }, 300)
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


                binding.spinner3a.adapter = adapter7a
                handler.postDelayed({ binding.spinner3a.performClick() }, 300)
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


                binding.spinner4a.adapter = adapter8a
                handler.postDelayed({ binding.spinner4a.performClick() }, 300)
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
                val stringText11 = binding.editText8.text.toString()
                create(stringText11)
                val stringText12 = binding.editText4.text.toString()
                create(stringText12)
                val stringText13 = binding.editText13.text.toString()
                create(stringText13)
                val stringText14 = binding.editText.text.toString()
                create(stringText14)
                val stringText15 = binding.editText11.text.toString()
                create(stringText15)
                val stringText16 = binding.editText10.text.toString()
                create(stringText16)
                val stringText17 = binding.editText12.text.toString()
                create(stringText17)

                val stringText21 = binding.editText9.text.toString()
                create2(stringText21)
                val stringText22 = binding.editText7.text.toString()
                create2(stringText22)
                val stringText23 = binding.editText15.text.toString()
                create2(stringText23)
                val stringText24 = binding.editText16.text.toString()
                create2(stringText24)
                val stringText25 = binding.editText18.text.toString()
                create2(stringText25)
                val stringText26 = binding.editText17.text.toString()
                create2(stringText26)
                val stringText27 = binding.editText14.text.toString()
                create2(stringText27)

                val stringText31 = binding.editText8n.text.toString()
                create3(stringText31)
                val stringText32 = binding.editText4n.text.toString()
                create3(stringText32)
                val stringText33 = binding.editText13n.text.toString()
                create3(stringText33)
                val stringText34 = binding.editTextn.text.toString()
                create3(stringText34)
                val stringText35 = binding.editText11n.text.toString()
                create3(stringText35)
                val stringText36 = binding.editText10n.text.toString()
                create3(stringText36)
                val stringText37 = binding.editText12n.text.toString()
                create3(stringText37)

                val stringText41 = binding.editText9n.text.toString()
                create4(stringText41)
                val stringText42 = binding.editText7n.text.toString()
                create4(stringText42)
                val stringText43 = binding.editText15n.text.toString()
                create4(stringText43)
                val stringText44 = binding.editText16n.text.toString()
                create4(stringText44)
                val stringText45 = binding.editText18n.text.toString()
                create4(stringText45)
                val stringText46 = binding.editText17n.text.toString()
                create4(stringText46)
                val stringText47 = binding.editText14n.text.toString()
                create4(stringText47)

                mRealm.executeTransaction {
                    mRealm.where(Book5::class.java).findAll().deleteAllFromRealm()
                    val week1 = mRealm.createObject<Book5>(0)
                    week1.name = binding.textView.text.toString()

                    val week2 = mRealm.createObject<Book5>(1)
                    week2.name = binding.textView2.text.toString()

                    val week3 = mRealm.createObject<Book5>(2)
                    week3.name = binding.textView3.text.toString()

                    val week4 = mRealm.createObject<Book5>(3)
                    week4.name = binding.textView4.text.toString()

                    val week5 = mRealm.createObject<Book5>(4)
                    week5.name = binding.textView5.text.toString()

                    val week6 = mRealm.createObject<Book5>(5)
                    week6.name = binding.textView6.text.toString()

                    val week7 = mRealm.createObject<Book5>(6)
                    week7.name = binding.textView7.text.toString()
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