package jp.chikaharu11.chikaharu_menu

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
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
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
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

    private lateinit var mRealm: Realm

    private lateinit var soundPool: SoundPool

    private val handler = Handler()

    private var sound1 = 0

    private var count = 16.toFloat()

    private var lineFlag = 0

    private var pasteFlag = 0

    private var menuSwitch = 0

    private val locale: Locale = Locale.getDefault()

    companion object {
        private const val READ_REQUEST_CODE: Int = 42
        private const val READ_REQUEST_CODE2: Int = 43
    }

    private fun selectMenu() {
        binding.imageView.setImageDrawable(null)
        val saf = Uri.parse("content://com.android.externalstorage.documents/document/primary%3AAndroid%2Fdata%2Fjp.chikaharu11.chikaharu_menu%2Ffiles%2FDCIM")
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(DocumentsContract.EXTRA_INITIAL_URI, saf)
            type = "image/*"
        }
        startActivityForResult(intent, READ_REQUEST_CODE)
    }

    private fun selectMenu2() {
        binding.imageView.setImageDrawable(null)
        val saf = Uri.parse("content://com.android.externalstorage.documents/document/primary%3AAndroid%2Fdata%2Fjp.chikaharu11.chikaharu_menu%2Ffiles%2FDCIM")
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(DocumentsContract.EXTRA_INITIAL_URI, saf)
            type = "image/*"
        }
        startActivityForResult(intent, READ_REQUEST_CODE2)
    }

    fun menuList13() {

        count++

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

        if (binding.textView.isVisible) {
            binding.textView.visibility = View.INVISIBLE
            binding.textView2.visibility = View.INVISIBLE
            binding.textView3.visibility = View.INVISIBLE
            binding.textView4.visibility = View.INVISIBLE
            binding.textView5.visibility = View.INVISIBLE
            binding.textView6.visibility = View.INVISIBLE
            binding.textView7.visibility = View.INVISIBLE
            binding.textView8.visibility = View.INVISIBLE
            binding.textView9.visibility = View.INVISIBLE
            binding.textView10.visibility = View.INVISIBLE
            binding.textView11.visibility = View.INVISIBLE
            binding.textView12.visibility = View.INVISIBLE
            binding.textView13.visibility = View.INVISIBLE
            binding.textView14.visibility = View.INVISIBLE
            binding.view18.visibility = View.INVISIBLE

            val constraintSet = ConstraintSet()
            constraintSet.clone(binding.allView)

            val metrics = resources.displayMetrics
            val margin = (2 * metrics.density).toInt()

            constraintSet.connect(
                binding.editText12.id,
                ConstraintSet.START,
                binding.view10.id,
                ConstraintSet.END,
                margin
            )

            constraintSet.applyTo(binding.allView)
        } else if (binding.textView.isInvisible) {
            binding.textView.visibility = View.VISIBLE
            binding.textView2.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
            binding.textView4.visibility = View.VISIBLE
            binding.textView5.visibility = View.VISIBLE
            binding.textView6.visibility = View.VISIBLE
            binding.textView7.visibility = View.VISIBLE
            binding.textView8.visibility = View.VISIBLE
            binding.textView9.visibility = View.VISIBLE
            binding.textView10.visibility = View.VISIBLE
            binding.textView11.visibility = View.VISIBLE
            binding.textView12.visibility = View.VISIBLE
            binding.textView13.visibility = View.VISIBLE
            binding.textView14.visibility = View.VISIBLE
            binding.view18.visibility = View.VISIBLE

            val constraintSet = ConstraintSet()
            constraintSet.clone(binding.allView)

            val metrics = resources.displayMetrics
            val margin = (38 * metrics.density).toInt()

            constraintSet.connect(
                binding.editText12.id,
                ConstraintSet.START,
                binding.view10.id,
                ConstraintSet.END,
                margin
            )

            constraintSet.applyTo(binding.allView)
        }

        return
    }

    fun menuList12() {
        when (lineFlag) {
            0 -> {
                binding.view6.visibility = View.INVISIBLE
                binding.view18.visibility = View.INVISIBLE
                lineFlag = 1
            }
            1 -> {
                binding.view11.visibility = View.INVISIBLE
                binding.view12.visibility = View.INVISIBLE
                binding.view13.visibility = View.INVISIBLE
                binding.view14.visibility = View.INVISIBLE
                binding.view15.visibility = View.INVISIBLE
                binding.view16.visibility = View.INVISIBLE
                binding.view17.visibility = View.INVISIBLE
                binding.view6.visibility = View.VISIBLE
                binding.view18.visibility = View.VISIBLE
                lineFlag = 2
            }
            2 -> {

                binding.view6.visibility = View.INVISIBLE
                binding.view18.visibility = View.INVISIBLE
                lineFlag = 3
            }
            3 -> {

                binding.view6.visibility = View.VISIBLE
                binding.view11.visibility = View.VISIBLE
                binding.view12.visibility = View.VISIBLE
                binding.view13.visibility = View.VISIBLE
                binding.view14.visibility = View.VISIBLE
                binding.view15.visibility = View.VISIBLE
                binding.view16.visibility = View.VISIBLE
                binding.view17.visibility = View.VISIBLE
                binding.view18.visibility = View.VISIBLE
                lineFlag = 0
            }
        }

        return
    }

    fun hideKeyboard() {
        inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .apply { setContentView(this.root) }

        MobileAds.initialize(this) {}

        val adView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val spinner1a = findViewById<Spinner>(R.id.spinner1a)
        val spinner04 = findViewById<Spinner>(R.id.spinner04)
        val spinnerWP = findViewById<Spinner>(R.id.spinnerWP)

        container = findViewById(R.id.allView)

        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        fun convertPxToSp(px: Float): Float {
            return px / this.resources.displayMetrics.density
        }

        count = convertPxToSp(binding.editText8.textSize)
        
        val defaultTextSize = convertPxToSp(binding.editText8.textSize)

        val audioAttributes = AudioAttributes.Builder()

            .setUsage(AudioAttributes.USAGE_GAME)

            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder()

            .setAudioAttributes(audioAttributes)

            .setMaxStreams(1)
            .build()

        sound1 = soundPool.load(this, R.raw.cowbell_10, 1)

        if (locale == Locale.JAPAN) {
            binding.spinner04.adapter = ModelArrayAdapter(
                this,
                listOf(
                    Model(R.drawable.outline_smartphone_black_48dp, "見る　"),
                    Model(R.drawable.baseline_share_black_48dp, "シェアする　"),
                    Model(R.drawable.baseline_zoom_in_black_48dp, "文字を大きくする　"),
                    Model(R.drawable.baseline_zoom_out_black_48dp, "文字を小さくする　"),
                    Model(R.drawable.baseline_border_color_black_48dp, "線のパターンの変更　"),
                    Model(R.drawable.baseline_border_clear_black_48dp, "曜日の表示、非表示　"),
                    Model(R.drawable.outline_restart_alt_black_48dp, "再起動する　"),
                    Model(R.drawable.exit, "終了する　")
                )
            )
        } else {
            binding.spinner04.adapter = ModelArrayAdapter(
                this,
                listOf(
                    Model(R.drawable.outline_smartphone_black_48dp, "View  "),
                    Model(R.drawable.baseline_share_black_48dp, "Share  "),
                    Model(R.drawable.baseline_zoom_in_black_48dp, "Enlarge text  "),
                    Model(R.drawable.baseline_zoom_out_black_48dp, "Reduce text  "),
                    Model(R.drawable.baseline_border_color_black_48dp, "Change line pattern  "),
                    Model(R.drawable.baseline_border_clear_black_48dp, "Show/hide days of the week  "),
                    Model(R.drawable.outline_restart_alt_black_48dp, "Reboot  "),
                    Model(R.drawable.exit, "Exit  ")

                )
            )
        }

        if (locale == Locale.JAPAN) {
            binding.spinnerWP.adapter = ModelArrayAdapter(
                this,
                listOf(
                    Model(R.drawable.baseline_create_black_48dp, "手入力する　"),
                    Model(R.drawable.dinner_b, "メイン料理　"),
                    Model(R.drawable.carrot_b, "野菜、サラダ　"),
                    Model(R.drawable.soup_b, "味噌汁、スープ　"),
                    Model(R.drawable.apple_b, "果物、デザート　")
                )
            )
        } else {
            binding.spinnerWP.adapter = ModelArrayAdapter(
                this,
                listOf(
                    Model(R.drawable.baseline_create_black_48dp, "Manual input  "),
                    Model(R.drawable.dinner_b, "Main dish  "),
                    Model(R.drawable.carrot_b, "Salads  "),
                    Model(R.drawable.soup_b, "Soup  "),
                    Model(R.drawable.apple_b, "Fruits, Desserts  ")
                )
            )
        }


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
        val week8 = mRealm.where(Book5::class.java).equalTo("id", 7.toLong()).findFirst()?.name
        val week9 = mRealm.where(Book5::class.java).equalTo("id", 8.toLong()).findFirst()?.name
        val week10 = mRealm.where(Book5::class.java).equalTo("id", 9.toLong()).findFirst()?.name
        val week11 = mRealm.where(Book5::class.java).equalTo("id", 10.toLong()).findFirst()?.name
        val week12 = mRealm.where(Book5::class.java).equalTo("id", 11.toLong()).findFirst()?.name
        val week13 = mRealm.where(Book5::class.java).equalTo("id", 12.toLong()).findFirst()?.name
        val week14 = mRealm.where(Book5::class.java).equalTo("id", 13.toLong()).findFirst()?.name

        if(week1 != null){
            binding.textView.setText(week1, TextView.BufferType.NORMAL)
            binding.textView2.setText(week2, TextView.BufferType.NORMAL)
            binding.textView3.setText(week3, TextView.BufferType.NORMAL)
            binding.textView4.setText(week4, TextView.BufferType.NORMAL)
            binding.textView5.setText(week5, TextView.BufferType.NORMAL)
            binding.textView6.setText(week6, TextView.BufferType.NORMAL)
            binding.textView7.setText(week7, TextView.BufferType.NORMAL)
            binding.textView8.setText(week8, TextView.BufferType.NORMAL)
            binding.textView9.setText(week9, TextView.BufferType.NORMAL)
            binding.textView10.setText(week10, TextView.BufferType.NORMAL)
            binding.textView11.setText(week11, TextView.BufferType.NORMAL)
            binding.textView12.setText(week12, TextView.BufferType.NORMAL)
            binding.textView13.setText(week13, TextView.BufferType.NORMAL)
            binding.textView14.setText(week14, TextView.BufferType.NORMAL)
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
            if (locale == Locale.JAPAN) {
                supportActionBar?.title = "メニュー表"
            } else {
                supportActionBar?.title = "Menu list"
            }
        }


        val cuisine1 = if (locale == Locale.JAPAN) {
            mutableSetOf(

                "ハンバーグ",
                "餃子",
                "クリームシチュー",
                "肉野菜炒め",
                "唐揚げ",
                "ロールキャベツ",
                "麻婆豆腐",
                "エビフライ",
                "とんかつ",
                "すき焼き",
                "焼きそば",
                "ラーメン",
                "鍋焼きうどん",
                "ミートソースパスタ",
                "お好み焼き",
                "チャーハン",
                "オムライス",
                "豚生姜焼き",
                "マカロニグラタン",
                "ミートグラタン",
                "ビーフシチュー",
                "ビーフステーキ",
                "ハムカツ",
                "メンチカツ",
                "サイコロステーキ",
                "チキンステーキ",
                "オムライス",
                "肉じゃが",
                "牛丼",
                "カレー",
                "八宝菜",
                "ピーマンの肉詰め",
                "アスパラの肉巻き",
                "白菜の旨煮",
                "回鍋肉",
                "青椒肉絲",
                "ブリの照り焼き",
                "ブリ大根",
                "カツオのタタキ",
                "カレイの煮付け",
                "サバ味噌煮",
                "サンマの塩焼き",
                "焼鮭"
            )
        } else {
            mutableSetOf(

                "Shakshuka",
                "Creamy Chicken and Mushroom Skillet",
                "ORANGE BROWN BUTTER SHRIMP",
                "OMELET WITH MUSHROOMS, ONIONS AND MOZZARELLA",
                "Asparagus Chicken Flatbread Pizza",
                "Carbonara",
                "lemon rosemary pork chops with arugula salad",
                "Feijão Tropeiro",
                "Salmon Moqueca",
                "Meatloaf"
            )
        }

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

                if (pasteFlag == 1)
                when {
                    binding.editText8.hasFocus() -> { binding.editText8.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8.clearFocus()
                        binding.editText8.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4.hasFocus() -> { binding.editText4.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4.clearFocus()
                        binding.editText4.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText.hasFocus() -> { binding.editText.setText(item, TextView.BufferType.NORMAL)
                        binding.editText.clearFocus()
                        binding.editText.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10.hasFocus() -> { binding.editText10.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10.clearFocus()
                        binding.editText10.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11.hasFocus() -> { binding.editText11.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11.clearFocus()
                        binding.editText11.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12.hasFocus() -> { binding.editText12.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12.clearFocus()
                        binding.editText12.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13.hasFocus() -> { binding.editText13.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13.clearFocus()
                        binding.editText13.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9.hasFocus() -> { binding.editText9.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9.clearFocus()
                        binding.editText9.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7.hasFocus() -> { binding.editText7.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7.clearFocus()
                        binding.editText7.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14.hasFocus() -> { binding.editText14.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14.clearFocus()
                        binding.editText14.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15.hasFocus() -> { binding.editText15.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15.clearFocus()
                        binding.editText15.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16.hasFocus() -> { binding.editText16.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16.clearFocus()
                        binding.editText16.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17.hasFocus() -> { binding.editText17.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17.clearFocus()
                        binding.editText17.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18.hasFocus() -> { binding.editText18.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18.clearFocus()
                        binding.editText18.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText8n.hasFocus() -> { binding.editText8n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8n.clearFocus()
                        binding.editText8n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4n.hasFocus() -> { binding.editText4n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4n.clearFocus()
                        binding.editText4n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editTextn.hasFocus() -> { binding.editTextn.setText(item, TextView.BufferType.NORMAL)
                        binding.editTextn.clearFocus()
                        binding.editTextn.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10n.hasFocus() -> { binding.editText10n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10n.clearFocus()
                        binding.editText10n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11n.hasFocus() -> { binding.editText11n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11n.clearFocus()
                        binding.editText11n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12n.hasFocus() -> { binding.editText12n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12n.clearFocus()
                        binding.editText12n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13n.hasFocus() -> { binding.editText13n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13n.clearFocus()
                        binding.editText13n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9n.hasFocus() -> { binding.editText9n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9n.clearFocus()
                        binding.editText9n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7n.hasFocus() -> { binding.editText7n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7n.clearFocus()
                        binding.editText7n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14n.hasFocus() -> { binding.editText14n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14n.clearFocus()
                        binding.editText14n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15n.hasFocus() -> { binding.editText15n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15n.clearFocus()
                        binding.editText15n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16n.hasFocus() -> { binding.editText16n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16n.clearFocus()
                        binding.editText16n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17n.hasFocus() -> { binding.editText17n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17n.clearFocus()
                        binding.editText17n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18n.hasFocus() -> { binding.editText18n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18n.clearFocus()
                        binding.editText18n.textSize = defaultTextSize
                        hideKeyboard() }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val cuisine2 = mutableSetOf(

            "シーザーサラダ",
            "ツナレタスサラダ",
            "スティックサラダ",
            "マカロニサラダ",
            "トマトサラダ",
            "大根サラダ",
            "ポテトサラダ",
            "コールスロー",
            "豆腐とじゃこのサラダ",
            "きゅうりとちくわのサラダ",
            "ごぼうサラダ",
            "パスタサラダ",
            "エビとアボカドのサラダ",
            "きんぴらごぼう",
            "かぼちゃの煮付け",
            "ほうれん草のおひたし",
            "インゲンのごま和え",
            "筑前煮",
            "キャベツの塩昆布和え"
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

                if (pasteFlag == 2)
                when {
                    binding.editText8.hasFocus() -> { binding.editText8.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8.clearFocus()
                        binding.editText8.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4.hasFocus() -> { binding.editText4.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4.clearFocus()
                        binding.editText4.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText.hasFocus() -> { binding.editText.setText(item, TextView.BufferType.NORMAL)
                        binding.editText.clearFocus()
                        binding.editText.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10.hasFocus() -> { binding.editText10.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10.clearFocus()
                        binding.editText10.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11.hasFocus() -> { binding.editText11.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11.clearFocus()
                        binding.editText11.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12.hasFocus() -> { binding.editText12.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12.clearFocus()
                        binding.editText12.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13.hasFocus() -> { binding.editText13.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13.clearFocus()
                        binding.editText13.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9.hasFocus() -> { binding.editText9.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9.clearFocus()
                        binding.editText9.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7.hasFocus() -> { binding.editText7.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7.clearFocus()
                        binding.editText7.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14.hasFocus() -> { binding.editText14.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14.clearFocus()
                        binding.editText14.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15.hasFocus() -> { binding.editText15.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15.clearFocus()
                        binding.editText15.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16.hasFocus() -> { binding.editText16.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16.clearFocus()
                        binding.editText16.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17.hasFocus() -> { binding.editText17.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17.clearFocus()
                        binding.editText17.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18.hasFocus() -> { binding.editText18.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18.clearFocus()
                        binding.editText18.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText8n.hasFocus() -> { binding.editText8n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8n.clearFocus()
                        binding.editText8n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4n.hasFocus() -> { binding.editText4n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4n.clearFocus()
                        binding.editText4n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editTextn.hasFocus() -> { binding.editTextn.setText(item, TextView.BufferType.NORMAL)
                        binding.editTextn.clearFocus()
                        binding.editTextn.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10n.hasFocus() -> { binding.editText10n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10n.clearFocus()
                        binding.editText10n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11n.hasFocus() -> { binding.editText11n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11n.clearFocus()
                        binding.editText11n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12n.hasFocus() -> { binding.editText12n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12n.clearFocus()
                        binding.editText12n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13n.hasFocus() -> { binding.editText13n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13n.clearFocus()
                        binding.editText13n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9n.hasFocus() -> { binding.editText9n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9n.clearFocus()
                        binding.editText9n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7n.hasFocus() -> { binding.editText7n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7n.clearFocus()
                        binding.editText7n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14n.hasFocus() -> { binding.editText14n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14n.clearFocus()
                        binding.editText14n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15n.hasFocus() -> { binding.editText15n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15n.clearFocus()
                        binding.editText15n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16n.hasFocus() -> { binding.editText16n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16n.clearFocus()
                        binding.editText16n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17n.hasFocus() -> { binding.editText17n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17n.clearFocus()
                        binding.editText17n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18n.hasFocus() -> { binding.editText18n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18n.clearFocus()
                        binding.editText18n.textSize = defaultTextSize
                        hideKeyboard() }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val cuisine3 = mutableSetOf(

            "オニオングラタンスープ",
            "ミネストローネ",
            "豚汁",
            "けんちん汁",
            "ポトフ",
            "豆腐とわかめの味噌汁",
            "大根と油揚げの味噌汁",
            "しじみ汁",
            "あさりの味噌汁",
            "ニラと玉子の味噌汁",
            "白菜と小松菜の味噌汁",
            "椎茸とほうれん草の味噌汁",
            "ナスとエノキの味噌汁",
            "じゃがいもと玉ねぎの味噌汁",
            "なめこと豆腐の味噌汁",
            "レタスの味噌汁",
            "ピーマンの味噌汁",
            "アスパラとベーコンの味噌汁",
            "コンソメスープ",
            "クラムチャウダー",
            "ボルシチ",
            "キャベツと玉子のスープ",
            "カルビクッパ",
            "わかめスープ",
            "春雨スープ"
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

                if (pasteFlag == 3)
                    when {
                        binding.editText8.hasFocus() -> { binding.editText8.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8.clearFocus()
                        binding.editText8.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4.hasFocus() -> { binding.editText4.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4.clearFocus()
                        binding.editText4.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText.hasFocus() -> { binding.editText.setText(item, TextView.BufferType.NORMAL)
                        binding.editText.clearFocus()
                        binding.editText.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10.hasFocus() -> { binding.editText10.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10.clearFocus()
                        binding.editText10.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11.hasFocus() -> { binding.editText11.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11.clearFocus()
                        binding.editText11.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12.hasFocus() -> { binding.editText12.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12.clearFocus()
                        binding.editText12.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13.hasFocus() -> { binding.editText13.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13.clearFocus()
                        binding.editText13.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9.hasFocus() -> { binding.editText9.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9.clearFocus()
                        binding.editText9.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7.hasFocus() -> { binding.editText7.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7.clearFocus()
                        binding.editText7.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14.hasFocus() -> { binding.editText14.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14.clearFocus()
                        binding.editText14.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15.hasFocus() -> { binding.editText15.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15.clearFocus()
                        binding.editText15.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16.hasFocus() -> { binding.editText16.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16.clearFocus()
                        binding.editText16.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17.hasFocus() -> { binding.editText17.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17.clearFocus()
                        binding.editText17.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18.hasFocus() -> { binding.editText18.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18.clearFocus()
                        binding.editText18.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText8n.hasFocus() -> { binding.editText8n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8n.clearFocus()
                        binding.editText8n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4n.hasFocus() -> { binding.editText4n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4n.clearFocus()
                        binding.editText4n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editTextn.hasFocus() -> { binding.editTextn.setText(item, TextView.BufferType.NORMAL)
                        binding.editTextn.clearFocus()
                        binding.editTextn.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10n.hasFocus() -> { binding.editText10n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10n.clearFocus()
                        binding.editText10n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11n.hasFocus() -> { binding.editText11n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11n.clearFocus()
                        binding.editText11n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12n.hasFocus() -> { binding.editText12n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12n.clearFocus()
                        binding.editText12n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13n.hasFocus() -> { binding.editText13n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13n.clearFocus()
                        binding.editText13n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9n.hasFocus() -> { binding.editText9n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9n.clearFocus()
                        binding.editText9n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7n.hasFocus() -> { binding.editText7n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7n.clearFocus()
                        binding.editText7n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14n.hasFocus() -> { binding.editText14n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14n.clearFocus()
                        binding.editText14n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15n.hasFocus() -> { binding.editText15n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15n.clearFocus()
                        binding.editText15n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16n.hasFocus() -> { binding.editText16n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16n.clearFocus()
                        binding.editText16n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17n.hasFocus() -> { binding.editText17n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17n.clearFocus()
                        binding.editText17n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18n.hasFocus() -> { binding.editText18n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18n.clearFocus()
                        binding.editText18n.textSize = defaultTextSize
                        hideKeyboard() }
                    }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val cuisine4 = mutableSetOf(

            "りんご",
            "バナナ",
            "ヨーグルト",
            "フルーチェ",
            "シャーベット",
            "アイス",
            "キウイフルーツ",
            "ゼリー",
            "梨",
            "桃",
            "いちご",
            "ブドウ",
            "みかん",
            "オレンジ",
            "メロン",
            "りんごのグラッセ",
            "パンナコッタ",
            "杏仁豆腐",
            "ババロア",
            "チョコムース"
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

                if (pasteFlag == 4)
                    when {
                        binding.editText8.hasFocus() -> { binding.editText8.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8.clearFocus()
                        binding.editText8.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4.hasFocus() -> { binding.editText4.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4.clearFocus()
                        binding.editText4.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText.hasFocus() -> { binding.editText.setText(item, TextView.BufferType.NORMAL)
                        binding.editText.clearFocus()
                        binding.editText.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10.hasFocus() -> { binding.editText10.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10.clearFocus()
                        binding.editText10.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11.hasFocus() -> { binding.editText11.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11.clearFocus()
                        binding.editText11.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12.hasFocus() -> { binding.editText12.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12.clearFocus()
                        binding.editText12.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13.hasFocus() -> { binding.editText13.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13.clearFocus()
                        binding.editText13.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9.hasFocus() -> { binding.editText9.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9.clearFocus()
                        binding.editText9.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7.hasFocus() -> { binding.editText7.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7.clearFocus()
                        binding.editText7.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14.hasFocus() -> { binding.editText14.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14.clearFocus()
                        binding.editText14.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15.hasFocus() -> { binding.editText15.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15.clearFocus()
                        binding.editText15.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16.hasFocus() -> { binding.editText16.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16.clearFocus()
                        binding.editText16.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17.hasFocus() -> { binding.editText17.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17.clearFocus()
                        binding.editText17.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18.hasFocus() -> { binding.editText18.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18.clearFocus()
                        binding.editText18.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText8n.hasFocus() -> { binding.editText8n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText8n.clearFocus()
                        binding.editText8n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText4n.hasFocus() -> { binding.editText4n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText4n.clearFocus()
                        binding.editText4n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editTextn.hasFocus() -> { binding.editTextn.setText(item, TextView.BufferType.NORMAL)
                        binding.editTextn.clearFocus()
                        binding.editTextn.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText10n.hasFocus() -> { binding.editText10n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText10n.clearFocus()
                        binding.editText10n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText11n.hasFocus() -> { binding.editText11n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText11n.clearFocus()
                        binding.editText11n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText12n.hasFocus() -> { binding.editText12n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText12n.clearFocus()
                        binding.editText12n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText13n.hasFocus() -> { binding.editText13n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText13n.clearFocus()
                        binding.editText13n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText9n.hasFocus() -> { binding.editText9n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText9n.clearFocus()
                        binding.editText9n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText7n.hasFocus() -> { binding.editText7n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText7n.clearFocus()
                        binding.editText7n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText14n.hasFocus() -> { binding.editText14n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText14n.clearFocus()
                        binding.editText14n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText15n.hasFocus() -> { binding.editText15n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText15n.clearFocus()
                        binding.editText15n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText16n.hasFocus() -> { binding.editText16n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText16n.clearFocus()
                        binding.editText16n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText17n.hasFocus() -> { binding.editText17n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText17n.clearFocus()
                        binding.editText17n.textSize = defaultTextSize
                        hideKeyboard() }
                    binding.editText18n.hasFocus() -> { binding.editText18n.setText(item, TextView.BufferType.NORMAL)
                        binding.editText18n.clearFocus()
                        binding.editText18n.textSize = defaultTextSize
                        hideKeyboard() }
                    }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        binding.editText8.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText8.hasFocus() -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText8.hasFocus() -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText8.hasFocus() -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText8.hasFocus() -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText4.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText4.hasFocus() -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText4.hasFocus() -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText4.hasFocus() -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText4.hasFocus() -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText.hasFocus() -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText.hasFocus() -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText.hasFocus() -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText.hasFocus() -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText10.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText10.hasFocus() -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText10.hasFocus() -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText10.hasFocus() -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText10.hasFocus() -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText11.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText11.hasFocus() -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText11.hasFocus() -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText11.hasFocus() -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText11.hasFocus() -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText12.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText12.hasFocus() -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText12.hasFocus() -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText12.hasFocus() -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText12.hasFocus() -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText13.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText13.hasFocus() -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText13.hasFocus() -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText13.hasFocus() -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText13.hasFocus() -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText9.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText9.hasFocus() -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText9.hasFocus() -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText9.hasFocus() -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText9.hasFocus() -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText7.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText7.hasFocus() -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText7.hasFocus() -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText7.hasFocus() -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText7.hasFocus() -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText14.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText14.hasFocus() -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText14.hasFocus() -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText14.hasFocus() -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText14.hasFocus() -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText15.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText15.hasFocus() -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText15.hasFocus() -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText15.hasFocus() -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText15.hasFocus() -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText16.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText16.hasFocus() -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText16.hasFocus() -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText16.hasFocus() -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText16.hasFocus() -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText17.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText17.hasFocus() -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText17.hasFocus() -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText17.hasFocus() -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText17.hasFocus() -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText18.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText18.hasFocus() -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText18.hasFocus() -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText18.hasFocus() -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText18.hasFocus() -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText8n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText8n.hasFocus() -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText8n.hasFocus() -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText8n.hasFocus() -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText8n.hasFocus() -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText4n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText4n.hasFocus() -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText4n.hasFocus() -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText4n.hasFocus() -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText4n.hasFocus() -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editTextn.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editTextn.hasFocus() -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editTextn.hasFocus() -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editTextn.hasFocus() -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editTextn.hasFocus() -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText10n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText10n.hasFocus() -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText10n.hasFocus() -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText10n.hasFocus() -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText10n.hasFocus() -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText11n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText11n.hasFocus() -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText11n.hasFocus() -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText11n.hasFocus() -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText11n.hasFocus() -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText12n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText12n.hasFocus() -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText12n.hasFocus() -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText12n.hasFocus() -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText12n.hasFocus() -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText13n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText13n.hasFocus() -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText13n.hasFocus() -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText13n.hasFocus() -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText13n.hasFocus() -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText9n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText9n.hasFocus() -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText9n.hasFocus() -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText9n.hasFocus() -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText9n.hasFocus() -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText7n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText7n.hasFocus() -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText7n.hasFocus() -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText7n.hasFocus() -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText7n.hasFocus() -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText14n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText14n.hasFocus() -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText14n.hasFocus() -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText14n.hasFocus() -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText14n.hasFocus() -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText15n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText15n.hasFocus() -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText15n.hasFocus() -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText15n.hasFocus() -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText15n.hasFocus() -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText16n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText16n.hasFocus() -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText16n.hasFocus() -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText16n.hasFocus() -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText16n.hasFocus() -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText17n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText17n.hasFocus() -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText17n.hasFocus() -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText17n.hasFocus() -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText17n.hasFocus() -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText18n.setOnClickListener {
            when {
                pasteFlag == 1 && binding.editText18n.hasFocus() -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && binding.editText18n.hasFocus() -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && binding.editText18n.hasFocus() -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && binding.editText18n.hasFocus() -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }

        binding.editText8.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText8.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText4.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText4.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText10.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText10.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText11.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText11.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText12.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText12.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText13.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText13.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText9.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText9.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText7.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText7.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText14.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText14.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText15.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText15.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText16.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText16.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText17.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText17.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText18.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText18.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText8n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText8n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText4n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText4n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editTextn.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editTextn.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText10n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText10n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText11n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText11n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText12n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText12n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText13n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText13n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText9n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText9n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText7n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText7n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText14n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText14n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText15n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText15n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText16n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText16n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText17n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText17n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }
        binding.editText18n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            when {
                pasteFlag == 1 && hasFocus -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner.performClick()
                }
                pasteFlag == 2 && hasFocus -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner2.performClick()
                }
                pasteFlag == 3 && hasFocus -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner3.performClick()
                }
                pasteFlag == 4 && hasFocus -> {
                    binding.editText18n.setTextIsSelectable(true)
                    binding.customSpinner4.performClick()
                }
            }
        }

        binding.textView.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView2.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView2.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView3.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView3.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView4.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView4.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView5.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView5.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView6.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView6.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView7.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView7.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView8.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView8.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView9.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView9.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView10.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView10.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView11.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView11.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView12.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView12.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView13.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView13.textSize = defaultTextSize
                hideKeyboard()
            }
        }
        binding.textView14.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.textView14.textSize = defaultTextSize
                hideKeyboard()
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


            spinner04.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                if (!spinner04.isFocusable) {
                    spinner04.isFocusable = true
                    return
                }
                when(position){
                    0 -> {
                        selectMenu2()
                    }
                    1 -> {
                        selectMenu()
                    }
                    2 -> {
                        menuList13()
                    }
                    3 -> {
                        menuList14()
                    }
                    4 -> {
                        menuList12()
                    }
                    5 -> {
                        menuList15()
                    }
                    6 -> {
                        AlertDialog.Builder(this@MainActivity)
                            .setTitle(R.string.reboot)
                            .setPositiveButton("YES") { _, _ ->
                                ProcessPhoenix.triggerRebirth(this@MainActivity)
                            }
                            .setNegativeButton("NO") { _, _ ->

                            }
                            .show()
                    }
                    7 -> {
                        AlertDialog.Builder(this@MainActivity)
                            .setTitle(R.string.exit)
                            .setPositiveButton("YES") { _, _ ->
                                finish()
                            }
                            .setNegativeButton("NO") { _, _ ->

                            }
                            .show()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner04.isFocusable = false


        spinnerWP.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                if (!spinnerWP.isFocusable) {
                    spinnerWP.isFocusable = true
                    return
                }
                when (position) {
                    0 -> { menuSwitch = 0
                        invalidateOptionsMenu()
                        if (locale == Locale.JAPAN) {
                            supportActionBar?.title = "メニュー表"
                        } else {
                            supportActionBar?.title = "Menu list"
                        }
                        Toast.makeText(applicationContext, (R.string.Manual_input), Toast.LENGTH_SHORT).show()
                        pasteFlag = 0
                    }
                    1 -> { menuSwitch = 1
                        binding.textView14.requestFocus()
                        binding.textView14.clearFocus()
                        invalidateOptionsMenu()
                        if (locale == Locale.JAPAN) {
                            supportActionBar?.title = "メイン料理"
                        } else {
                            supportActionBar?.title = "Main dish"
                        }
                        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
                        Toast.makeText(applicationContext, (R.string.Main_dish), Toast.LENGTH_SHORT).show()
                        pasteFlag = 1
                    }
                    2 -> { menuSwitch = 2
                        binding.textView14.requestFocus()
                        binding.textView14.clearFocus()
                        invalidateOptionsMenu()
                        if (locale == Locale.JAPAN) {
                            supportActionBar?.title = "野菜、サラダ"
                        } else {
                            supportActionBar?.title = "Salads"
                        }
                        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
                        Toast.makeText(applicationContext, (R.string.Salads), Toast.LENGTH_SHORT).show()
                        pasteFlag = 2
                    }
                    3 -> { menuSwitch = 3
                        binding.textView14.requestFocus()
                        binding.textView14.clearFocus()
                        invalidateOptionsMenu()
                        if (locale == Locale.JAPAN) {
                            supportActionBar?.title = "味噌汁、スープ"
                        } else {
                            supportActionBar?.title = "Soup"
                        }
                        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
                        Toast.makeText(applicationContext, (R.string.Soup), Toast.LENGTH_SHORT).show()
                        pasteFlag = 3
                    }
                    4 -> { menuSwitch = 4
                        binding.textView14.requestFocus()
                        binding.textView14.clearFocus()
                        invalidateOptionsMenu()
                        if (locale == Locale.JAPAN) {
                            supportActionBar?.title = "果物、デザート"
                        } else {
                            supportActionBar?.title = "Fruits, Desserts"
                        }
                        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
                        Toast.makeText(applicationContext, (R.string.Fruits_Desserts), Toast.LENGTH_SHORT).show()
                        pasteFlag = 4
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerWP.isFocusable = false

        binding.textView8.editableText.clear()
        binding.textView9.editableText.clear()
        binding.textView10.editableText.clear()
        binding.textView11.editableText.clear()
        binding.textView12.editableText.clear()
        binding.textView13.editableText.clear()
        binding.textView14.editableText.clear()

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
                    if (locale == Locale.JAPAN) {
                        startActivity(Intent.createChooser(shareIntent, "アプリを選ぶ"))
                    } else {
                        startActivity(Intent.createChooser(shareIntent, "Choose an apps"))
                    }
                }

            }
            READ_REQUEST_CODE2 -> {
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
                    binding.adView.visibility = View.INVISIBLE
                    binding.imageView.visibility = View.VISIBLE
                    binding.imageView.setImageURI(contentUri)
                    Toast.makeText(applicationContext, (R.string.back), Toast.LENGTH_SHORT).show()
                }

            }

        }
    }


    @SuppressLint("SimpleDateFormat")
    private fun getBitmapFromView(view: View):Bitmap {
        val timeStamp: String = if (locale == Locale.JAPAN) {
            SimpleDateFormat("MM月dd日HH時mm分ss秒").format(Date())
        } else {
            SimpleDateFormat("MM-dd-yyyy-hh-mm-ss", Locale.US).format(Date())
        }
        val path = getExternalFilesDir(Environment.DIRECTORY_DCIM)?.path + "/" + timeStamp + ".png"
        val stream = FileOutputStream(path)
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()
        soundPool.play(sound1, 1.0f, 1.0f, 0, 0, 1.0f)
        Toast.makeText(applicationContext, (R.string.Screen_captured), Toast.LENGTH_LONG).show()
        return bitmap
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle(R.string.exit)
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


    private fun delete() {
        mRealm.executeTransaction {
            mRealm.deleteAll()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_options_menu_list, menu)

        val menuLamp = menu.findItem(R.id.MenuList1)
        when (menuSwitch) {
            0 -> {
                menuLamp.setIcon(R.drawable.baseline_create_white_48dp)
            }
            1 -> {
                menuLamp.setIcon(R.drawable.dinner_w)
            }
            2 -> {
                menuLamp.setIcon(R.drawable.carrot_w)
            }
            3 -> {
                menuLamp.setIcon(R.drawable.soup_w)
            }
            4 -> {
                menuLamp.setIcon(R.drawable.apple_w)
            }
        }

        return super.onCreateOptionsMenu(menu)
    }


    override fun onPrepareOptionsMenu(menu: Menu?):Boolean {

        super.onPrepareOptionsMenu(menu)

        return true

    }



    @SuppressLint("SetTextI18n")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val spinner04 = findViewById<Spinner>(R.id.spinner04)
        val spinnerWP = findViewById<Spinner>(R.id.spinnerWP)


        when (item.itemId) {

            R.id.MenuList1 -> {
                hideKeyboard()
                binding.adView.visibility = View.VISIBLE
                binding.imageView.visibility = View.INVISIBLE
                spinnerWP.performClick()
                return true
            }

            R.id.MenuList2 -> {
                binding.imageView.visibility = View.INVISIBLE
                binding.adView.visibility = View.GONE
                binding.textView14.requestFocus()
                binding.textView14.clearFocus()
                handler.postDelayed( { getBitmapFromView(binding.allView) }, 50)
                handler.postDelayed( { binding.adView.visibility = View.VISIBLE }, 50)
                return true
            }

            R.id.MenuList3a -> {
                hideKeyboard()
                binding.adView.visibility = View.VISIBLE
                binding.imageView.visibility = View.INVISIBLE
                spinner04.performClick()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}