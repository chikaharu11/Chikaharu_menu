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
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
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

class MainActivity : AppCompatActivity(), CustomAdapterListener {

    private lateinit var container: ConstraintLayout

    private lateinit var inputMethodManager: InputMethodManager

    private lateinit var binding: ActivityMainBinding

    private lateinit var mRealm: Realm

    private lateinit var soundPool: SoundPool

    private lateinit var aCustomAdapter: CustomAdapter
    private lateinit var bCustomAdapter: CustomAdapter
    private lateinit var cCustomAdapter: CustomAdapter
    private lateinit var dCustomAdapter: CustomAdapter

    private lateinit var aCuisines: MutableList<Cuisine>
    private lateinit var bCuisines: MutableList<Cuisine>
    private lateinit var cCuisines: MutableList<Cuisine>
    private lateinit var dCuisines: MutableList<Cuisine>


    private val handler = Handler()

    private var sound1 = 0

    private var count = 16.toFloat()

    private var count2 = 0.toFloat()

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

    private fun hideKeyboard() {
        inputMethodManager.hideSoftInputFromWindow(binding.view.windowToken, 0)
    }
    
    fun nullKeyboard() {
        
        binding.editText8.setRawInputType(InputType.TYPE_NULL)
        binding.editText4.setRawInputType(InputType.TYPE_NULL)
        binding.editText13.setRawInputType(InputType.TYPE_NULL)
        binding.editText13n.setRawInputType(InputType.TYPE_NULL)
        binding.editText9.setRawInputType(InputType.TYPE_NULL)
        binding.editText7.setRawInputType(InputType.TYPE_NULL)
        binding.editText8n.setRawInputType(InputType.TYPE_NULL)
        binding.editText4n.setRawInputType(InputType.TYPE_NULL)
        binding.editTextn.setRawInputType(InputType.TYPE_NULL)
        binding.editText10n.setRawInputType(InputType.TYPE_NULL)
        binding.editText10.setRawInputType(InputType.TYPE_NULL)
        binding.editText.setRawInputType(InputType.TYPE_NULL)
        binding.editText12n.setRawInputType(InputType.TYPE_NULL)
        binding.editText12.setRawInputType(InputType.TYPE_NULL)
        binding.editText11n.setRawInputType(InputType.TYPE_NULL)
        binding.editText11.setRawInputType(InputType.TYPE_NULL)
        binding.editText9n.setRawInputType(InputType.TYPE_NULL)
        binding.editText7n.setRawInputType(InputType.TYPE_NULL)
        binding.editText15n.setRawInputType(InputType.TYPE_NULL)
        binding.editText15.setRawInputType(InputType.TYPE_NULL)
        binding.editText17n.setRawInputType(InputType.TYPE_NULL)
        binding.editText14n.setRawInputType(InputType.TYPE_NULL)
        binding.editText16.setRawInputType(InputType.TYPE_NULL)
        binding.editText14.setRawInputType(InputType.TYPE_NULL)
        binding.editText18.setRawInputType(InputType.TYPE_NULL)
        binding.editText17.setRawInputType(InputType.TYPE_NULL)
        binding.editText18n.setRawInputType(InputType.TYPE_NULL)
        binding.editText16n.setRawInputType(InputType.TYPE_NULL)
        
    }

    fun openKeyboard() {

        binding.editText8.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText4.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText13.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText13n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText9.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText7.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText8n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText4n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editTextn.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText10n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText10.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText12n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText12.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText11n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText11.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText9n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText7n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText15n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText15.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText17n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText14n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText16.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText14.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText18.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText17.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText18n.setRawInputType(InputType.TYPE_CLASS_TEXT)
        binding.editText16n.setRawInputType(InputType.TYPE_CLASS_TEXT)

    }

    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .apply { setContentView(this.root) }

        MobileAds.initialize(this) {}

        val adView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val spinner04 = findViewById<Spinner>(R.id.spinner04)
        val spinnerWP = findViewById<Spinner>(R.id.spinnerWP)

        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.useWideViewPort = true
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.setInitialScale(1)
        binding.webView.loadUrl("https://www.google.com/")

        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?,
            ): Boolean {
                return false
            }
        }

        container = findViewById(R.id.allView)

        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        fun convertPxToSp(px: Float): Float {
            return px / this.resources.displayMetrics.density
        }

        count = convertPxToSp(binding.editText8.textSize)

        count2 = convertPxToSp(binding.editText8.textSize)

        var defaultTextSize = convertPxToSp(binding.editText8.textSize)

        fun menuList16() {

            defaultTextSize--

            binding.editText8.textSize = defaultTextSize
            binding.editText4.textSize = defaultTextSize
            binding.editText13.textSize = defaultTextSize
            binding.editText13n.textSize = defaultTextSize
            binding.editText9.textSize = defaultTextSize
            binding.editText7.textSize = defaultTextSize
            binding.editText8n.textSize = defaultTextSize
            binding.editText4n.textSize = defaultTextSize
            binding.editTextn.textSize = defaultTextSize
            binding.editText10n.textSize = defaultTextSize
            binding.editText10.textSize = defaultTextSize
            binding.editText.textSize = defaultTextSize
            binding.editText12n.textSize = defaultTextSize
            binding.editText12.textSize = defaultTextSize
            binding.editText11n.textSize = defaultTextSize
            binding.editText11.textSize = defaultTextSize
            binding.editText9n.textSize = defaultTextSize
            binding.editText7n.textSize = defaultTextSize
            binding.editText15n.textSize = defaultTextSize
            binding.editText15.textSize = defaultTextSize
            binding.editText17n.textSize = defaultTextSize
            binding.editText14n.textSize = defaultTextSize
            binding.editText16.textSize = defaultTextSize
            binding.editText14.textSize = defaultTextSize
            binding.editText18.textSize = defaultTextSize
            binding.editText17.textSize = defaultTextSize
            binding.editText18n.textSize = defaultTextSize
            binding.editText16n.textSize = defaultTextSize
            binding.textView.textSize = defaultTextSize
            binding.textView2.textSize = defaultTextSize
            binding.textView3.textSize = defaultTextSize
            binding.textView4.textSize = defaultTextSize
            binding.textView5.textSize = defaultTextSize
            binding.textView6.textSize = defaultTextSize
            binding.textView7.textSize = defaultTextSize
            binding.textView8.textSize = defaultTextSize
            binding.textView9.textSize = defaultTextSize
            binding.textView10.textSize = defaultTextSize
            binding.textView11.textSize = defaultTextSize
            binding.textView12.textSize = defaultTextSize
            binding.textView13.textSize = defaultTextSize
            binding.textView14.textSize = defaultTextSize

            return
        }

        fun menuList17() {

            defaultTextSize++

            binding.editText8.textSize = defaultTextSize
            binding.editText4.textSize = defaultTextSize
            binding.editText13.textSize = defaultTextSize
            binding.editText13n.textSize = defaultTextSize
            binding.editText9.textSize = defaultTextSize
            binding.editText7.textSize = defaultTextSize
            binding.editText8n.textSize = defaultTextSize
            binding.editText4n.textSize = defaultTextSize
            binding.editTextn.textSize = defaultTextSize
            binding.editText10n.textSize = defaultTextSize
            binding.editText10.textSize = defaultTextSize
            binding.editText.textSize = defaultTextSize
            binding.editText12n.textSize = defaultTextSize
            binding.editText12.textSize = defaultTextSize
            binding.editText11n.textSize = defaultTextSize
            binding.editText11.textSize = defaultTextSize
            binding.editText9n.textSize = defaultTextSize
            binding.editText7n.textSize = defaultTextSize
            binding.editText15n.textSize = defaultTextSize
            binding.editText15.textSize = defaultTextSize
            binding.editText17n.textSize = defaultTextSize
            binding.editText14n.textSize = defaultTextSize
            binding.editText16.textSize = defaultTextSize
            binding.editText14.textSize = defaultTextSize
            binding.editText18.textSize = defaultTextSize
            binding.editText17.textSize = defaultTextSize
            binding.editText18n.textSize = defaultTextSize
            binding.editText16n.textSize = defaultTextSize
            binding.textView.textSize = defaultTextSize
            binding.textView2.textSize = defaultTextSize
            binding.textView3.textSize = defaultTextSize
            binding.textView4.textSize = defaultTextSize
            binding.textView5.textSize = defaultTextSize
            binding.textView6.textSize = defaultTextSize
            binding.textView7.textSize = defaultTextSize
            binding.textView8.textSize = defaultTextSize
            binding.textView9.textSize = defaultTextSize
            binding.textView10.textSize = defaultTextSize
            binding.textView11.textSize = defaultTextSize
            binding.textView12.textSize = defaultTextSize
            binding.textView13.textSize = defaultTextSize
            binding.textView14.textSize = defaultTextSize

            return
        }

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
                    Model(R.drawable.dinner_b, "主菜、ご飯類、麺類　"),
                    Model(R.drawable.carrot_b, "副菜、サラダ　"),
                    Model(R.drawable.soup_b, "味噌汁、スープ　"),
                    Model(R.drawable.apple_b, "果物、デザート　"),
                    Model(R.drawable.shuffle_b, "おまかせ　"),
                    Model(R.drawable.search_b, "詳細検索　")
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
                    Model(R.drawable.apple_b, "Fruits, Desserts  "),
                    Model(R.drawable.shuffle_b, "Shuffle order　"),
                    Model(R.drawable.search_b, "Find details　")
                )
            )
        }


        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        mRealm = Realm.getInstance(realmConfig)

            if (locale == Locale.JAPAN) {
                supportActionBar?.title = "メニュー表"
            } else {
                supportActionBar?.title = "Menu list"
            }

        aCuisines = arrayListOf(
            Cuisine("アスパラの肉巻き"),
            Cuisine("エビフライ"),
            Cuisine("オムライス"),
            Cuisine("オムライス"),
            Cuisine("お好み焼き"),
            Cuisine("カツオのタタキ"),
            Cuisine("カレイの煮付け"),
            Cuisine("カレー"),
            Cuisine("クリームシチュー"),
            Cuisine("サイコロステーキ"),
            Cuisine("サバ味噌煮"),
            Cuisine("サンマの塩焼き"),
            Cuisine("すき焼き"),
            Cuisine("チキンカツ"),
            Cuisine("チキンステーキ"),
            Cuisine("チキンナゲット"),
            Cuisine("チャーハン"),
            Cuisine("とんかつ"),
            Cuisine("ハムカツ"),
            Cuisine("ハンバーグ"),
            Cuisine("ビーフシチュー"),
            Cuisine("ビーフステーキ"),
            Cuisine("ピーマンのチーズ肉詰め焼き"),
            Cuisine("ピーマンの肉詰め"),
            Cuisine("ひき肉とじゃがいものキムチ炒め"),
            Cuisine("ブリの照り焼き"),
            Cuisine("ブリ大根"),
            Cuisine("マカロニグラタン"),
            Cuisine("ミートグラタン"),
            Cuisine("ミートソースパスタ"),
            Cuisine("ミートローフ"),
            Cuisine("メンチカツ"),
            Cuisine("ラーメン"),
            Cuisine("ロールキャベツ"),
            Cuisine("回鍋肉"),
            Cuisine("牛丼"),
            Cuisine("鶏ひき肉とキャベツの卵とじ"),
            Cuisine("鶏ひき肉の炒り豆腐"),
            Cuisine("鶏肉と野菜のクリーム煮"),
            Cuisine("鶏肉のトマト煮"),
            Cuisine("鶏肉のニンニクソテー" ),
            Cuisine("鶏肉の香味レンジ蒸し"),
            Cuisine("鶏肉の照り焼き"),
            Cuisine("焼きそば"),
            Cuisine("焼鮭"),
            Cuisine("焼売"),
            Cuisine("酢豚"),
            Cuisine("青椒肉絲"),
            Cuisine("大根のそぼろ煮"),
            Cuisine("唐揚げ"),
            Cuisine("豚キムチ"),
            Cuisine("豚ひき肉と大根の甘辛煮"),
            Cuisine("豚角煮"),
            Cuisine("豚生姜焼き"),
            Cuisine("豚肉とキャベツのピリ辛みそ炒め"),
            Cuisine("豚肉とほうれん草、卵の炒め物"),
            Cuisine("豚肉と豆腐の磯辺焼き"),
            Cuisine("豚肉のネギ塩焼き"),
            Cuisine("鍋焼きうどん"),
            Cuisine("肉じゃが"),
            Cuisine("肉団子のあんかけ"),
            Cuisine("肉野菜炒め"),
            Cuisine("白菜の旨煮"),
            Cuisine("八宝菜"),
            Cuisine("棒棒鶏"),
            Cuisine("麻婆春雨"),
            Cuisine("麻婆豆腐"),
            Cuisine("餃子")
        )

        bCuisines = arrayListOf(
            Cuisine("アスパラガスと人参のサラダ"),
            Cuisine("インゲンのごま和え"),
            Cuisine("エビとアボカドのサラダ"),
            Cuisine("オクラの卵炒め"),
            Cuisine("オニオンリング"),
            Cuisine("カブと厚揚げのめんつゆ炒め"),
            Cuisine("かぼちゃの煮付け"),
            Cuisine("きのこのマヨ焼き"),
            Cuisine("キャベツの塩昆布和え"),
            Cuisine("きゅうりとセロリのピクルス"),
            Cuisine("きゅうりとちくわのサラダ"),
            Cuisine("きんぴらごぼう"),
            Cuisine("コールスロー"),
            Cuisine("ごぼうサラダ"),
            Cuisine("ごぼうのつくね揚げ"),
            Cuisine("サヤインゲンのツナサラダ"),
            Cuisine("シーザーサラダ"),
            Cuisine("スティックサラダ"),
            Cuisine("ツナレタスサラダ"),
            Cuisine("トマトサラダ"),
            Cuisine("ナスとピーマンの味噌炒め"),
            Cuisine("パスタサラダ"),
            Cuisine("ピーマンともやしの塩炒め"),
            Cuisine("ピーマンのナムル"),
            Cuisine("ブロッコリーとツナのチーズ蒸し"),
            Cuisine("ブロッコリーのガーリックパン粉がけ"),
            Cuisine("ほうれん草とエリンギのニンニク炒め"),
            Cuisine("ほうれん草とツナのバターしょうゆ炒め"),
            Cuisine("ほうれん草とベーコンのソテー"),
            Cuisine("ほうれん草のおひたし"),
            Cuisine("ポテトサラダ"),
            Cuisine("マカロニサラダ"),
            Cuisine("もやしときゅうりのごま和え"),
            Cuisine("レタスと卵の炒め物"),
            Cuisine("小松菜と厚揚げの煮びたし"),
            Cuisine("焼きナス"),
            Cuisine("水菜と油揚げの煮浸し"),
            Cuisine("大根サラダ"),
            Cuisine("大根の中華風そぼろ煮"),
            Cuisine("筑前煮"),
            Cuisine("豆腐とじゃこのサラダ"),
            Cuisine("豚バラもやし炒め"),
            Cuisine("野菜炒め")
        )

        cCuisines = arrayListOf(
            Cuisine("あさりの味噌汁"),
            Cuisine("アスパラとベーコンの味噌汁"),
            Cuisine("えのきのサンラータン"),
            Cuisine("オニオングラタンスープ"),
            Cuisine("カブと豆腐のとろみ汁"),
            Cuisine("カリフラワーの味噌汁"),
            Cuisine("カルビクッパ"),
            Cuisine("キムチの味噌汁"),
            Cuisine("キャベツとベーコンの豆乳味噌汁"),
            Cuisine("キャベツと玉子のスープ"),
            Cuisine("クラムチャウダー"),
            Cuisine("けんちん汁"),
            Cuisine("コーンスープ"),
            Cuisine("コンソメスープ"),
            Cuisine("しじみ汁"),
            Cuisine("じゃがいもとクレソンの味噌汁"),
            Cuisine("じゃがいもと玉ねぎの味噌汁"),
            Cuisine("チンゲンサイの中華スープ"),
            Cuisine("とろろ昆布汁"),
            Cuisine("ナスとエノキの味噌汁"),
            Cuisine("ナスとミョウガのごま味噌汁"),
            Cuisine("なめこと豆腐の味噌汁"),
            Cuisine("ニラと玉子の味噌汁"),
            Cuisine("ニラ玉の味噌汁"),
            Cuisine("ピーマンの味噌汁"),
            Cuisine("ブロッコリーとじゃがいものスープ"),
            Cuisine("ポトフ"),
            Cuisine("ボルシチ"),
            Cuisine("ミネストローネ"),
            Cuisine("もやしの中華スープ"),
            Cuisine("レタスの味噌汁"),
            Cuisine("レンコン団子汁"),
            Cuisine("わかめスープ"),
            Cuisine("玉ねぎとニンニクのスープ"),
            Cuisine("春雨スープ"),
            Cuisine("大根と油揚げの味噌汁"),
            Cuisine("大豆とトマトのスープ"),
            Cuisine("沢煮椀"),
            Cuisine("椎茸とほうれん草の味噌汁"),
            Cuisine("豆腐とわかめの味噌汁"),
            Cuisine("豚しゃぶと梅干しのスープ"),
            Cuisine("豚汁"),
            Cuisine("白菜と小松菜の味噌汁")
        )

        dCuisines = arrayListOf(
            Cuisine("アイス"),
            Cuisine("いちご"),
            Cuisine("いちごの錦玉"),
            Cuisine("オレンジ"),
            Cuisine("カフェオレゼリー"),
            Cuisine("キウイフルーツ"),
            Cuisine("コーヒーゼリー"),
            Cuisine("チョコバナナパフェ"),
            Cuisine("チョコムース"),
            Cuisine("トウファ"),
            Cuisine("パウンドケーキ"),
            Cuisine("バナナ"),
            Cuisine("バナナスムージー"),
            Cuisine("ババロア"),
            Cuisine("パンケーキ"),
            Cuisine("パンナコッタ"),
            Cuisine("ブドウ"),
            Cuisine("プリン"),
            Cuisine("フルーチェ"),
            Cuisine("ホットケーキ"),
            Cuisine("マフィン"),
            Cuisine("みかん"),
            Cuisine("みかんゼリー"),
            Cuisine("みかんのシャーベット"),
            Cuisine("メロン"),
            Cuisine("ヨーグルト"),
            Cuisine("ヨーグルトクレープ"),
            Cuisine("りんご"),
            Cuisine("りんごのグラッセ"),
            Cuisine("杏仁豆腐"),
            Cuisine("桃"),
            Cuisine("桃のコンポート"),
            Cuisine("豆乳ドーナツ"),
            Cuisine("抹茶ティラミス"),
            Cuisine("梨"),
            Cuisine("餃子の皮クレープ")
        )

        aCustomAdapter = CustomAdapter(this, aCuisines, this)
        bCustomAdapter = CustomAdapter(this, bCuisines, this)
        cCustomAdapter = CustomAdapter(this, cCuisines, this)
        dCustomAdapter = CustomAdapter(this, dCuisines, this)


        binding.listView.adapter = aCustomAdapter
        aCustomAdapter.notifyDataSetChanged()

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
                "焼鮭",
                "肉団子のあんかけ",
                "焼売",
                "ピーマンのチーズ肉詰め焼き",
                "チキンナゲット",
                "豚ひき肉と大根の甘辛煮",
                "麻婆春雨",
                "ひき肉とじゃがいものキムチ炒め",
                "ミートローフ",
                "大根のそぼろ煮",
                "鶏ひき肉とキャベツの卵とじ",
                "鶏ひき肉の炒り豆腐",
                "豚肉のネギ塩焼き",
                "豚肉とほうれん草、卵の炒め物",
                "豚キムチ",
                "豚肉と豆腐の磯部焼き",
                "豚肉とキャベツのピリ辛みそ炒め",
                "酢豚",
                "豚角煮",
                "鶏肉の照り焼き",
                "鶏肉のトマト煮",
                "鶏肉の香味レンジ蒸し",
                "鶏肉と野菜のクリーム煮",
                "棒棒鶏",
                "チキンカツ",
                "鶏肉のニンニクソテー"
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
                "Roast Halibut with Roast Baby Tomatoes",
                "Grilled Mahi Mahi with Mango Chutney",
                "Grilled Chicken Shawarma",
                "ASIAN QUINOA PORK BURGERS",
                "Ham and Sausage Hashbrown Egg Bake",
                "5 INGREDIENT LEMON CHICKEN WITH ASPARAGUS",
                "BACON, GRAPE & GOAT CHEESE PIZZA",
                "Spiced Rubbed Salmon",
                "Garlic Shrimp",
                "Eggs Benedict",
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

        val cuisine2 = if (locale == Locale.JAPAN) {
            mutableSetOf(

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
                "キャベツの塩昆布和え",
                "野菜炒め",
                "ほうれん草とエリンギのニンニク炒め",
                "ほうれん草とベーコンのソテー",
                "ほうれん草とツナのバターしょうゆ炒め",
                "小松菜と厚揚げの煮びたし",
                "ナスとピーマンの味噌炒め",
                "焼きナス",
                "ピーマンともやしの塩炒め",
                "ピーマンのナムル",
                "アスパラガスと人参のサラダ",
                "オクラの卵炒め",
                "ブロッコリーとツナのチーズ蒸し",
                "ブロッコリーのガーリックパン粉がけ",
                "サヤインゲンのツナサラダ",
                "レタスと卵の炒め物",
                "きゅうりとセロリのピクルス",
                "水菜と油揚げの煮浸し",
                "豚バラもやし炒め",
                "もやしときゅうりのごま和え",
                "大根の中華風そぼろ煮",
                "オニオンリング",
                "カブと厚揚げのめんつゆ炒め",
                "ごぼうのつくね揚げ",
                "きのこのマヨ焼き"
            )
        } else {
            mutableSetOf(
                "Mason Jar Salad",
                "Tomato, Cucumber, Avocado Salad",
                "Roasted Eggplant with Tomato and Feta",
                "Israeli Salad",
                "TOMATO, BASIL + MOZZARELLA CAPRESE SALAD",
                "Herbed Quinoa Garden Veggie Salad",
                "CHOPPED GREEN GODDESS SALAD",
                "SMOKED SALMON AND ROASTED BEETS SALAD",
                "KALE SALAD WITH MEYER LEMON VINAIGRETTE",
                "Tofu Amaranth Salad",
                "Potato Caesar Salad",
                "Avocado Feta Salsa",
                "Mediterranean Tortellini Salad with Red Wine Vinaigrette"
            )
        }

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

            val cuisine3 =if (locale == Locale.JAPAN) {
                mutableSetOf(

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
                    "春雨スープ",
                    "ナスとミョウガのごま味噌汁",
                    "じゃがいもとクレソンの味噌汁",
                    "ニラ玉の味噌汁",
                    "キャベツとベーコンの豆乳味噌汁",
                    "カリフラワーの味噌汁",
                    "レンコン団子汁",
                    "とろろ昆布汁",
                    "沢煮椀",
                    "チンゲンサイの中華スープ",
                    "えのきのサンラータン",
                    "もやしの中華スープ",
                    "カブと豆腐のとろみ汁",
                    "玉ねぎとニンニクのスープ",
                    "大豆とトマトのスープ",
                    "コーンスープ",
                    "豚しゃぶと梅干しのスープ",
                    "ブロッコリーとじゃがいものスープ",
                    "キムチの味噌汁"
                )
            } else {
                mutableSetOf(

                    "Pesto Hominy Minestrone Soup",
                    "CREAMY POTATO KALE SOUP",
                    "Roast Pumpkin & Coconut Soup",
                    "Creamy Roasted Tomato & Basil Soup",
                    "Thai-Spiced Pumpkin Soup",
                    "Cauliflower Soup",
                    "Carrot Soup",
                    "French Onion Soup"
                )
            }

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

            val cuisine4 = if (locale == Locale.JAPAN) {
                mutableSetOf(

                    "りんご",
                    "バナナ",
                    "ヨーグルト",
                    "フルーチェ",
                    "みかんのシャーベット",
                    "アイス",
                    "キウイフルーツ",
                    "みかんゼリー",
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
                    "チョコムース",
                    "パウンドケーキ",
                    "マフィン",
                    "プリン",
                    "豆乳ドーナツ",
                    "ヨーグルトクレープ",
                    "ホットケーキ",
                    "パンケーキ",
                    "バナナスムージー",
                    "コーヒーゼリー",
                    "トウファ",
                    "いちごの錦玉",
                    "カフェオレゼリー",
                    "桃のコンポート",
                    "チョコバナナパフェ",
                    "抹茶ティラミス",
                    "餃子の皮クレープ"
                )
            } else {
                mutableSetOf(
                    "The Moistest Chocolate Mug Cake",
                    "Strawberry Parfait",
                    "Crema Catalana",
                    "Honey and Olive Oil Zucchini Muffins",
                    "Peanut Butter Banana Ice Cream",
                    "Quinoa and Almond Flour Cake",
                    "Apple Pannekoeken",
                    "CINNAMON WHOLE GRAIN POWER PANCAKES"
                )
            }

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


            binding.editText8.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                        }
                    }
                    pasteFlag == 2 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText8.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText4.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText4.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText10.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText10.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText11.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText11.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText12.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText12.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText13.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText13.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText9.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText9.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText7.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText7.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText14.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText14.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText15.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText15.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText16.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText16.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText17.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText17.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText18.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText18.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText8n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText8n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText4n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText4n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editTextn.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editTextn.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText10n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText10n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText11n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText11n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText12n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText12n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText13n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText13n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText9n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText9n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText7n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText7n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText14n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText14n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText15n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText15n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText16n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText16n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText17n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText17n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText18n.setOnClickListener {
                when {
                    pasteFlag == 1 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText18n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }

            binding.editText8.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText8.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText8.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText4.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText4.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText4.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText10.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText10.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText10.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText11.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText11.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText11.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText12.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText12.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText12.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText13.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText13.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText13.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText9.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText9.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText9.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText7.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText7.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText7.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText14.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText14.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText14.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText15.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText15.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText15.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText16.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText16.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText16.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText17.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText17.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText17.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText18.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText18.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText18.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText8n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText8n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText8n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText4n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText4n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText4n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editTextn.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editTextn.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editTextn.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText10n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText10n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText10n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText11n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText11n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText11n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText12n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText12n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText12n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText13n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText13n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText13n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText9n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText9n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText9n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText7n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText7n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText7n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText14n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText14n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText14n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText15n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText15n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText15n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText16n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText16n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText16n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText17n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText17n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText17n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }
            binding.editText18n.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 2 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 3 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 4 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 5 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 6 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText18n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                    !hasFocus -> {
                        binding.editText18n.textSize = defaultTextSize
                        hideKeyboard()
                    }
                }
            }

            binding.textView.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView2.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView2.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView3.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView3.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView4.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView4.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView5.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView5.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView6.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView6.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView7.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView7.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView8.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView8.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView9.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView9.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView10.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView10.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView11.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView11.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView12.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView12.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView13.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView13.textSize = defaultTextSize
                    hideKeyboard()
                }
            }
            binding.textView14.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                if (!hasFocus) {
                    binding.textView14.textSize = defaultTextSize
                    hideKeyboard()
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
                            menuList16()
                            menuList17()
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
                            openKeyboard()
                            Toast.makeText(applicationContext, (R.string.Manual_input), Toast.LENGTH_SHORT).show()
                            pasteFlag = 0
                        }
                        1 -> { menuSwitch = 1
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aCustomAdapter
                            aCustomAdapter.notifyDataSetChanged()
                            if (locale == Locale.JAPAN) {
                                supportActionBar?.title = "主菜、ご飯類、麺類"
                            } else {
                                supportActionBar?.title = "Main dish"
                            }
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Main_dish), Toast.LENGTH_SHORT).show()
                            pasteFlag = 1
                        }
                        2 -> { menuSwitch = 2
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = bCustomAdapter
                            bCustomAdapter.notifyDataSetChanged()
                            if (locale == Locale.JAPAN) {
                                supportActionBar?.title = "副菜、サラダ"
                            } else {
                                supportActionBar?.title = "side dish Salads"
                            }
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Salads), Toast.LENGTH_SHORT).show()
                            pasteFlag = 2
                        }
                        3 -> { menuSwitch = 3
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = cCustomAdapter
                            cCustomAdapter.notifyDataSetChanged()
                            if (locale == Locale.JAPAN) {
                                supportActionBar?.title = "味噌汁、スープ"
                            } else {
                                supportActionBar?.title = "Soup"
                            }
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Soup), Toast.LENGTH_SHORT).show()
                            pasteFlag = 3
                        }
                        4 -> { menuSwitch = 4
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = dCustomAdapter
                            dCustomAdapter.notifyDataSetChanged()
                            if (locale == Locale.JAPAN) {
                                supportActionBar?.title = "果物、デザート"
                            } else {
                                supportActionBar?.title = "Fruits, Desserts"
                            }
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Fruits_Desserts), Toast.LENGTH_SHORT).show()
                            pasteFlag = 4
                        }
                        5 -> { menuSwitch = 5
                            invalidateOptionsMenu()
                            val shuffled1 = cuisine1.shuffled()
                            val shuffled2 = cuisine2.shuffled()
                            val shuffled3 = cuisine3.shuffled()
                            val shuffled4 = cuisine4.shuffled()
                            binding.editText8n.setText(shuffled1[0],TextView.BufferType.NORMAL)
                            binding.editText4n.setText(shuffled1[1],TextView.BufferType.NORMAL)
                            binding.editText13n.setText(shuffled1[2],TextView.BufferType.NORMAL)
                            binding.editTextn.setText(shuffled1[3],TextView.BufferType.NORMAL)
                            binding.editText11n.setText(shuffled1[4],TextView.BufferType.NORMAL)
                            binding.editText10n.setText(shuffled1[5],TextView.BufferType.NORMAL)
                            binding.editText12n.setText(shuffled1[6],TextView.BufferType.NORMAL)
                            binding.editText9n.setText(shuffled2[0],TextView.BufferType.NORMAL)
                            binding.editText7n.setText(shuffled2[1],TextView.BufferType.NORMAL)
                            binding.editText15n.setText(shuffled2[2],TextView.BufferType.NORMAL)
                            binding.editText16n.setText(shuffled2[3],TextView.BufferType.NORMAL)
                            binding.editText18n.setText(shuffled2[4],TextView.BufferType.NORMAL)
                            binding.editText17n.setText(shuffled2[5],TextView.BufferType.NORMAL)
                            binding.editText14n.setText(shuffled2[6],TextView.BufferType.NORMAL)
                            binding.editText8.setText(shuffled3[0],TextView.BufferType.NORMAL)
                            binding.editText4.setText(shuffled3[1],TextView.BufferType.NORMAL)
                            binding.editText13.setText(shuffled3[2],TextView.BufferType.NORMAL)
                            binding.editText.setText(shuffled3[3],TextView.BufferType.NORMAL)
                            binding.editText11.setText(shuffled3[4],TextView.BufferType.NORMAL)
                            binding.editText10.setText(shuffled3[5],TextView.BufferType.NORMAL)
                            binding.editText12.setText(shuffled3[6],TextView.BufferType.NORMAL)
                            binding.editText9.setText(shuffled4[0],TextView.BufferType.NORMAL)
                            binding.editText7.setText(shuffled4[1],TextView.BufferType.NORMAL)
                            binding.editText15.setText(shuffled4[2],TextView.BufferType.NORMAL)
                            binding.editText16.setText(shuffled4[3],TextView.BufferType.NORMAL)
                            binding.editText18.setText(shuffled4[4],TextView.BufferType.NORMAL)
                            binding.editText17.setText(shuffled4[5],TextView.BufferType.NORMAL)
                            binding.editText14.setText(shuffled4[6],TextView.BufferType.NORMAL)
                            menuList16()
                            menuList17()
                            if (locale == Locale.JAPAN) {
                                supportActionBar?.title = "おまかせ"
                            } else {
                                supportActionBar?.title = "Shuffle order"
                            }
                            openKeyboard()
                            pasteFlag = 5
                        }
                        6 -> { menuSwitch = 6
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            if (locale == Locale.JAPAN) {
                                supportActionBar?.title = "詳細検索"
                            } else {
                                supportActionBar?.title = "Find details"
                            }
                            hideKeyboard()
                            openKeyboard()
                            Toast.makeText(applicationContext, (R.string.search), Toast.LENGTH_LONG).show()
                            pasteFlag = 6
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

    override fun clicked(cuisine: Cuisine) {
        binding.webView.loadUrl("https://www.google.com/search?q=${cuisine.name}")
        hideKeyboard()
        binding.webView.visibility = View.VISIBLE
        binding.listView.visibility = View.INVISIBLE
        if (locale == Locale.JAPAN) {
            supportActionBar?.title = "詳細検索"
        } else {
            supportActionBar?.title = "Find details"
        }
    }

    override fun clicked2(cuisine: Cuisine) {
        when {
            binding.editText8.hasFocus() -> { binding.editText8.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText8.clearFocus()
                binding.editText8.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText4.hasFocus() -> { binding.editText4.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText4.clearFocus()
                binding.editText4.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText.hasFocus() -> { binding.editText.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText.clearFocus()
                binding.editText.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText10.hasFocus() -> { binding.editText10.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText10.clearFocus()
                binding.editText10.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText11.hasFocus() -> { binding.editText11.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText11.clearFocus()
                binding.editText11.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText12.hasFocus() -> { binding.editText12.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText12.clearFocus()
                binding.editText12.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText13.hasFocus() -> { binding.editText13.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText13.clearFocus()
                binding.editText13.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText9.hasFocus() -> { binding.editText9.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText9.clearFocus()
                binding.editText9.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText7.hasFocus() -> { binding.editText7.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText7.clearFocus()
                binding.editText7.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText14.hasFocus() -> { binding.editText14.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText14.clearFocus()
                binding.editText14.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText15.hasFocus() -> { binding.editText15.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText15.clearFocus()
                binding.editText15.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText16.hasFocus() -> { binding.editText16.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText16.clearFocus()
                binding.editText16.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText17.hasFocus() -> { binding.editText17.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText17.clearFocus()
                binding.editText17.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText18.hasFocus() -> { binding.editText18.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText18.clearFocus()
                binding.editText18.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText8n.hasFocus() -> { binding.editText8n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText8n.clearFocus()
                binding.editText8n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText4n.hasFocus() -> { binding.editText4n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText4n.clearFocus()
                binding.editText4n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editTextn.hasFocus() -> { binding.editTextn.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editTextn.clearFocus()
                binding.editTextn.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText10n.hasFocus() -> { binding.editText10n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText10n.clearFocus()
                binding.editText10n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText11n.hasFocus() -> { binding.editText11n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText11n.clearFocus()
                binding.editText11n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText12n.hasFocus() -> { binding.editText12n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText12n.clearFocus()
                binding.editText12n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText13n.hasFocus() -> { binding.editText13n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText13n.clearFocus()
                binding.editText13n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText9n.hasFocus() -> { binding.editText9n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText9n.clearFocus()
                binding.editText9n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText7n.hasFocus() -> { binding.editText7n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText7n.clearFocus()
                binding.editText7n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText14n.hasFocus() -> { binding.editText14n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText14n.clearFocus()
                binding.editText14n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText15n.hasFocus() -> { binding.editText15n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText15n.clearFocus()
                binding.editText15n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText16n.hasFocus() -> { binding.editText16n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText16n.clearFocus()
                binding.editText16n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText17n.hasFocus() -> { binding.editText17n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText17n.clearFocus()
                binding.editText17n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
            binding.editText18n.hasFocus() -> { binding.editText18n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText18n.clearFocus()
                binding.editText18n.textSize = count2
                binding.listView.visibility = View.INVISIBLE }
        }
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
                    Toast.makeText(applicationContext, (R.string.back), Toast.LENGTH_LONG).show()
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
        when {
            binding.imageView.isVisible -> {
                binding.imageView.visibility = View.INVISIBLE
                binding.adView.visibility = View.VISIBLE
            }
            binding.listView.isVisible -> {
                binding.listView.visibility = View.INVISIBLE
            }
            binding.webView.isVisible -> {
                binding.webView.loadUrl("https://www.google.com/")
                binding.webView.visibility = View.INVISIBLE
            }
            else -> {
                AlertDialog.Builder(this)
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
            5 -> {
                menuLamp.setIcon(R.drawable.shuffle_w)
            }
            6 -> {
                menuLamp.setIcon(R.drawable.search_w)
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
                when {
                    binding.listView.isVisible -> {
                        binding.listView.visibility = View.INVISIBLE
                    }
                    binding.webView.isVisible -> {
                        binding.webView.loadUrl("https://www.google.com/")
                        binding.webView.visibility = View.INVISIBLE
                    }
                    else -> {
                        hideKeyboard()
                        binding.adView.visibility = View.VISIBLE
                        binding.imageView.visibility = View.INVISIBLE
                        spinnerWP.performClick()
                    }
                }
                return true
            }

            R.id.MenuList2 -> {
                if (binding.listView.isVisible) {
                    binding.listView.visibility = View.INVISIBLE
                }
                binding.imageView.visibility = View.INVISIBLE
                binding.adView.visibility = View.GONE
                binding.textView14.requestFocus()
                binding.textView14.clearFocus()
                handler.postDelayed( { getBitmapFromView(binding.allView) }, 50)
                handler.postDelayed( { binding.adView.visibility = View.VISIBLE }, 50)
                return true
            }

            R.id.MenuList3a -> {
                when {
                    binding.listView.isVisible -> {
                        binding.listView.visibility = View.INVISIBLE
                    }
                    binding.webView.isVisible -> {
                        binding.webView.loadUrl("https://www.google.com/")
                        binding.webView.visibility = View.INVISIBLE
                    }
                    else -> {
                        hideKeyboard()
                        binding.adView.visibility = View.VISIBLE
                        binding.imageView.visibility = View.INVISIBLE
                        spinner04.performClick()
                    }
                }
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}