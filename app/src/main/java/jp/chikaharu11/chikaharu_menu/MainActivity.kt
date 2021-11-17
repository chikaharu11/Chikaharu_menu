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
import android.text.InputType
import android.util.DisplayMetrics
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
import com.google.android.gms.ads.*
import com.jakewharton.processphoenix.ProcessPhoenix
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import jp.chikaharu11.chikaharu_menu.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), CustomAdapterListener {

    private lateinit var adViewContainer: FrameLayout
    private lateinit var admobmAdView: AdView

    private lateinit var container: ConstraintLayout

    private lateinit var inputMethodManager: InputMethodManager

    private lateinit var binding: ActivityMainBinding

    private lateinit var mRealm: Realm

    private lateinit var soundPool: SoundPool

    private lateinit var aaaCustomAdapter: CustomAdapter
    private lateinit var aabCustomAdapter: CustomAdapter
    private lateinit var aacCustomAdapter: CustomAdapter
    private lateinit var aadCustomAdapter: CustomAdapter
    private lateinit var aCustomAdapter: CustomAdapter
    private lateinit var bCustomAdapter: CustomAdapter
    private lateinit var cCustomAdapter: CustomAdapter
    private lateinit var dCustomAdapter: CustomAdapter
    private lateinit var eCustomAdapter: CustomAdapter
    private lateinit var fCustomAdapter: CustomAdapter
    private lateinit var gCustomAdapter: CustomAdapter
    private lateinit var hCustomAdapter: CustomAdapter
    private lateinit var iCustomAdapter: CustomAdapter
    private lateinit var jCustomAdapter: CustomAdapter
    private lateinit var kCustomAdapter: CustomAdapter
    private lateinit var lCustomAdapter: CustomAdapter
    private lateinit var mCustomAdapter: CustomAdapter
    private lateinit var nCustomAdapter: CustomAdapter
    private lateinit var oCustomAdapter: CustomAdapter
    private lateinit var pCustomAdapter: CustomAdapter
    private lateinit var qCustomAdapter: CustomAdapter
    private lateinit var rCustomAdapter: CustomAdapter
    private lateinit var sCustomAdapter: CustomAdapter
    private lateinit var tCustomAdapter: CustomAdapter
    private lateinit var uCustomAdapter: CustomAdapter
    private lateinit var vCustomAdapter: CustomAdapter
    private lateinit var wCustomAdapter: CustomAdapter
    private lateinit var xCustomAdapter: CustomAdapter
    private lateinit var yCustomAdapter: CustomAdapter
    private lateinit var zCustomAdapter: CustomAdapter
    private lateinit var aaCustomAdapter: CustomAdapter
    private lateinit var abCustomAdapter: CustomAdapter
    private lateinit var acCustomAdapter: CustomAdapter
    private lateinit var adCustomAdapter: CustomAdapter
    private lateinit var aeCustomAdapter: CustomAdapter
    private lateinit var afCustomAdapter: CustomAdapter
    private lateinit var agCustomAdapter: CustomAdapter
    private lateinit var ahCustomAdapter: CustomAdapter
    private lateinit var aiCustomAdapter: CustomAdapter
    private lateinit var ajCustomAdapter: CustomAdapter
    private lateinit var akCustomAdapter: CustomAdapter
    private lateinit var alCustomAdapter: CustomAdapter
    private lateinit var amCustomAdapter: CustomAdapter
    private lateinit var anCustomAdapter: CustomAdapter
    private lateinit var aoCustomAdapter: CustomAdapter
    private lateinit var apCustomAdapter: CustomAdapter
    private lateinit var aqCustomAdapter: CustomAdapter
    private lateinit var arCustomAdapter: CustomAdapter
    private lateinit var asCustomAdapter: CustomAdapter

    private lateinit var aaaCuisines: MutableList<Cuisine>
    private lateinit var aabCuisines: MutableList<Cuisine>
    private lateinit var aacCuisines: MutableList<Cuisine>
    private lateinit var aadCuisines: MutableList<Cuisine>
    private lateinit var aCuisines: MutableList<Cuisine>
    private lateinit var bCuisines: MutableList<Cuisine>
    private lateinit var cCuisines: MutableList<Cuisine>
    private lateinit var dCuisines: MutableList<Cuisine>
    private lateinit var eCuisines: MutableList<Cuisine>
    private lateinit var fCuisines: MutableList<Cuisine>
    private lateinit var gCuisines: MutableList<Cuisine>
    private lateinit var hCuisines: MutableList<Cuisine>
    private lateinit var iCuisines: MutableList<Cuisine>
    private lateinit var jCuisines: MutableList<Cuisine>
    private lateinit var kCuisines: MutableList<Cuisine>
    private lateinit var lCuisines: MutableList<Cuisine>
    private lateinit var mCuisines: MutableList<Cuisine>
    private lateinit var nCuisines: MutableList<Cuisine>
    private lateinit var oCuisines: MutableList<Cuisine>
    private lateinit var pCuisines: MutableList<Cuisine>
    private lateinit var qCuisines: MutableList<Cuisine>
    private lateinit var rCuisines: MutableList<Cuisine>
    private lateinit var sCuisines: MutableList<Cuisine>
    private lateinit var tCuisines: MutableList<Cuisine>
    private lateinit var uCuisines: MutableList<Cuisine>
    private lateinit var vCuisines: MutableList<Cuisine>
    private lateinit var wCuisines: MutableList<Cuisine>
    private lateinit var xCuisines: MutableList<Cuisine>
    private lateinit var yCuisines: MutableList<Cuisine>
    private lateinit var zCuisines: MutableList<Cuisine>
    private lateinit var aaCuisines: MutableList<Cuisine>
    private lateinit var abCuisines: MutableList<Cuisine>
    private lateinit var acCuisines: MutableList<Cuisine>
    private lateinit var adCuisines: MutableList<Cuisine>
    private lateinit var aeCuisines: MutableList<Cuisine>
    private lateinit var afCuisines: MutableList<Cuisine>
    private lateinit var agCuisines: MutableList<Cuisine>
    private lateinit var ahCuisines: MutableList<Cuisine>
    private lateinit var aiCuisines: MutableList<Cuisine>
    private lateinit var ajCuisines: MutableList<Cuisine>
    private lateinit var akCuisines: MutableList<Cuisine>
    private lateinit var alCuisines: MutableList<Cuisine>
    private lateinit var amCuisines: MutableList<Cuisine>
    private lateinit var anCuisines: MutableList<Cuisine>
    private lateinit var aoCuisines: MutableList<Cuisine>
    private lateinit var apCuisines: MutableList<Cuisine>
    private lateinit var aqCuisines: MutableList<Cuisine>
    private lateinit var arCuisines: MutableList<Cuisine>
    private lateinit var asCuisines: MutableList<Cuisine>


    private val handler = Handler()

    private var sound1 = 0

    private var count = 16.toFloat()

    private var count2 = 0.toFloat()

    private var lineFlag = 0

    private var pasteFlag = 0

    private var pasteFlagRange = 3..100

    private var menuSwitch = 0

    private val locale: Locale = Locale.getDefault()

    companion object {
        private const val READ_REQUEST_CODE: Int = 42
        private const val READ_REQUEST_CODE2: Int = 43
        private const val READ_REQUEST_CODE3: Int = 44
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

    private fun selectMenu3() {
        binding.imageView.setImageDrawable(null)
        val saf = Uri.parse("content://com.android.externalstorage.documents/document/primary%3AAndroid%2Fdata%2Fjp.chikaharu11.chikaharu_menu%2Ffiles%2FDCIM")
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(DocumentsContract.EXTRA_INITIAL_URI, saf)
            type = "image/*"
        }
        startActivityForResult(intent, READ_REQUEST_CODE3)
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

        initAdMob()
        loadAdMob()

        val optionSpinner = findViewById<Spinner>(R.id.spinner04)
        val menuSpinner = findViewById<Spinner>(R.id.spinnerWP)

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

        if (locale != Locale.JAPAN) {
            supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#fd2003")))
        }

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
                    Model(R.drawable.outline_description_black_48dp, "献立表を読み込む　"),
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
                    Model(R.drawable.outline_description_black_48dp, "Load the menu list　"),
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
                    Model(R.drawable.shuffle_b, "おまかせ　"),
                    Model(R.drawable.search_b, "詳細検索　"),
                    Model(R.drawable.dinner_b, "主菜、ご飯類、麺類　"),
                    Model(R.drawable.salad, "副菜、サラダ　"),
                    Model(R.drawable.soup_b, "味噌汁、スープ　"),
                    Model(R.drawable.dessert, "果物、デザート　"),
                    Model(R.drawable.beef, "牛肉　"),
                    Model(R.drawable.pork, "豚肉　"),
                    Model(R.drawable.chiken, "鶏肉　"),
                    Model(R.drawable.ingen, "いんげん　"),
                    Model(R.drawable.okura, "オクラ　"),
                    Model(R.drawable.kabu, "かぶ　"),
                    Model(R.drawable.kabocya, "かぼちゃ　"),
                    Model(R.drawable.kyabetu, "キャベツ　"),
                    Model(R.drawable.kyuuri, "キュウリ　"),
                    Model(R.drawable.gobou, "ごぼう　"),
                    Model(R.drawable.komatsuna, "小松菜　"),
                    Model(R.drawable.satsumaimo, "さつまいも　"),
                    Model(R.drawable.jyagaimo, "じゃがいも　"),
                    Model(R.drawable.daikon, "大根　"),
                    Model(R.drawable.tamanegi, "玉ネギ　"),
                    Model(R.drawable.chingensai, "ちんげん菜　"),
                    Model(R.drawable.tomato, "トマト　"),
                    Model(R.drawable.nasu, "ナス　"),
                    Model(R.drawable.nira, "ニラ　"),
                    Model(R.drawable.carrot, "人参　"),
                    Model(R.drawable.negi, "ネギ　"),
                    Model(R.drawable.hakusai, "白菜　"),
                    Model(R.drawable.piman, "ピーマン　"),
                    Model(R.drawable.burokkori, "ブロッコリー　"),
                    Model(R.drawable.hourensou, "ほうれん草　"),
                    Model(R.drawable.moyashi, "もやし　"),
                    Model(R.drawable.retasu, "レタス　"),
                    Model(R.drawable.renkon, "レンコン　"),
                    Model(R.drawable.enoki, "えのき　"),
                    Model(R.drawable.eringi, "エリンギ　"),
                    Model(R.drawable.siitake, "しいたけ　"),
                    Model(R.drawable.shimeji, "しめじ　"),
                    Model(R.drawable.tamago, "卵　"),
                    Model(R.drawable.toufu, "豆腐　"),
                    Model(R.drawable.aji, "あじ　"),
                    Model(R.drawable.iwashi, "いわし　"),
                    Model(R.drawable.ebi, "えび　"),
                    Model(R.drawable.katsuo, "かつお　"),
                    Model(R.drawable.sake, "さけ　"),
                    Model(R.drawable.saba, "さば　"),
                    Model(R.drawable.sanma, "さんま　"),
                    Model(R.drawable.tara, "たら　"),
                    Model(R.drawable.buri, "ぶり　"),
                    Model(R.drawable.hokke, "ほっけ　"),
                    Model(R.drawable.mekajiki, "めかじき　")
                )
            )
        } else {
            binding.spinnerWP.adapter = ModelArrayAdapter(
                this,
                listOf(
                    Model(R.drawable.baseline_create_black_48dp, "Manual input  "),
                    Model(R.drawable.shuffle_b, "Shuffle order  "),
                    Model(R.drawable.search_b, "Find details  "),
                    Model(R.drawable.dinner_b, "Main dish  "),
                    Model(R.drawable.salad, "Side dish,Salads  "),
                    Model(R.drawable.soup_b, "Soup,Miso Soup  "),
                    Model(R.drawable.dessert, "Fruits,Desserts  "),
                    Model(R.drawable.beef, "Beef  "),
                    Model(R.drawable.pork, "Pork  "),
                    Model(R.drawable.chiken, "Chicken  "),
                    Model(R.drawable.ingen, "Green beans  "),
                    Model(R.drawable.okura, "Okra  "),
                    Model(R.drawable.kabu, "Turnip  "),
                    Model(R.drawable.kabocya, "Pumpkin  "),
                    Model(R.drawable.kyabetu, "Cabbage  "),
                    Model(R.drawable.kyuuri, "Cucumber  "),
                    Model(R.drawable.gobou, "Burdock  "),
                    Model(R.drawable.komatsuna, "Japanese mustard spinach  "),
                    Model(R.drawable.satsumaimo, "Sweet potato  "),
                    Model(R.drawable.jyagaimo, "Potato  "),
                    Model(R.drawable.daikon, "Japanese white radish  "),
                    Model(R.drawable.tamanegi, "Onion  "),
                    Model(R.drawable.chingensai, "Bok-choy  "),
                    Model(R.drawable.tomato, "Tomato  "),
                    Model(R.drawable.nasu, "Eggplant  "),
                    Model(R.drawable.nira, "Chinese chives  "),
                    Model(R.drawable.carrot, "Carrot  "),
                    Model(R.drawable.negi, "Leek  "),
                    Model(R.drawable.hakusai, "Napa cabbage  "),
                    Model(R.drawable.piman, "Green pepper  "),
                    Model(R.drawable.burokkori, "Broccoli  "),
                    Model(R.drawable.hourensou, "Spinach  "),
                    Model(R.drawable.moyashi, "Bean sprouts  "),
                    Model(R.drawable.retasu, "Lettuce  "),
                    Model(R.drawable.renkon, "Lotus root  "),
                    Model(R.drawable.enoki, "Enoki  "),
                    Model(R.drawable.eringi, "King trumpet  "),
                    Model(R.drawable.siitake, "Shiitake  "),
                    Model(R.drawable.shimeji, "Shimeji  "),
                    Model(R.drawable.tamago, "Egg  "),
                    Model(R.drawable.toufu, "Tofu  "),
                    Model(R.drawable.aji, "Horse mackerel  "),
                    Model(R.drawable.iwashi, "Sardine  "),
                    Model(R.drawable.ebi, "Shrimp  "),
                    Model(R.drawable.katsuo, "Bonito  "),
                    Model(R.drawable.sake, "Salmon  "),
                    Model(R.drawable.saba, "Mackerel  "),
                    Model(R.drawable.sanma, "Pacific saury  "),
                    Model(R.drawable.tara, "Cod  "),
                    Model(R.drawable.buri, "Yellowtail  "),
                    Model(R.drawable.hokke, "Atka mackerel  "),
                    Model(R.drawable.mekajiki, "Swordfish  ")
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

        aaaCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("アスパラの肉巻き"),
                Cuisine("エビフライ"),
                Cuisine("オムライス"),
                Cuisine("お好み焼き"),
                Cuisine("お刺身"),
                Cuisine("ガーリックシュリンプ"),
                Cuisine("カツオのタタキ"),
                Cuisine("カレイの煮付け"),
                Cuisine("カレー"),
                Cuisine("クリームシチュー"),
                Cuisine("グリルチキンのシャワルマ"),
                Cuisine("サーモンのスパイスグリル"),
                Cuisine("サーモンのムケッカ"),
                Cuisine("サーモンのメープルグリル"),
                Cuisine("サイコロステーキ"),
                Cuisine("さつまいもとズッキーニのポークラザニア"),
                Cuisine("サバ味噌煮"),
                Cuisine("サンマの塩焼き"),
                Cuisine("シャクシュカ"),
                Cuisine("シュラスコ"),
                Cuisine("すき焼き"),
                Cuisine("チキンカツ"),
                Cuisine("チキンステーキ"),
                Cuisine("チキンとアスパラのフラットブレッドピザ"),
                Cuisine("チキンナゲット"),
                Cuisine("チキンのマスタードクリームソースがけ"),
                Cuisine("チャーハン"),
                Cuisine("トルティーヤエスパニョーラ"),
                Cuisine("とんかつ"),
                Cuisine("ハニーマスタードチキン"),
                Cuisine("ハマグリのビール蒸し"),
                Cuisine("ハムカツ"),
                Cuisine("ハムとソーセージのハッシュブラウン"),
                Cuisine("ハリバットのグリル　ローストトマト添え"),
                Cuisine("ハンバーグ"),
                Cuisine("ビーフシチュー"),
                Cuisine("ビーフステーキ"),
                Cuisine("ピーマンのチーズ肉詰め焼き"),
                Cuisine("ピーマンの肉詰め"),
                Cuisine("ひき肉とじゃがいものキムチ炒め"),
                Cuisine("フェイジャン"),
                Cuisine("ブリの照り焼き"),
                Cuisine("ブリ大根"),
                Cuisine("ブルスケッタチキン"),
                Cuisine("マカロニグラタン"),
                Cuisine("マッシュルームとモッツァレラのフレンチオムレツ"),
                Cuisine("マヒマヒのグリル"),
                Cuisine("ミートグラタン"),
                Cuisine("ミートソースパスタ"),
                Cuisine("ミートローフ"),
                Cuisine("メンチカツ"),
                Cuisine("ラーメン"),
                Cuisine("レモンチキンソテー"),
                Cuisine("レモンとローズマリーのポークチョップ"),
                Cuisine("ロールキャベツ"),
                Cuisine("回鍋肉"),
                Cuisine("海老のバターソテー"),
                Cuisine("牛丼"),
                Cuisine("鶏ひき肉とキャベツの卵とじ"),
                Cuisine("鶏ひき肉の炒り豆腐"),
                Cuisine("鶏肉とマッシュルームのクリームソテー"),
                Cuisine("鶏肉と野菜のクリーム煮"),
                Cuisine("鶏肉のトマト煮"),
                Cuisine("鶏肉のニンニクソテー"),
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
                Cuisine("豚肉と豆腐の磯部焼き"),
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
                Cuisine("野菜とゴーダチーズのフリッタータ"),
                Cuisine("餃子")
            )
        } else {
            arrayListOf(
                Cuisine("Asparagus wrapped in meat"),
                Cuisine("Barbecued chicken"),
                Cuisine("Beef bowl"),
                Cuisine("Beef stew"),
                Cuisine("Beefsteak"),
                Cuisine("Beer steamed clams"),
                Cuisine("Bruschetta chicken"),
                Cuisine("cabbage rolls"),
                Cuisine("Chicken and Asparagus Flatbread Pizza"),
                Cuisine("Chicken and vegetables in cream"),
                Cuisine("Chicken Cutlet"),
                Cuisine("Chicken in tomato sauce"),
                Cuisine("Chicken nuggets"),
                Cuisine("chicken steak"),
                Cuisine("Chicken with mustard cream sauce"),
                Cuisine("Churrasco"),
                Cuisine("Claypot meat"),
                Cuisine("cream stew"),
                Cuisine("curry"),
                Cuisine("dice steak"),
                Cuisine("Eight treasures"),
                Cuisine("Fei Jiang"),
                Cuisine("French Omelet with Mushrooms and Mozzarella"),
                Cuisine("fried chicken"),
                Cuisine("fried rice"),
                Cuisine("Fried rice"),
                Cuisine("fried shrimp"),
                Cuisine("Fried tofu with minced chicken"),
                Cuisine("Frittata with Vegetables and Gouda Cheese"),
                Cuisine("Garlic Shrimp"),
                Cuisine("Green pepper paste"),
                Cuisine("Grilled chicken shawarma"),
                Cuisine("Grilled Halibut with Roasted Tomatoes"),
                Cuisine("Grilled Mahi Mahi"),
                Cuisine("grilled peppers stuffed with cheese"),
                Cuisine("Grilled Pork and Tofu with Seafood"),
                Cuisine("Grilled Pork with Negi Salt"),
                Cuisine("Grilled Salmon with Maple"),
                Cuisine("Grilled salmon"),
                Cuisine("Grilled saury with salt"),
                Cuisine("Gyoza"),
                Cuisine("Ham and sausage hash browns"),
                Cuisine("Ham cutlet"),
                Cuisine("Hamburg steak"),
                Cuisine("Honey Mustard Chicken"),
                Cuisine("Katsuo no tataki"),
                Cuisine("Lemon and Rosemary Pork Chops"),
                Cuisine("Macaroni au gratin"),
                Cuisine("Mapo Tofu"),
                Cuisine("Marvo vermicelli"),
                Cuisine("meat and potatoes"),
                Cuisine("meat au gratin"),
                Cuisine("meatballs with starchy sauce"),
                Cuisine("Meatloaf"),
                Cuisine("Menchikatsu"),
                Cuisine("Minced chicken and cabbage with egg"),
                Cuisine("Minced chicken and cabbage"),
                Cuisine("Minced pork and daikon with sweet and spicy sauce"),
                Cuisine("Nabeyaki udon"),
                Cuisine("Okonomiyaki"),
                Cuisine("omelet and rice"),
                Cuisine("pasta with meat sauce"),
                Cuisine("pork cutlet"),
                Cuisine("Pork ginger yaki"),
                Cuisine("Pork Kakuni"),
                Cuisine("Pork Kimchi"),
                Cuisine("Pork Lasagna with Sweet Potatoes and Zucchini"),
                Cuisine("Ramen"),
                Cuisine("Salmon Muqueca"),
                Cuisine("Sashimi"),
                Cuisine("Sautéed chicken and mushrooms in cream"),
                Cuisine("Sautéed chicken with garlic"),
                Cuisine("Sauteed lemon chicken"),
                Cuisine("Sauteed Pork and Cabbage with Spicy Bean Paste"),
                Cuisine("Sauteed pork, spinach and egg"),
                Cuisine("Sauteed shrimp in butter"),
                Cuisine("Shakshuka"),
                Cuisine("Simmered mackerel in miso"),
                Cuisine("Spiced grilled salmon"),
                Cuisine("Steamed chicken in a savory microwave"),
                Cuisine("Stewed Chinese cabbage"),
                Cuisine("Stewed flatfish"),
                Cuisine("stir-fried meat and vegetables"),
                Cuisine("Stir-fried minced meat and potatoes with kimchi"),
                Cuisine("stuffed peppers"),
                Cuisine("Sukiyaki"),
                Cuisine("Sweet and sour pork"),
                Cuisine("Teriyaki Chicken"),
                Cuisine("Teriyaki yellowtail"),
                Cuisine("Tortilla Española"),
                Cuisine("yakisoba"),
                Cuisine("Yellowtail radish")
            )
        }

        aabCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("アスパラガスと人参のサラダ"),
                Cuisine("アボカドとフェタチーズのサルサ"),
                Cuisine("アボカドと枝豆のサラダ"),
                Cuisine("イスラエルのサラダ"),
                Cuisine("インゲンのごま和え"),
                Cuisine("エビとアボカドのサラダ"),
                Cuisine("オクラの卵炒め"),
                Cuisine("オニオンリング"),
                Cuisine("カブと厚揚げのめんつゆ炒め"),
                Cuisine("かぼちゃの煮付け"),
                Cuisine("キヌアのハニーレモンビネグレットサラダ"),
                Cuisine("きのこのマヨ焼き"),
                Cuisine("キャベツの塩昆布和え"),
                Cuisine("きゅうりとセロリのピクルス"),
                Cuisine("きゅうりとちくわのサラダ"),
                Cuisine("きんぴらごぼう"),
                Cuisine("グアカモーレ"),
                Cuisine("クスクスのイスラエルサラダ"),
                Cuisine("グリーンデトックスサラダ"),
                Cuisine("ケールのレモンビネグレットサラダ"),
                Cuisine("コールスロー"),
                Cuisine("ココナッツ、キヌア、ほうれん草のサラダ"),
                Cuisine("ごぼうサラダ"),
                Cuisine("ごぼうのつくね揚げ"),
                Cuisine("さつまいもとチキンとキヌアのサラダ"),
                Cuisine("サヤインゲンのツナサラダ"),
                Cuisine("シーザーサラダ"),
                Cuisine("ズッキーニとコーンのパルメザンソテー"),
                Cuisine("ズッキーニのグリルサラダ"),
                Cuisine("スティックサラダ"),
                Cuisine("スモークサーモンとローストビートのサラダ"),
                Cuisine("ツナサラダのアボカド詰め"),
                Cuisine("ツナレタスサラダ"),
                Cuisine("トマト、バジル、モッツァレラのカプレーゼサラダ"),
                Cuisine("トマトサラダ"),
                Cuisine("トマトとキュウリとアボカドのサラダ"),
                Cuisine("トマトのクリームチーズ詰め"),
                Cuisine("トルテリーニの地中海サラダ"),
                Cuisine("ナスとピーマンの味噌炒め"),
                Cuisine("ハーブとキヌアのガーデンサラダ"),
                Cuisine("ハーブとひよこ豆とほうれん草のサラダ"),
                Cuisine("バジルとモッツァレラチーズのマリネ"),
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
                Cuisine("ポテトのシーザーサラダ"),
                Cuisine("マカロニサラダ"),
                Cuisine("みそドレッシングのレインボーサラダ"),
                Cuisine("メイソンジャーサラダ"),
                Cuisine("もやしときゅうりのごま和え"),
                Cuisine("レタスと卵の炒め物"),
                Cuisine("茄子とチェリートマトのスパイシーロースト"),
                Cuisine("茄子とトマトとフェタチーズのロースト"),
                Cuisine("小松菜と厚揚げの煮びたし"),
                Cuisine("焼きナス"),
                Cuisine("水菜と油揚げの煮浸し"),
                Cuisine("大根サラダ"),
                Cuisine("大根とニンジンのピクルス"),
                Cuisine("大根の中華風そぼろ煮"),
                Cuisine("大豆とえだまめのソテー"),
                Cuisine("筑前煮"),
                Cuisine("豆腐とアマランスのサラダ"),
                Cuisine("豆腐とじゃこのサラダ"),
                Cuisine("豚バラもやし炒め"),
                Cuisine("野菜のワッフル"),
                Cuisine("野菜炒め")
            )
        } else {
            arrayListOf(
                Cuisine("Asparagus and Carrot Salad"),
                Cuisine("Avocado and Edamame Salad"),
                Cuisine("Avocado and Feta Cheese Salsa"),
                Cuisine("Bean Sprouts and Cucumber with Sesame Sauce"),
                Cuisine("Boiled pumpkin"),
                Cuisine("Boiled spinach"),
                Cuisine("Breaded broccoli with garlic"),
                Cuisine("Burdock root salad"),
                Cuisine("Cabbage with salted kelp"),
                Cuisine("Caesar salad with potatoes"),
                Cuisine("Caesar salad"),
                Cuisine("Caprese Salad with Tomatoes, Basil and Mozzarella"),
                Cuisine("Chikuzen-ni"),
                Cuisine("Chinese-style simmered radish with minced chicken"),
                Cuisine("Coconut, Quinoa and Spinach Salad"),
                Cuisine("Coleslaw"),
                Cuisine("Deep-fried burdock root with tsukune"),
                Cuisine("Garden Salad with Herbs and Quinoa"),
                Cuisine("Green beans with sesame paste"),
                Cuisine("Green Detox Salad"),
                Cuisine("Green Pepper Namuru"),
                Cuisine("Grilled Eggplant"),
                Cuisine("Grilled Zucchini Salad"),
                Cuisine("Guacamole"),
                Cuisine("Herb, chickpea and spinach salad"),
                Cuisine("Honey Lemon Vinaigrette Salad with Quinoa"),
                Cuisine("Israeli Salad with Couscous"),
                Cuisine("Israeli salad"),
                Cuisine("Kale with Lemon Vinaigrette Salad"),
                Cuisine("Kinpira Gobo"),
                Cuisine("Kyuri and chikuwa salad"),
                Cuisine("Macaroni salad"),
                Cuisine("Marinated Basil and Mozzarella Cheese"),
                Cuisine("Mason Jar Salad"),
                Cuisine("Mediterranean Salad with Tortellini"),
                Cuisine("Mushrooms with mayo"),
                Cuisine("Onion Rings"),
                Cuisine("Pasta Salad"),
                Cuisine("Pickled Cucumber and Celery"),
                Cuisine("Pickled Radish and Carrot"),
                Cuisine("Potato salad"),
                Cuisine("Radish salad"),
                Cuisine("Rainbow Salad with Miso Dressing"),
                Cuisine("Roasted eggplant, tomato and feta cheese"),
                Cuisine("Sauteed eggplant and green pepper with miso"),
                Cuisine("Sauteed Green Pepper and Bean Sprouts with Salt"),
                Cuisine("Sauteed komatsuna and deep-fried tofu"),
                Cuisine("Sauteed okra with egg"),
                Cuisine("Sauteed soybeans and edamame"),
                Cuisine("Sauteed spinach and bacon"),
                Cuisine("Sauteed spinach and tuna with butter and soy sauce"),
                Cuisine("Sauteed turnip and deep-fried tofu with mentsuyu sauce"),
                Cuisine("Sauteed Zucchini and Corn with Parmesan"),
                Cuisine("Shrimp and Avocado Salad"),
                Cuisine("Smoked Salmon and Roasted Beet Salad"),
                Cuisine("Soaked Potherb mustard and fried tofu"),
                Cuisine("Spicy Roasted Eggplant and Cherry Tomatoes"),
                Cuisine("Steamed Broccoli and Tuna with Cheese"),
                Cuisine("Stick salad"),
                Cuisine("Stir-fried lettuce and egg"),
                Cuisine("Stir-fried Pork Belly with Bean Sprouts"),
                Cuisine("Stir-fried spinach and eringi with garlic"),
                Cuisine("Stir-fried vegetables"),
                Cuisine("Sweet Potato, Chicken and Quinoa Salad"),
                Cuisine("Tofu and Amaranth Salad"),
                Cuisine("Tofu and baby sardines salad"),
                Cuisine("tomato salad"),
                Cuisine("Tomato, Cucumber and Avocado Salad"),
                Cuisine("Tomatoes stuffed with cream cheese"),
                Cuisine("Tuna lettuce salad"),
                Cuisine("Tuna Salad Stuffed with Avocado"),
                Cuisine("Tuna salad with pea pods"),
                Cuisine("Vegetable waffles")
            )
        }

        aacCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("あさりの味噌汁"),
                Cuisine("アスパラとベーコンの味噌汁"),
                Cuisine("えのきのサンラータン"),
                Cuisine("オニオングラタンスープ"),
                Cuisine("カブと豆腐のとろみ汁"),
                Cuisine("かぼちゃとココナッツのスープ"),
                Cuisine("カリフラワーのスープ"),
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
                Cuisine("ズッキーニのクリーミースープ"),
                Cuisine("スパイスパンプキンスープ"),
                Cuisine("チンゲンサイの中華スープ"),
                Cuisine("とろろ昆布汁"),
                Cuisine("ナスとエノキの味噌汁"),
                Cuisine("ナスとミョウガのごま味噌汁"),
                Cuisine("なめこと豆腐の味噌汁"),
                Cuisine("ニラと玉子の味噌汁"),
                Cuisine("ニラ玉の味噌汁"),
                Cuisine("ピーマンの味噌汁"),
                Cuisine("フレンチオニオンスープ"),
                Cuisine("ブロッコリーとじゃがいものスープ"),
                Cuisine("ポテトとケールのクリーミースープ"),
                Cuisine("ポトフ"),
                Cuisine("ボルシチ"),
                Cuisine("ミネストローネ"),
                Cuisine("もやしの中華スープ"),
                Cuisine("レタスの味噌汁"),
                Cuisine("レンコン団子汁"),
                Cuisine("ローストトマトとバジルのクリーミースープ"),
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
        } else {
            arrayListOf(
                Cuisine("Borscht"),
                Cuisine("Broccoli and Potato Soup"),
                Cuisine("Cabbage and Egg Soup"),
                Cuisine("Cauliflower Miso Soup"),
                Cuisine("Cauliflower Soup"),
                Cuisine("Chinese Bean Sprouts Soup"),
                Cuisine("Chinese green chinese soup"),
                Cuisine("Clam chowder"),
                Cuisine("Consomme Soup"),
                Cuisine("Corn Soup"),
                Cuisine("Creamy Potato and Kale Soup"),
                Cuisine("Creamy Roasted Tomato and Basil Soup"),
                Cuisine("Creamy Zucchini Soup"),
                Cuisine("Eggplant and myoga miso soup with sesame seeds"),
                Cuisine("Enoki Mushroom Sanratang"),
                Cuisine("French Onion Soup"),
                Cuisine("Kalbi Kuppa"),
                Cuisine("kelp soup"),
                Cuisine("Kenchin-jiru"),
                Cuisine("Lentil Dumpling Soup"),
                Cuisine("Lettuce in miso soup"),
                Cuisine("Minestrone"),
                Cuisine("Miso soup of shiitake mushroom and spinach"),
                Cuisine("Miso soup with asparagus and bacon"),
                Cuisine("Miso soup with cabbage and bacon in soy milk"),
                Cuisine("Miso soup with Chinese cabbage and komatsuna"),
                Cuisine("Miso soup with eggplant and enoki mushroom"),
                Cuisine("Miso soup with green pepper"),
                Cuisine("Miso Soup with Kimchi"),
                Cuisine("Miso soup with leek and egg"),
                Cuisine("Miso soup with leek balls"),
                Cuisine("Miso soup with nameko mushroom and tofu"),
                Cuisine("Miso soup with potatoes and onions"),
                Cuisine("Miso Soup with Potatoes and Watercress"),
                Cuisine("Miso soup with radish and deep-fried tofu"),
                Cuisine("Miso soup with scallion"),
                Cuisine("Miso soup with tofu and wakame seaweed"),
                Cuisine("Onion and Garlic Soup"),
                Cuisine("Onion gratin soup"),
                Cuisine("Pork Shabu and Dried Plum Soup"),
                Cuisine("Pork soup"),
                Cuisine("Pot-au-feu"),
                Cuisine("Pumpkin and Coconut Soup"),
                Cuisine("Sawani soup"),
                Cuisine("Seaweed soup"),
                Cuisine("Shijimi-jiru"),
                Cuisine("Soybean and Tomato Soup"),
                Cuisine("Spiced Pumpkin Soup"),
                Cuisine("Turnip and Tofu Soup"),
                Cuisine("Vermicelli soup")
            )
        }

        aadCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("アイス"),
                Cuisine("アサイーとベリーのグラニテ"),
                Cuisine("あんみつ"),
                Cuisine("いちご"),
                Cuisine("いちごの錦玉"),
                Cuisine("おしるこ"),
                Cuisine("オレンジ"),
                Cuisine("カフェオレゼリー"),
                Cuisine("キウイフルーツ"),
                Cuisine("コーヒーゼリー"),
                Cuisine("コカーダ"),
                Cuisine("スモア"),
                Cuisine("チョコバナナパフェ"),
                Cuisine("チョコムース"),
                Cuisine("トウファ"),
                Cuisine("パウンドケーキ"),
                Cuisine("バナナ"),
                Cuisine("バナナスムージー"),
                Cuisine("ババロア"),
                Cuisine("パンケーキ"),
                Cuisine("パンナコッタ"),
                Cuisine("パンネンクーケン"),
                Cuisine("ブドウ"),
                Cuisine("ブリガデイロ"),
                Cuisine("プリン"),
                Cuisine("フルーチェ"),
                Cuisine("ブロンディ"),
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
                Cuisine("焼マシュマロのミルクシェイク"),
                Cuisine("大福"),
                Cuisine("団子"),
                Cuisine("桃"),
                Cuisine("桃のコンポート"),
                Cuisine("豆乳ドーナツ"),
                Cuisine("抹茶ティラミス"),
                Cuisine("梨"),
                Cuisine("餃子の皮クレープ")
            )
        } else {
            arrayListOf(
                Cuisine("Acai and berry granite"),
                Cuisine("Anmitsu"),
                Cuisine("apple glace"),
                Cuisine("Apples"),
                Cuisine("Apricot bean curd"),
                Cuisine("banana smoothie"),
                Cuisine("banana"),
                Cuisine("Bavarois"),
                Cuisine("Blondie"),
                Cuisine("Brigadeiro"),
                Cuisine("Cafe au lait jelly"),
                Cuisine("chocolate banana parfait"),
                Cuisine("chocolate mousse"),
                Cuisine("coffee jelly"),
                Cuisine("Coquada"),
                Cuisine("Daifuku"),
                Cuisine("dango"),
                Cuisine("Frutche"),
                Cuisine("grapes"),
                Cuisine("green tea tiramisu"),
                Cuisine("Gyoza skin crepe"),
                Cuisine("Ice cream"),
                Cuisine("Kiwifruit"),
                Cuisine("melon"),
                Cuisine("Milkshake with roasted marshmallows"),
                Cuisine("Muffins"),
                Cuisine("oranges"),
                Cuisine("Oshiruko"),
                Cuisine("pancakes"),
                Cuisine("Pancakes"),
                Cuisine("Panna cotta"),
                Cuisine("Pannen Kuken"),
                Cuisine("peach compote"),
                Cuisine("Peaches"),
                Cuisine("pear"),
                Cuisine("Pound cake"),
                Cuisine("pudding"),
                Cuisine("S'mores"),
                Cuisine("soy milk donuts"),
                Cuisine("strawberries"),
                Cuisine("Strawberry brocade"),
                Cuisine("Tangerine jelly"),
                Cuisine("Tangerine sorbet"),
                Cuisine("tangerine"),
                Cuisine("Tofa"),
                Cuisine("Yogurt crepes"),
                Cuisine("yogurt")
            )
        }

        aCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("肉じゃが"),
                Cuisine("牛丼"),
                Cuisine("すき焼き"),
                Cuisine("サイコロステーキ"),
                Cuisine("ビーフシチュー"),
                Cuisine("ビーフステーキ"),

                Cuisine("プルコギ"),
                Cuisine("牛肉とほうれん草のクリーム煮"),
                Cuisine("牛肉とトマトのキムチ卵炒め"),
                Cuisine("牛肉とナスのオイスターソース炒め"),
                Cuisine("牛肉とごぼうのしぐれ煮"),
                Cuisine("牛肉と大根の煮込み"),
                Cuisine("牛肉とレンコンの辛みそ炒め"),
                Cuisine("牛たたきの焼き漬け"),
                Cuisine("牛肉のトマト煮"),
                Cuisine("牛肉のエスニック風サラダ"),
                Cuisine("肉豆腐"),
                Cuisine("白菜のすき焼き風煮"),
                Cuisine("焼肉のフレッシュトマトソース"),
                Cuisine("かぼちゃと牛肉のチリソース炒め"),
                Cuisine("キュウリと牛しゃぶのごまあえ"),
                Cuisine("玉ねぎと牛肉のウスターソース炒め"),
                Cuisine("ごぼうと牛肉の柳川風"),
                Cuisine("きのこ入りプルコギ"),
                Cuisine("ハヤシライス"),
                Cuisine("ピザ風餃子"),
                Cuisine("春雨とひき肉の炒めもの"),
            )
        } else {
            arrayListOf(

            )
        }
        bCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("豚キムチ"),
                Cuisine("豚しゃぶと梅干しのスープ"),
                Cuisine("豚バラもやし炒め"),
                Cuisine("豚ひき肉と大根の甘辛煮"),
                Cuisine("豚角煮"),
                Cuisine("豚汁"),
                Cuisine("豚生姜焼き"),
                Cuisine("豚肉とキャベツのピリ辛みそ炒め"),
                Cuisine("豚肉とほうれん草、卵の炒め物"),
                Cuisine("豚肉と豆腐の磯部焼き"),
                Cuisine("豚肉のネギ塩焼き"),
                Cuisine("ハムカツ"),
                Cuisine("ハムとソーセージのハッシュブラウン"),
                Cuisine("とんかつ"),
                Cuisine("酢豚"),
                Cuisine("レモンとローズマリーのポークチョップ"),
            )
        } else {
            arrayListOf(

            )
        }
        cCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("鶏ひき肉とキャベツの卵とじ"),
                Cuisine("鶏ひき肉の炒り豆腐"),
                Cuisine("鶏肉とマッシュルームのクリームソテー"),
                Cuisine("鶏肉と野菜のクリーム煮"),
                Cuisine("鶏肉のトマト煮"),
                Cuisine("鶏肉のニンニクソテー"),
                Cuisine("鶏肉の香味レンジ蒸し"),
                Cuisine("鶏肉の照り焼き"),
                Cuisine("チキンカツ"),
                Cuisine("チキンステーキ"),
                Cuisine("チキンとアスパラのフラットブレッドピザ"),
                Cuisine("チキンナゲット"),
                Cuisine("チキンのマスタードクリームソースがけ"),
                Cuisine("レモンチキンソテー"),
                Cuisine("棒棒鶏"),
                Cuisine("唐揚げ"),
                Cuisine("ハニーマスタードチキン"),
                Cuisine("ブルスケッタチキン"),
                Cuisine("グリルチキンのシャワルマ"),
            )
        } else {
            arrayListOf(

            )
        }
        dCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("いんげんのごま和え"),
                Cuisine("さやいんげんのツナサラダ"),

                Cuisine("豚肉のいんげんロール揚げ"),
                Cuisine("さやいんげんといかの炒めもの"),
                Cuisine("さやいんげんのベーコン巻きフライ"),
                Cuisine("いんげんのごま煮"),
                Cuisine("えのきといんげんの味噌汁"),

            )
        } else {
            arrayListOf(

            )
        }
        eCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("オクラの卵炒め"),
                Cuisine("たたきオクラ冷やっこ"),
                Cuisine("豚しゃぶのおろしオクラのせ"),
                Cuisine("ささみのめんつゆオクラがけ"),
                Cuisine("オクラの梅肉あえ"),
                Cuisine("オクラとクリームチーズのおかかあえ"),
                Cuisine("オクラととろろとたこの酢のもの"),
                Cuisine("豆腐とオクラの味噌汁"),
                Cuisine("大根のすり流し汁"),
            )
        } else {
            arrayListOf()
        }
        fCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("カブと厚揚げのめんつゆ炒め"),
                Cuisine("カブと豆腐のとろみ汁"),
                Cuisine("豚こまとカブのカレーじょうゆ炒め"),
                Cuisine("ブリの鍋照り焼き"),
                Cuisine("カブのエビそぼろ煮"),
                Cuisine("かきとカブのおろし煮"),
                Cuisine("ほたてとカブのサラダ"),
                Cuisine("油揚げとカブのさっと煮"),
                Cuisine("カブと鶏つくねの煮もの"),
            )
        } else {
            arrayListOf()
        }
        gCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("かぼちゃとココナッツのスープ"),
                Cuisine("かぼちゃの煮付け"),
                Cuisine("スパイスパンプキンスープ"),

                Cuisine("かぼちゃコロッケ"),
                Cuisine("かぼちゃのひき肉あんかけ"),
                Cuisine("豚肉とかぼちゃの串カツ"),
                Cuisine("かぼちゃとココナッツのスープ"),
                Cuisine("かぼちゃのそぼろ煮"),
                Cuisine("かぼちゃと牛肉のチリソース炒め"),
                Cuisine("かぼちゃのマヨチーズ焼き"),
                Cuisine("かぼちゃのバターしょうゆあえ"),
                Cuisine("鶏肉とかぼちゃのほうとう風"),
                Cuisine("かぼちゃのごま煮"),
            )
        } else {
            arrayListOf()
        }
        hCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("キャベツとベーコンの豆乳味噌汁"),
                Cuisine("キャベツと玉子のスープ"),
                Cuisine("キャベツの塩昆布和え"),
                Cuisine("ロールキャベツ"),

                Cuisine("鶏ひき肉とキャベツの卵とじ"),
                Cuisine("回鍋肉"),
                Cuisine("豚肉とキャベツのピリ辛みそ炒め"),
                Cuisine("キャベツのウインナー巻き煮"),
                Cuisine("お好み焼き"),
                Cuisine("豆腐、キャベツ、豚肉のチャンプルー"),
                Cuisine("コールスロー"),
                Cuisine("キャベツと油揚げのおひたし"),
                Cuisine("キャベツとシイタケのじゃこ炒め"),

            )
        } else {
            arrayListOf()
        }
        iCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("キュウリとセロリのピクルス"),
                Cuisine("キュウリとちくわのサラダ"),

                Cuisine("棒棒鶏"),
                Cuisine("たことキュウリの酢のもの"),
                Cuisine("キュウリと牛しゃぶのごまあえ"),
                Cuisine("キュウリと豚肉、ちくわの梅しょうが炒め"),
                Cuisine("たたきキュウリのエスニックサラダ"),
                Cuisine("キュウリと豚しゃぶのねぎみそソース"),
                Cuisine("キュウリのポン酢炒め"),
                Cuisine("キュウリとわかめのマヨあえ"),
                Cuisine("白菜とキュウリの浅漬け"),


            )
        } else {
            arrayListOf()
        }
        jCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("きんぴらごぼう"),
                Cuisine("ごぼうとツナのサラダ"),
                Cuisine("ごぼうのつくね揚げ"),

                Cuisine("牛肉とごぼうのしぐれ煮"),
                Cuisine("サンマとごぼうの煮もの"),
                Cuisine("たたきごぼうのごまあえ"),
                Cuisine("ごぼうのごまマヨサラダ"),
            )
        } else {
            arrayListOf()
        }
        kCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("小松菜と厚揚げの煮びたし"),

                Cuisine("鶏肉と小松菜のスープ煮"),
                Cuisine("エビと小松菜のミルク煮"),
                Cuisine("豆腐と小松菜のオイスターソース煮"),
                Cuisine("小松菜と鶏肉、卵の炒めもの"),
                Cuisine("小松菜と玉ねぎの味噌汁"),
                Cuisine("小松菜のオリーブじょうゆソテー"),
            )
        } else {
            arrayListOf()
        }
        lCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("さつまいもとズッキーニのポークラザニア"),
                Cuisine("さつまいもとチキンとキヌアのサラダ"),

                Cuisine("さつまいもの豚肉巻き揚げ"),
                Cuisine("さつまいものレモン煮"),
                Cuisine("さつまいものごま炒め"),
                Cuisine("さつまいものバターソテー"),
                Cuisine("大学芋"),
            )
        } else {
            arrayListOf()
        }
        mCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("じゃがいもとクレソンの味噌汁"),
                Cuisine("じゃがいもと玉ねぎの味噌汁"),
                Cuisine("ひき肉とじゃがいものキムチ炒め"),
                Cuisine("ポテトサラダ"),
                Cuisine("ポテトとケールのクリーミースープ"),
                Cuisine("ポテトのシーザーサラダ"),

                Cuisine("じゃがいもと肉団子のトマト煮"),
                Cuisine("肉じゃが"),
                Cuisine("さけとじゃがいものクリーム煮"),
                Cuisine("ツナポテトグラタン"),
                Cuisine("油揚げのポテト巻き"),
                Cuisine("じゃがいもと鶏肉のチーズ焼き"),
                Cuisine("ジャーマンポテト"),
                Cuisine("農夫の朝食"),
                Cuisine("じゃがいもと豚ももの塩炒め"),
                Cuisine("じゃがいもとじゃこのガレット"),
                Cuisine("じゃがいもと鶏のタッカルビ"),
                Cuisine("みつばとじゃがいもの三杯酢"),
                Cuisine("じゃがいもの冷たいミルクスープ"),
            )
        } else {
            arrayListOf()
        }
        nCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("大根サラダ"),
                Cuisine("大根とニンジンのピクルス"),
                Cuisine("大根と油揚げの味噌汁"),
                Cuisine("大根のそぼろ煮"),
                Cuisine("大根の中華風そぼろ煮"),

                Cuisine("おろししょうが焼き"),
                Cuisine("豚ひき肉と大根の甘辛煮"),
                Cuisine("鶏手羽と大根の煮もの"),
                Cuisine("牛肉と大根の煮込み"),
                Cuisine("ブリ大根"),
                Cuisine("さんまのおろし煮"),
                Cuisine("ゆで卵と大根のめんつゆ煮"),
                Cuisine("豆腐のみぞれ鍋"),
                Cuisine("厚揚げと大根の煮もの"),
                Cuisine("ふろふき大根"),
                Cuisine("大根とさけのみそ煮"),
                Cuisine("豚肉のおろしあえ"),
                Cuisine("大根とカリカリじゃこのサラダ"),
                Cuisine("紅白なます"),
                Cuisine("大根とハムのガーリックサラダ"),
                Cuisine("大根としめじのしょうゆ炒め"),
            )
        } else {
            arrayListOf()
        }
        oCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("オニオングラタンスープ"),
                Cuisine("オニオンリング"),
                Cuisine("フレンチオニオンスープ"),
                Cuisine("玉ねぎとニンニクのスープ"),

                Cuisine("玉ねぎとマッシュルームのスクランブルエッグ"),
                Cuisine("玉ねぎと牛肉のウスターソース炒め"),
                Cuisine("まいたけと玉ねぎの卵とじ炒め"),
                Cuisine("玉ねぎとウインナーの甘酢マリネ"),
                Cuisine("玉ねぎベーコンチーズ焼き"),
                Cuisine("玉ねぎとツナの煮びたし"),
            )
        } else {
            arrayListOf()
        }
        pCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("チンゲンサイの中華スープ"),
            )
        } else {
            arrayListOf()
        }
        qCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("トマト、バジル、モッツァレラのカプレーゼサラダ"),
                Cuisine("トマトサラダ"),
                Cuisine("トマトとキュウリとアボカドのサラダ"),
                Cuisine("トマトのクリームチーズ詰め"),
                Cuisine("ローストトマトとバジルのクリーミースープ"),
                Cuisine("大豆とトマトのスープ"),
            )
        } else {
            arrayListOf()
        }
        rCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ナスとエノキの味噌汁"),
                Cuisine("ナスとピーマンの味噌炒め"),
                Cuisine("ナスとミョウガのごま味噌汁"),
                Cuisine("ナスとチェリートマトのスパイシーロースト"),
                Cuisine("ナスとトマトとフェタチーズのロースト"),
                Cuisine("焼きナス"),
            )
        } else {
            arrayListOf()
        }
        sCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ニラと玉子の味噌汁"),
            )
        } else {
            arrayListOf()
        }
        tCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(

            )
        } else {
            arrayListOf()
        }
        uCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(

            )
        } else {
            arrayListOf()
        }
        vCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("白菜と小松菜の味噌汁"),
                Cuisine("白菜の旨煮"),
            )
        } else {
            arrayListOf()
        }
        wCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ピーマンともやしの塩炒め"),
                Cuisine("ピーマンのチーズ肉詰め焼き"),
                Cuisine("ピーマンのナムル"),
                Cuisine("ピーマンの肉詰め"),
                Cuisine("ピーマンの味噌汁"),
            )
        } else {
            arrayListOf()
        }
        xCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ブロッコリーとじゃがいものスープ"),
                Cuisine("ブロッコリーとツナのチーズ蒸し"),
                Cuisine("ブロッコリーのガーリックパン粉がけ"),
            )
        } else {
            arrayListOf()
        }
        yCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ほうれん草とエリンギのニンニク炒め"),
                Cuisine("ほうれん草とツナのバターしょうゆ炒め"),
                Cuisine("ほうれん草とベーコンのソテー"),
                Cuisine("ほうれん草のおひたし"),
                Cuisine("ココナッツ、キヌア、ほうれん草のサラダ"),
                Cuisine("ハーブとひよこ豆とほうれん草のサラダ"),
            )
        } else {
            arrayListOf()
        }
        zCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("もやしときゅうりのごま和え"),
                Cuisine("もやしの中華スープ"),
            )
        } else {
            arrayListOf()
        }
        aaCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("レタスと卵の炒め物"),
                Cuisine("レタスの味噌汁"),
                Cuisine("シーザーサラダ"),
                Cuisine("ツナレタスサラダ"),
            )
        } else {
            arrayListOf()
        }
        abCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("レンコン団子汁"),
            )
        } else {
            arrayListOf()
        }
        acCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("えのきのサンラータン"),
            )
        } else {
            arrayListOf()
        }
        adCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(

            )
        } else {
            arrayListOf()
        }
        aeCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("椎茸とほうれん草の味噌汁"),
            )
        } else {
            arrayListOf()
        }
        afCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(

            )
        } else {
            arrayListOf()
        }
        agCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("オムライス"),
                Cuisine("シャクシュカ"),
                Cuisine("マッシュルームとモッツァレラのフレンチオムレツ"),
            )
        } else {
            arrayListOf()
        }
        ahCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("豆腐とアマランスのサラダ"),
                Cuisine("豆腐とじゃこのサラダ"),
                Cuisine("豆腐とわかめの味噌汁"),
                Cuisine("なめこと豆腐の味噌汁"),
                Cuisine("麻婆豆腐"),
            )
        } else {
            arrayListOf()
        }
        aiCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("あじの梅しそフライ"),
                Cuisine("あじの塩焼き"),
                Cuisine("あじのたたき"),
                Cuisine("焼きあじの香味ソース"),
                Cuisine("あじのチーズ焼き"),
                Cuisine("あじの南蛮漬け"),
                Cuisine("あじの干ものずし"),
            )
        } else {
            arrayListOf()
        }
        ajCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("いわしのつみれハンバーグ"),
                Cuisine("いわしのしょうが煮"),
                Cuisine("いわしのかば焼き"),
                Cuisine("いわしのマスタードケチャップフライ"),
                Cuisine("いわしの香草パン粉焼き"),
                Cuisine("いわしのマリネサラダ"),
                Cuisine("いわしのつみれ汁"),
            )
        } else {
            arrayListOf()
        }
        akCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("エビとアボカドのサラダ"),
                Cuisine("エビフライ"),
                Cuisine("ガーリックシュリンプ"),
                Cuisine("海老のバターソテー"),
                Cuisine("エビチリ"),

                Cuisine("エビマヨ"),
                Cuisine("エビとナスとセロリの塩炒め"),
                Cuisine("エビともやしのエスニック炒め"),
                Cuisine("エビと小松菜のミルク煮"),
                Cuisine("エビとニラのチヂミ"),
                Cuisine("白菜とエビの塩炒め"),

            )
        } else {
            arrayListOf()
        }
        alCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("カツオのタタキ"),

                Cuisine("カツオと新玉ねぎのサラダ"),
                Cuisine("カツオのスパイス揚げ"),
                Cuisine("カツオのしぐれ煮"),
                Cuisine("カツオのキムチあえ丼"),
            )
        } else {
            arrayListOf()
        }
        amCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("サーモンのスパイスグリル"),
                Cuisine("サーモンのムケッカ"),
                Cuisine("サーモンのメープルグリル"),
                Cuisine("スモークサーモンとローストビートのサラダ"),
                Cuisine("焼鮭"),

                Cuisine("ほうれん草とさけのクリームシチュー"),
                Cuisine("さけのムニエル"),
                Cuisine("さけのちゃんちゃん焼き"),
                Cuisine("さけのにんにくパン粉フライ"),
                Cuisine("さけのレンジ蒸しフレッシュトマトソース"),
                Cuisine("さけのから揚げ甘酢あんかけ"),
                Cuisine("大根とさけの味噌煮"),
            )
        } else {
            arrayListOf()
        }
        anCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("サバ味噌煮"),

                Cuisine("サバのにんにくソテー"),
                Cuisine("サバのチーズ焼き"),
                Cuisine("サバのカレー揚げ"),
                Cuisine("サバのキムチ煮"),
                Cuisine("サバそぼろ"),
            )
        } else {
            arrayListOf()
        }
        aoCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("サンマの塩焼き"),

                Cuisine("サンマとごぼうの煮もの"),
                Cuisine("サンマのキムチ煮"),
                Cuisine("サンマのごまから揚げ"),
                Cuisine("サンマのねぎみそ焼き"),
                Cuisine("サンマのおろし煮"),
            )
        } else {
            arrayListOf()
        }
        apCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("たら、しめじ、ミニトマトのアクアパッツァ"),
                Cuisine("たらと豆腐の韓国風煮もの"),
                Cuisine("たらのホイル蒸し焼き"),
                Cuisine("キャベツとたらの蒸し煮"),
                Cuisine("さつまいもとたらのグラタン"),
                Cuisine("たらのとろみ鍋"),
            )
        } else {
            arrayListOf()
        }
        aqCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ブリの照り焼き"),
                Cuisine("ブリ大根"),

                Cuisine("ブリとちんげん菜の中華塩炒め"),
                Cuisine("ブリのトマト照り焼き"),
            )
        } else {
            arrayListOf()
        }
        arCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("ほっけの煮付け"),
                Cuisine("ほっけの竜田揚げ"),
                Cuisine("ほっけのハーブ焼き"),
            )
        } else {
            arrayListOf()
        }
        asCuisines = if (locale == Locale.JAPAN) {
            arrayListOf(
                Cuisine("もやしとかじきのキムチ炒め"),

                Cuisine("めかじきのバターしょうゆソテー"),
                Cuisine("めかじきの生姜焼き"),
            )
        } else {
            arrayListOf()
        }

        aaaCustomAdapter = CustomAdapter(this, aaaCuisines, this)
        aabCustomAdapter = CustomAdapter(this, aabCuisines, this)
        aacCustomAdapter = CustomAdapter(this, aacCuisines, this)
        aadCustomAdapter = CustomAdapter(this, aadCuisines, this)
        aCustomAdapter = CustomAdapter(this, aCuisines, this)
        bCustomAdapter = CustomAdapter(this, bCuisines, this)
        cCustomAdapter = CustomAdapter(this, cCuisines, this)
        dCustomAdapter = CustomAdapter(this, dCuisines, this)
        eCustomAdapter = CustomAdapter(this, eCuisines, this)
        fCustomAdapter = CustomAdapter(this, fCuisines, this)
        gCustomAdapter = CustomAdapter(this, gCuisines, this)
        hCustomAdapter = CustomAdapter(this, hCuisines, this)
        iCustomAdapter = CustomAdapter(this, iCuisines, this)
        jCustomAdapter = CustomAdapter(this, jCuisines, this)
        kCustomAdapter = CustomAdapter(this, kCuisines, this)
        lCustomAdapter = CustomAdapter(this, lCuisines, this)
        mCustomAdapter = CustomAdapter(this, mCuisines, this)
        nCustomAdapter = CustomAdapter(this, nCuisines, this)
        oCustomAdapter = CustomAdapter(this, oCuisines, this)
        pCustomAdapter = CustomAdapter(this, pCuisines, this)
        qCustomAdapter = CustomAdapter(this, qCuisines, this)
        rCustomAdapter = CustomAdapter(this, rCuisines, this)
        sCustomAdapter = CustomAdapter(this, sCuisines, this)
        tCustomAdapter = CustomAdapter(this, tCuisines, this)
        uCustomAdapter = CustomAdapter(this, uCuisines, this)
        vCustomAdapter = CustomAdapter(this, vCuisines, this)
        wCustomAdapter = CustomAdapter(this, wCuisines, this)
        xCustomAdapter = CustomAdapter(this, xCuisines, this)
        yCustomAdapter = CustomAdapter(this, yCuisines, this)
        zCustomAdapter = CustomAdapter(this, zCuisines, this)
        aaCustomAdapter = CustomAdapter(this, aaCuisines, this)
        abCustomAdapter = CustomAdapter(this, abCuisines, this)
        acCustomAdapter = CustomAdapter(this, acCuisines, this)
        adCustomAdapter = CustomAdapter(this, adCuisines, this)
        aeCustomAdapter = CustomAdapter(this, aeCuisines, this)
        afCustomAdapter = CustomAdapter(this, afCuisines, this)
        agCustomAdapter = CustomAdapter(this, agCuisines, this)
        ahCustomAdapter = CustomAdapter(this, ahCuisines, this)
        aiCustomAdapter = CustomAdapter(this, aiCuisines, this)
        ajCustomAdapter = CustomAdapter(this, ajCuisines, this)
        akCustomAdapter = CustomAdapter(this, akCuisines, this)
        alCustomAdapter = CustomAdapter(this, alCuisines, this)
        amCustomAdapter = CustomAdapter(this, amCuisines, this)
        anCustomAdapter = CustomAdapter(this, anCuisines, this)
        aoCustomAdapter = CustomAdapter(this, aoCuisines, this)
        apCustomAdapter = CustomAdapter(this, apCuisines, this)
        aqCustomAdapter = CustomAdapter(this, aqCuisines, this)
        arCustomAdapter = CustomAdapter(this, arCuisines, this)
        asCustomAdapter = CustomAdapter(this, asCuisines, this)


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
                "鶏肉のニンニクソテー",
                "ハリバットのグリル　ローストトマト添え",
                "お刺身",
                "野菜とゴーダチーズのフリッタータ",
                "鶏肉とマッシュルームのクリームソテー",
                "マヒマヒのグリル",
                "さつまいもとズッキーニのポークラザニア",
                "グリルチキンのシャワルマ",
                "トルティーヤエスパニョーラ",
                "ハムとソーセージのハッシュブラウン",
                "海老のバターソテー",
                "レモンチキンソテー",
                "マッシュルームとモッツァレラのフレンチオムレツ",
                "チキンとアスパラのフラットブレッドピザ",
                "レモンとローズマリーのポークチョップ",
                "ハニーマスタードチキン",
                "フェイジャン",
                "サーモンのムケッカ",
                "サーモンのスパイスグリル",
                "シャクシュカ",
                "ガーリックシュリンプ",
                "ハマグリのビール蒸し",
                "シュラスコ",
                "ブルスケッタチキン",
                "チキンのマスタードクリームソースがけ",
                "サーモンのメープルグリル"
            )
        } else {
            mutableSetOf(
                "Hamburg steak",
                "Gyoza",
                "cream stew",
                "stir-fried meat and vegetables",
                "fried chicken",
                "cabbage rolls",
                "Mapo Tofu",
                "fried shrimp",
                "pork cutlet",
                "Sukiyaki",
                "yakisoba",
                "Ramen",
                "Nabeyaki udon",
                "pasta with meat sauce",
                "Okonomiyaki",
                "fried rice",
                "Pork ginger yaki",
                "Macaroni au gratin",
                "meat au gratin",
                "Beef stew",
                "Beefsteak",
                "Ham cutlet",
                "Menchikatsu",
                "dice steak",
                "chicken steak",
                "omelet and rice",
                "meat and potatoes",
                "Beef bowl",
                "curry",
                "Eight treasures",
                "stuffed peppers",
                "Asparagus wrapped in meat",
                "Stewed Chinese cabbage",
                "Claypot meat",
                "Green pepper paste",
                "Teriyaki yellowtail",
                "Yellowtail radish",
                "Katsuo no tataki",
                "Stewed flatfish",
                "Simmered mackerel in miso",
                "Grilled saury with salt",
                "Grilled salmon",
                "meatballs with starchy sauce",
                "Fried rice",
                "grilled peppers stuffed with cheese",
                "Chicken nuggets",
                "Minced pork and daikon with sweet and spicy sauce",
                "Marvo vermicelli",
                "Stir-fried minced meat and potatoes with kimchi",
                "Meatloaf",
                "Minced chicken and cabbage",
                "Minced chicken and cabbage with egg",
                "Fried tofu with minced chicken",
                "Grilled Pork with Negi Salt",
                "Sauteed pork, spinach and egg",
                "Pork Kimchi",
                "Grilled Pork and Tofu with Seafood",
                "Sauteed Pork and Cabbage with Spicy Bean Paste",
                "Sweet and sour pork",
                "Pork Kakuni",
                "Teriyaki Chicken",
                "Chicken in tomato sauce",
                "Steamed chicken in a savory microwave",
                "Chicken and vegetables in cream",
                "Barbecued chicken",
                "Chicken Cutlet",
                "Sautéed chicken with garlic",
                "Grilled Halibut with Roasted Tomatoes",
                "Sashimi",
                "Frittata with Vegetables and Gouda Cheese",
                "Sautéed chicken and mushrooms in cream",
                "Grilled Mahi Mahi",
                "Pork Lasagna with Sweet Potatoes and Zucchini",
                "Grilled chicken shawarma",
                "Tortilla Española",
                "Ham and sausage hash browns",
                "Sauteed shrimp in butter",
                "Sauteed lemon chicken",
                "French Omelet with Mushrooms and Mozzarella",
                "Chicken and Asparagus Flatbread Pizza",
                "Lemon and Rosemary Pork Chops",
                "Honey Mustard Chicken",
                "Fei Jiang",
                "Salmon Muqueca",
                "Spiced grilled salmon",
                "Shakshuka",
                "Garlic Shrimp",
                "Beer steamed clams",
                "Churrasco",
                "Bruschetta chicken",
                "Chicken with mustard cream sauce",
                "Grilled Salmon with Maple"
            )
        }

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
                "きのこのマヨ焼き",
                "イスラエルのサラダ",
                "メイソンジャーサラダ",
                "大根とニンジンのピクルス",
                "トマトとキュウリとアボカドのサラダ",
                "茄子とトマトとフェタチーズのロースト",
                "ズッキーニとコーンのパルメザンソテー",
                "トルテリーニの地中海サラダ",
                "トマト、バジル、モッツァレラのカプレーゼサラダ",
                "みそドレッシングのレインボーサラダ",
                "茄子とチェリートマトのスパイシーロースト",
                "ハーブとキヌアのガーデンサラダ",
                "グリーンデトックスサラダ",
                "ツナサラダのアボカド詰め",
                "キヌアのハニーレモンビネグレットサラダ",
                "スモークサーモンとローストビートのサラダ",
                "さつまいもとチキンとキヌアのサラダ",
                "ケールのレモンビネグレットサラダ",
                "豆腐とアマランスのサラダ",
                "グアカモーレ",
                "アボカドとフェタチーズのサルサ",
                "ポテトのシーザーサラダ",
                "バジルとモッツァレラチーズのマリネ",
                "野菜のワッフル",
                "大豆とえだまめのソテー",
                "ズッキーニのグリルサラダ",
                "クスクスのイスラエルサラダ",
                "トマトのクリームチーズ詰め",
                "ココナッツ、キヌア、ほうれん草のサラダ",
                "アボカドと枝豆のサラダ",
                "ハーブとひよこ豆とほうれん草のサラダ"
            )
        } else {
            mutableSetOf(
                "Asparagus and Carrot Salad",
                "Bean Sprouts and Cucumber with Sesame Sauce",
                "Boiled pumpkin",
                "Boiled spinach",
                "Breaded broccoli with garlic",
                "Burdock root salad",
                "Cabbage with salted kelp",
                "Caesar salad",
                "Chikuzen-ni",
                "Chinese-style simmered radish with minced chicken",
                "Coleslaw",
                "Deep-fried burdock root with tsukune",
                "Green beans with sesame paste",
                "Green Pepper Namuru",
                "Grilled Eggplant",
                "Israeli salad",
                "Kinpira Gobo",
                "Kyuri and chikuwa salad",
                "Macaroni salad",
                "Mushrooms with mayo",
                "Onion Rings",
                "Pasta Salad",
                "Pickled Cucumber and Celery",
                "Potato salad",
                "Radish salad",
                "Sauteed eggplant and green pepper with miso",
                "Sauteed Green Pepper and Bean Sprouts with Salt",
                "Sauteed komatsuna and deep-fried tofu",
                "Sauteed okra with egg",
                "Sauteed spinach and bacon",
                "Sauteed spinach and tuna with butter and soy sauce",
                "Sauteed turnip and deep-fried tofu with mentsuyu sauce",
                "Shrimp and Avocado Salad",
                "Soaked Potherb mustard and fried tofu",
                "Steamed Broccoli and Tuna with Cheese",
                "Stick salad",
                "Stir-fried lettuce and egg",
                "Stir-fried Pork Belly with Bean Sprouts",
                "Stir-fried spinach and eringi with garlic",
                "Stir-fried vegetables",
                "Tofu and baby sardines salad",
                "tomato salad",
                "Tuna lettuce salad",
                "Tuna salad with pea pods",
                "Mason Jar Salad",
                "Pickled Radish and Carrot", "Pickled Radish and Carrot",
                "Tomato, Cucumber and Avocado Salad",
                "Roasted eggplant, tomato and feta cheese",
                "Sauteed Zucchini and Corn with Parmesan",
                "Mediterranean Salad with Tortellini",
                "Caprese Salad with Tomatoes, Basil and Mozzarella",
                "Rainbow Salad with Miso Dressing",
                "Spicy Roasted Eggplant and Cherry Tomatoes",
                "Garden Salad with Herbs and Quinoa",
                "Green Detox Salad",
                "Tuna Salad Stuffed with Avocado",
                "Honey Lemon Vinaigrette Salad with Quinoa",
                "Smoked Salmon and Roasted Beet Salad",
                "Sweet Potato, Chicken and Quinoa Salad",
                "Kale with Lemon Vinaigrette Salad",
                "Tofu and Amaranth Salad",
                "Guacamole",
                "Avocado and Feta Cheese Salsa",
                "Caesar salad with potatoes",
                "Marinated Basil and Mozzarella Cheese",
                "Vegetable waffles",
                "Sauteed soybeans and edamame",
                "Grilled Zucchini Salad",
                "Israeli Salad with Couscous",
                "Tomatoes stuffed with cream cheese",
                "Coconut, Quinoa and Spinach Salad",
                "Avocado and Edamame Salad",
                "Herb, chickpea and spinach salad"
            )
        }

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
                    "キムチの味噌汁",
                    "ズッキーニのクリーミースープ",
                    "ポテトとケールのクリーミースープ",
                    "かぼちゃとココナッツのスープ",
                    "ローストトマトとバジルのクリーミースープ",
                    "スパイスパンプキンスープ",
                    "カリフラワーのスープ",
                    "フレンチオニオンスープ"
                )
            } else {
                mutableSetOf(
                    "Borscht",
                    "Broccoli and Potato Soup",
                    "Cabbage and Egg Soup",
                    "Cauliflower Miso Soup",
                    "Chinese Bean Sprouts Soup",
                    "Chinese green chinese soup",
                    "Clam chowder",
                    "Consomme Soup",
                    "Corn Soup",
                    "Eggplant and myoga miso soup with sesame seeds",
                    "Enoki Mushroom Sanratang",
                    "Kalbi Kuppa",
                    "kelp soup",
                    "Kenchin-jiru",
                    "Lentil Dumpling Soup",
                    "Lettuce in miso soup",
                    "Minestrone",
                    "Miso soup of shiitake mushroom and spinach",
                    "Miso soup with asparagus and bacon",
                    "Miso soup with cabbage and bacon in soy milk",
                    "Miso soup with Chinese cabbage and komatsuna",
                    "Miso soup with eggplant and enoki mushroom",
                    "Miso soup with green pepper",
                    "Miso Soup with Kimchi",
                    "Miso soup with leek and egg",
                    "Miso soup with nameko mushroom and tofu",
                    "Miso soup with potatoes and onions",
                    "Miso Soup with Potatoes and Watercress",
                    "Miso soup with radish and deep-fried tofu",
                    "Miso soup with scallion",
                    "Miso soup with tofu and wakame seaweed",
                    "Onion and Garlic Soup",
                    "Onion gratin soup",
                    "Pork Shabu and Dried Plum Soup",
                    "Pork soup",
                    "Pot-au-feu",
                    "Sawani soup",
                    "Seaweed soup",
                    "Shijimi-jiru",
                    "Soybean and Tomato Soup",
                    "Turnip and Tofu Soup",
                    "Vermicelli soup",
                    "Creamy Zucchini Soup",
                    "Creamy Potato and Kale Soup",
                    "Pumpkin and Coconut Soup", "Pumpkin and Coconut Soup",
                    "Creamy Roasted Tomato and Basil Soup",
                    "Spiced Pumpkin Soup",
                    "Cauliflower Soup",
                    "French Onion Soup"
                )
            }

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
                    "餃子の皮クレープ",
                    "大福",
                    "おしるこ",
                    "あんみつ",
                    "団子",
                    "パンネンクーケン",
                    "ブリガデイロ",
                    "ブロンディ",
                    "焼マシュマロのミルクシェイク",
                    "コカーダ",
                    "アサイーとベリーのグラニテ",
                    "スモア"
                )
            } else {
                mutableSetOf(
                    "apple glace",
                    "Apples",
                    "Apricot bean curd",
                    "banana smoothie",
                    "banana",
                    "Bavarois",
                    "Cafe au lait jelly",
                    "chocolate banana parfait",
                    "chocolate mousse",
                    "coffee jelly",
                    "Frutche",
                    "grapes",
                    "green tea tiramisu",
                    "Gyoza skin crepe",
                    "Ice cream",
                    "Kiwifruit",
                    "melon",
                    "Muffins",
                    "oranges",
                    "pancakes",
                    "Pancakes",
                    "Panna cotta",
                    "peach compote",
                    "Peaches",
                    "pear",
                    "Pound cake",
                    "pudding",
                    "soy milk donuts",
                    "strawberries",
                    "Strawberry brocade",
                    "Tangerine jelly",
                    "Tangerine sorbet",
                    "tangerine",
                    "Tofa",
                    "Yogurt crepes",
                    "yogurt",
                    "Daifuku",
                    "Oshiruko",
                    "Anmitsu",
                    "dango",
                    "Pannen Kuken",
                    "Brigadeiro",
                    "Blondie",
                    "Milkshake with roasted marshmallows",
                    "Coquada",
                    "Acai and berry granite",
                    "S'mores"
                )
            }

            binding.editText8.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText8.hasFocus() -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText8.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText4.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText4.hasFocus() -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText4.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText.hasFocus() -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText10.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText10.hasFocus() -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText10.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText11.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText11.hasFocus() -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText11.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText12.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText12.hasFocus() -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText12.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText13.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText13.hasFocus() -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText13.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText9.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText9.hasFocus() -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText9.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText7.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText7.hasFocus() -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText7.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText14.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText14.hasFocus() -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText14.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText15.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText15.hasFocus() -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText15.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText16.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText16.hasFocus() -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText16.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText17.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText17.hasFocus() -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText17.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText18.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText18.hasFocus() -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText18.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText8n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText8n.hasFocus() -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText8n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText4n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText4n.hasFocus() -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText4n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editTextn.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editTextn.hasFocus() -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editTextn.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText10n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText10n.hasFocus() -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText10n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText11n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText11n.hasFocus() -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText11n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText12n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText12n.hasFocus() -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText12n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText13n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText13n.hasFocus() -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText13n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText9n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText9n.hasFocus() -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText9n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText7n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText7n.hasFocus() -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText7n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText14n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText14n.hasFocus() -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText14n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText15n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText15n.hasFocus() -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText15n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText16n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText16n.hasFocus() -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText16n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText17n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText17n.hasFocus() -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText17n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }
            binding.editText18n.setOnClickListener {
                when {
                    pasteFlag in pasteFlagRange && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && binding.editText18n.hasFocus() -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.clearFocus()
                        binding.webView.loadUrl("https://www.google.com/search?q=${binding.editText18n.text}")
                        binding.webView.visibility = View.VISIBLE
                    }
                }
            }

            binding.editText8.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
                when {
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText8.setTextIsSelectable(true)
                        binding.editText8.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText4.setTextIsSelectable(true)
                        binding.editText4.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText.setTextIsSelectable(true)
                        binding.editText.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText10.setTextIsSelectable(true)
                        binding.editText10.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText11.setTextIsSelectable(true)
                        binding.editText11.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText12.setTextIsSelectable(true)
                        binding.editText12.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText13.setTextIsSelectable(true)
                        binding.editText13.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText9.setTextIsSelectable(true)
                        binding.editText9.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText7.setTextIsSelectable(true)
                        binding.editText7.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText14.setTextIsSelectable(true)
                        binding.editText14.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText15.setTextIsSelectable(true)
                        binding.editText15.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText16.setTextIsSelectable(true)
                        binding.editText16.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText17.setTextIsSelectable(true)
                        binding.editText17.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText18.setTextIsSelectable(true)
                        binding.editText18.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText8n.setTextIsSelectable(true)
                        binding.editText8n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText4n.setTextIsSelectable(true)
                        binding.editText4n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editTextn.setTextIsSelectable(true)
                        binding.editTextn.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText10n.setTextIsSelectable(true)
                        binding.editText10n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText11n.setTextIsSelectable(true)
                        binding.editText11n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText12n.setTextIsSelectable(true)
                        binding.editText12n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText13n.setTextIsSelectable(true)
                        binding.editText13n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText9n.setTextIsSelectable(true)
                        binding.editText9n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText7n.setTextIsSelectable(true)
                        binding.editText7n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText14n.setTextIsSelectable(true)
                        binding.editText14n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText15n.setTextIsSelectable(true)
                        binding.editText15n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText16n.setTextIsSelectable(true)
                        binding.editText16n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText17n.setTextIsSelectable(true)
                        binding.editText17n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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
                    pasteFlag in pasteFlagRange && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        if (binding.listView.isVisible) {
                            binding.listView.visibility = View.INVISIBLE
                        } else {
                            binding.listView.visibility = View.VISIBLE
                        }
                    }
                    pasteFlag == 1 && hasFocus -> {
                        binding.editText18n.setTextIsSelectable(true)
                        binding.editText18n.setText("", TextView.BufferType.NORMAL)
                    }
                    pasteFlag == 2 && hasFocus -> {
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


            optionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ) {
                    if (!optionSpinner.isFocusable) {
                        optionSpinner.isFocusable = true
                        return
                    }
                    when(position){
                        0 -> {
                            selectMenu2()
                        }
                        1 -> {
                            selectMenu3()
                        }
                        2 -> {
                            selectMenu()
                        }
                        3 -> {
                            menuList13()
                        }
                        4 -> {
                            menuList14()
                        }
                        5 -> {
                            menuList12()
                        }
                        6 -> {
                            menuList15()
                            menuList16()
                            menuList17()
                        }
                        7 -> {
                            AlertDialog.Builder(this@MainActivity)
                                .setTitle(R.string.reboot)
                                .setPositiveButton("YES") { _, _ ->
                                    ProcessPhoenix.triggerRebirth(this@MainActivity)
                                }
                                .setNegativeButton("NO") { _, _ ->

                                }
                                .show()
                        }
                        8 -> {
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

            optionSpinner.isFocusable = false


            menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ) {
                    if (!menuSpinner.isFocusable) {
                        menuSpinner.isFocusable = true
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
                            supportActionBar?.title = resources.getString(R.string.Shuffle_order)
                            openKeyboard()
                            pasteFlag = 1
                        }
                        2 -> { menuSwitch = 2
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            supportActionBar?.title = resources.getString(R.string.Find_details)
                            hideKeyboard()
                            openKeyboard()
                            Toast.makeText(applicationContext, (R.string.search), Toast.LENGTH_LONG).show()
                            pasteFlag = 2
                        }
                        3 -> { menuSwitch = 3
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aaaCustomAdapter
                            aaaCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.Main_dish)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Main_dish), Toast.LENGTH_SHORT).show()
                            pasteFlag = 3
                        }
                        4 -> { menuSwitch = 4
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aabCustomAdapter
                            aabCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.side_dish_Salads)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.side_dish_Salads), Toast.LENGTH_SHORT).show()
                            pasteFlag = 4
                        }
                        5 -> { menuSwitch = 5
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aacCustomAdapter
                            aacCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.Soup)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Soup), Toast.LENGTH_SHORT).show()
                            pasteFlag = 5
                        }
                        6 -> { menuSwitch = 6
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aadCustomAdapter
                            aadCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.Fruits_Desserts)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.Fruits_Desserts), Toast.LENGTH_SHORT).show()
                            pasteFlag = 6
                        }
                        7 -> { menuSwitch = 7
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aCustomAdapter
                            aCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.beef)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.beef), Toast.LENGTH_SHORT).show()
                            pasteFlag = 7
                        }
                        8 -> { menuSwitch = 8
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = bCustomAdapter
                            bCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.pork)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.pork), Toast.LENGTH_SHORT).show()
                            pasteFlag = 8
                        }
                        9 -> { menuSwitch = 9
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = cCustomAdapter
                            cCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.chicken)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.chicken), Toast.LENGTH_SHORT).show()
                            pasteFlag = 9
                        }
                        10 -> { menuSwitch = 10
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = dCustomAdapter
                            dCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.ingen)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.ingen), Toast.LENGTH_SHORT).show()
                            pasteFlag = 10
                        }
                        11 -> { menuSwitch = 11
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = eCustomAdapter
                            eCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.okura)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.okura), Toast.LENGTH_SHORT).show()
                            pasteFlag = 11
                        }
                        12 -> { menuSwitch = 12
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = fCustomAdapter
                            fCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.kabu)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.kabu), Toast.LENGTH_SHORT).show()
                            pasteFlag = 12
                        }
                        13 -> { menuSwitch = 13
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = gCustomAdapter
                            gCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.kabocya)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.kabocya), Toast.LENGTH_SHORT).show()
                            pasteFlag = 13
                        }
                        14 -> { menuSwitch = 14
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = hCustomAdapter
                            hCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.kyabetsu)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.kyabetsu), Toast.LENGTH_SHORT).show()
                            pasteFlag = 14
                        }
                        15 -> { menuSwitch = 15
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = iCustomAdapter
                            iCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.kyuuri)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.kyuuri), Toast.LENGTH_SHORT).show()
                            pasteFlag = 15
                        }
                        16 -> { menuSwitch = 16
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = jCustomAdapter
                            jCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.gobou)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.gobou), Toast.LENGTH_SHORT).show()
                            pasteFlag = 16
                        }
                        17 -> { menuSwitch = 17
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = kCustomAdapter
                            kCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.komatsuna)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.komatsuna), Toast.LENGTH_SHORT).show()
                            pasteFlag = 17
                        }
                        18 -> { menuSwitch = 18
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = lCustomAdapter
                            lCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.satsumaimo)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.satsumaimo), Toast.LENGTH_SHORT).show()
                            pasteFlag = 18
                        }
                        19 -> { menuSwitch = 19
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = mCustomAdapter
                            mCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.jyagaimo)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.jyagaimo), Toast.LENGTH_SHORT).show()
                            pasteFlag = 19
                        }
                        20 -> {
                            menuSwitch = 20
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = nCustomAdapter
                            nCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.daikon)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.daikon), Toast.LENGTH_SHORT).show()
                            pasteFlag = 20
                        }
                        21 -> { menuSwitch = 21
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = oCustomAdapter
                            oCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.tamanegi)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.tamanegi), Toast.LENGTH_SHORT).show()
                            pasteFlag = 21
                        }
                        22 -> { menuSwitch = 22
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = pCustomAdapter
                            pCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.chingensai)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.chingensai), Toast.LENGTH_SHORT).show()
                            pasteFlag = 22
                        }
                        23 -> { menuSwitch = 23
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = qCustomAdapter
                            qCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.tomato)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.tomato), Toast.LENGTH_SHORT).show()
                            pasteFlag = 23
                        }
                        24 -> { menuSwitch = 24
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = rCustomAdapter
                            rCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.nasu)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.nasu), Toast.LENGTH_SHORT).show()
                            pasteFlag = 24
                        }
                        25 -> { menuSwitch = 25
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = sCustomAdapter
                            sCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.nira)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.nira), Toast.LENGTH_SHORT).show()
                            pasteFlag = 25
                        }
                        26 -> { menuSwitch = 26
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = tCustomAdapter
                            tCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.ninjin)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.ninjin), Toast.LENGTH_SHORT).show()
                            pasteFlag = 26
                        }
                        27 -> { menuSwitch = 27
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = uCustomAdapter
                            uCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.negi)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.negi), Toast.LENGTH_SHORT).show()
                            pasteFlag = 27
                        }
                        28 -> { menuSwitch = 28
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = vCustomAdapter
                            vCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.hakusai)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.hakusai), Toast.LENGTH_SHORT).show()
                            pasteFlag = 28
                        }
                        29 -> { menuSwitch = 29
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = wCustomAdapter
                            wCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.piman)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.piman), Toast.LENGTH_SHORT).show()
                            pasteFlag = 29
                        }
                        30 -> { menuSwitch = 30
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = xCustomAdapter
                            xCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.burokkori)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.burokkori), Toast.LENGTH_SHORT).show()
                            pasteFlag = 30
                        }
                        31 -> { menuSwitch = 31
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = yCustomAdapter
                            yCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.hourensou)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.hourensou), Toast.LENGTH_SHORT).show()
                            pasteFlag = 31
                        }
                        32 -> { menuSwitch = 32
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = zCustomAdapter
                            zCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.moyashi)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.moyashi), Toast.LENGTH_SHORT).show()
                            pasteFlag = 32
                        }
                        33 -> { menuSwitch = 33
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aaCustomAdapter
                            aaCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.retasu)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.retasu), Toast.LENGTH_SHORT).show()
                            pasteFlag = 33
                        }
                        34 -> { menuSwitch = 34
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = abCustomAdapter
                            abCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.renkon)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.renkon), Toast.LENGTH_SHORT).show()
                            pasteFlag = 34
                        }
                        35 -> { menuSwitch = 35
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = acCustomAdapter
                            acCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.enoki)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.enoki), Toast.LENGTH_SHORT).show()
                            pasteFlag = 35
                        }
                        36 -> { menuSwitch = 36
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = adCustomAdapter
                            adCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.eringi)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.eringi), Toast.LENGTH_SHORT).show()
                            pasteFlag = 36
                        }
                        37 -> { menuSwitch = 37
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aeCustomAdapter
                            aeCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.shiitake)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.shiitake), Toast.LENGTH_SHORT).show()
                            pasteFlag = 37
                        }
                        38 -> { menuSwitch = 38
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = afCustomAdapter
                            afCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.shimeji)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.shimeji), Toast.LENGTH_SHORT).show()
                            pasteFlag = 38
                        }
                        39 -> { menuSwitch = 39
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = agCustomAdapter
                            agCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.tamago)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.tamago), Toast.LENGTH_SHORT).show()
                            pasteFlag = 39
                        }
                        40 -> { menuSwitch = 40
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = ahCustomAdapter
                            ahCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.toufu)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.toufu), Toast.LENGTH_SHORT).show()
                            pasteFlag = 40
                        }
                        41 -> { menuSwitch = 41
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aiCustomAdapter
                            aiCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.aji)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.aji), Toast.LENGTH_SHORT).show()
                            pasteFlag = 41
                        }
                        42 -> { menuSwitch = 42
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = ajCustomAdapter
                            ajCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.iwashi)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.iwashi), Toast.LENGTH_SHORT).show()
                            pasteFlag = 42
                        }
                        43 -> { menuSwitch = 43
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = akCustomAdapter
                            akCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.ebi)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.ebi), Toast.LENGTH_SHORT).show()
                            pasteFlag = 43
                        }
                        44 -> { menuSwitch = 44
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = alCustomAdapter
                            alCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.katsuo)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.katsuo), Toast.LENGTH_SHORT).show()
                            pasteFlag = 44
                        }
                        45 -> { menuSwitch = 45
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = amCustomAdapter
                            amCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.sake)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.sake), Toast.LENGTH_SHORT).show()
                            pasteFlag = 45
                        }
                        46 -> { menuSwitch = 46
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = anCustomAdapter
                            anCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.saba)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.saba), Toast.LENGTH_SHORT).show()
                            pasteFlag = 46
                        }
                        47 -> { menuSwitch = 47
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aoCustomAdapter
                            aoCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.sanma)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.sanma), Toast.LENGTH_SHORT).show()
                            pasteFlag = 47
                        }
                        48 -> { menuSwitch = 48
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = apCustomAdapter
                            apCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.tara)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.tara), Toast.LENGTH_SHORT).show()
                            pasteFlag = 48
                        }
                        49 -> { menuSwitch = 49
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = aqCustomAdapter
                            aqCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.buri)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.buri), Toast.LENGTH_SHORT).show()
                            pasteFlag = 49
                        }
                        50 -> { menuSwitch = 50
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = arCustomAdapter
                            arCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.hokke)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.hokke), Toast.LENGTH_SHORT).show()
                            pasteFlag = 50
                        }
                        51 -> { menuSwitch = 51
                            binding.textView14.requestFocus()
                            binding.textView14.clearFocus()
                            invalidateOptionsMenu()
                            binding.listView.adapter = asCustomAdapter
                            asCustomAdapter.notifyDataSetChanged()
                            supportActionBar?.title = resources.getString(R.string.mekajiki)
                            hideKeyboard()
                            nullKeyboard()
                            Toast.makeText(applicationContext, (R.string.mekajiki), Toast.LENGTH_SHORT).show()
                            pasteFlag = 51
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

            menuSpinner.isFocusable = false

            binding.textView8.editableText.clear()
            binding.textView9.editableText.clear()
            binding.textView10.editableText.clear()
            binding.textView11.editableText.clear()
            binding.textView12.editableText.clear()
            binding.textView13.editableText.clear()
            binding.textView14.editableText.clear()
        }

    private val adSize: AdSize
        get() {
            val display = windowManager.defaultDisplay
            val outMetrics = DisplayMetrics()
            display.getMetrics(outMetrics)

            val density = outMetrics.density
            var adWidthPixels = adViewContainer.width.toFloat()
            if (adWidthPixels == 0.0f) {
                adWidthPixels = outMetrics.widthPixels.toFloat()
            }
            val adWidth = (adWidthPixels / density).toInt()


            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this@MainActivity, adWidth)
        }

    private fun initAdMob() {
        adViewContainer = findViewById(R.id.adView)

        MobileAds.initialize(this) {}
        admobmAdView = AdView(this)
        admobmAdView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        admobmAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                adViewContainer.addView(admobmAdView)
            }
        }
    }

    private fun loadAdMob() {
        val request = AdRequest.Builder().build()
        admobmAdView.adSize = adSize
        admobmAdView.loadAd(request)
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
                binding.editText8.textSize = count2--
                binding.editText8.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText4.hasFocus() -> { binding.editText4.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText4.clearFocus()
                binding.editText4.textSize = count2--
                binding.editText4.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText.hasFocus() -> { binding.editText.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText.clearFocus()
                binding.editText.textSize = count2--
                binding.editText.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText10.hasFocus() -> { binding.editText10.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText10.clearFocus()
                binding.editText10.textSize = count2--
                binding.editText10.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText11.hasFocus() -> { binding.editText11.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText11.clearFocus()
                binding.editText11.textSize = count2--
                binding.editText11.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText12.hasFocus() -> { binding.editText12.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText12.clearFocus()
                binding.editText12.textSize = count2--
                binding.editText12.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText13.hasFocus() -> { binding.editText13.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText13.clearFocus()
                binding.editText13.textSize = count2--
                binding.editText13.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText9.hasFocus() -> { binding.editText9.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText9.clearFocus()
                binding.editText9.textSize = count2--
                binding.editText9.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText7.hasFocus() -> { binding.editText7.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText7.clearFocus()
                binding.editText7.textSize = count2--
                binding.editText7.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText14.hasFocus() -> { binding.editText14.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText14.clearFocus()
                binding.editText14.textSize = count2--
                binding.editText14.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText15.hasFocus() -> { binding.editText15.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText15.clearFocus()
                binding.editText15.textSize = count2--
                binding.editText15.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText16.hasFocus() -> { binding.editText16.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText16.clearFocus()
                binding.editText16.textSize = count2--
                binding.editText16.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText17.hasFocus() -> { binding.editText17.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText17.clearFocus()
                binding.editText17.textSize = count2--
                binding.editText17.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText18.hasFocus() -> { binding.editText18.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText18.clearFocus()
                binding.editText18.textSize = count2--
                binding.editText18.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText8n.hasFocus() -> { binding.editText8n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText8n.clearFocus()
                binding.editText8n.textSize = count2--
                binding.editText8n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText4n.hasFocus() -> { binding.editText4n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText4n.clearFocus()
                binding.editText4n.textSize = count2--
                binding.editText4n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editTextn.hasFocus() -> { binding.editTextn.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editTextn.clearFocus()
                binding.editTextn.textSize = count2--
                binding.editTextn.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText10n.hasFocus() -> { binding.editText10n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText10n.clearFocus()
                binding.editText10n.textSize = count2--
                binding.editText10n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText11n.hasFocus() -> { binding.editText11n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText11n.clearFocus()
                binding.editText11n.textSize = count2--
                binding.editText11n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText12n.hasFocus() -> { binding.editText12n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText12n.clearFocus()
                binding.editText12n.textSize = count2--
                binding.editText12n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText13n.hasFocus() -> { binding.editText13n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText13n.clearFocus()
                binding.editText13n.textSize = count2--
                binding.editText13n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText9n.hasFocus() -> { binding.editText9n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText9n.clearFocus()
                binding.editText9n.textSize = count2--
                binding.editText9n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText7n.hasFocus() -> { binding.editText7n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText7n.clearFocus()
                binding.editText7n.textSize = count2--
                binding.editText7n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText14n.hasFocus() -> { binding.editText14n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText14n.clearFocus()
                binding.editText14n.textSize = count2--
                binding.editText14n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText15n.hasFocus() -> { binding.editText15n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText15n.clearFocus()
                binding.editText15n.textSize = count2--
                binding.editText15n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText16n.hasFocus() -> { binding.editText16n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText16n.clearFocus()
                binding.editText16n.textSize = count2--
                binding.editText16n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText17n.hasFocus() -> { binding.editText17n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText17n.clearFocus()
                binding.editText17n.textSize = count2--
                binding.editText17n.textSize = count2++
                binding.listView.visibility = View.INVISIBLE }
            binding.editText18n.hasFocus() -> { binding.editText18n.setText(cuisine.name, TextView.BufferType.NORMAL)
                binding.editText18n.clearFocus()
                binding.editText18n.textSize = count2--
                binding.editText18n.textSize = count2++
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
            READ_REQUEST_CODE3 -> {
                resultData?.data?.also { uri ->
                    try {
                    val id = uri.toString()
                        .replaceBeforeLast("%2F","")
                        .replace("%2F","")
                        .replace("%E6%9C%88","-")
                        .replace("%E6%97%A5","-")
                        .replace("%E6%99%82","-")
                        .replace("%E5%88%86","-")
                        .replace("%E7%A7%92","-")
                        .replace("-","")
                        .replace(".png","").toLong()
                    binding.editText8n.setText(mRealm.where(Book::class.java).equalTo("id", id + 1000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText8.setText(mRealm.where(Book::class.java).equalTo("id", id + 2000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText4n.setText(mRealm.where(Book::class.java).equalTo("id", id + 3000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText4.setText(mRealm.where(Book::class.java).equalTo("id", id + 4000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText13n.setText(mRealm.where(Book::class.java).equalTo("id", id + 5000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText13.setText(mRealm.where(Book::class.java).equalTo("id", id + 6000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editTextn.setText(mRealm.where(Book::class.java).equalTo("id", id + 7000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText.setText(mRealm.where(Book::class.java).equalTo("id", id + 8000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText11n.setText(mRealm.where(Book::class.java).equalTo("id", id + 9000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText11.setText(mRealm.where(Book::class.java).equalTo("id", id + 10000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText10n.setText(mRealm.where(Book::class.java).equalTo("id", id + 11000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText10.setText(mRealm.where(Book::class.java).equalTo("id", id + 12000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText12n.setText(mRealm.where(Book::class.java).equalTo("id", id + 13000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText12.setText(mRealm.where(Book::class.java).equalTo("id", id + 14000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText9n.setText(mRealm.where(Book::class.java).equalTo("id", id + 15000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText9.setText(mRealm.where(Book::class.java).equalTo("id", id + 16000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText7n.setText(mRealm.where(Book::class.java).equalTo("id", id + 17000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText7.setText(mRealm.where(Book::class.java).equalTo("id", id + 18000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText15n.setText(mRealm.where(Book::class.java).equalTo("id", id + 19000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText15.setText(mRealm.where(Book::class.java).equalTo("id", id + 20000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText16n.setText(mRealm.where(Book::class.java).equalTo("id", id + 21000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText16.setText(mRealm.where(Book::class.java).equalTo("id", id + 22000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText18n.setText(mRealm.where(Book::class.java).equalTo("id", id + 23000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText18.setText(mRealm.where(Book::class.java).equalTo("id", id + 24000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText17n.setText(mRealm.where(Book::class.java).equalTo("id", id + 25000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText17.setText(mRealm.where(Book::class.java).equalTo("id", id + 26000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText14n.setText(mRealm.where(Book::class.java).equalTo("id", id + 27000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.editText14.setText(mRealm.where(Book::class.java).equalTo("id", id + 28000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView.setText(mRealm.where(Book::class.java).equalTo("id", id + 29000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView2.setText(mRealm.where(Book::class.java).equalTo("id", id + 30000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView3.setText(mRealm.where(Book::class.java).equalTo("id", id + 31000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView4.setText(mRealm.where(Book::class.java).equalTo("id", id + 32000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView5.setText(mRealm.where(Book::class.java).equalTo("id", id + 33000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView6.setText(mRealm.where(Book::class.java).equalTo("id", id + 34000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView7.setText(mRealm.where(Book::class.java).equalTo("id", id + 35000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView8.setText(mRealm.where(Book::class.java).equalTo("id", id + 36000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView9.setText(mRealm.where(Book::class.java).equalTo("id", id + 37000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView10.setText(mRealm.where(Book::class.java).equalTo("id", id + 38000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView11.setText(mRealm.where(Book::class.java).equalTo("id", id + 39000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView12.setText(mRealm.where(Book::class.java).equalTo("id", id + 40000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView13.setText(mRealm.where(Book::class.java).equalTo("id", id + 41000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    binding.textView14.setText(mRealm.where(Book::class.java).equalTo("id", id + 42000000000000000).findFirst()?.name, TextView.BufferType.NORMAL)
                    
                    val textSize = count2

                    binding.editText8.textSize = 1.toFloat()
                    binding.editText4.textSize = 1.toFloat()
                    binding.editText13.textSize = 1.toFloat()
                    binding.editText13n.textSize = 1.toFloat()
                    binding.editText9.textSize = 1.toFloat()
                    binding.editText7.textSize = 1.toFloat()
                    binding.editText8n.textSize = 1.toFloat()
                    binding.editText4n.textSize = 1.toFloat()
                    binding.editTextn.textSize = 1.toFloat()
                    binding.editText10n.textSize = 1.toFloat()
                    binding.editText10.textSize = 1.toFloat()
                    binding.editText.textSize = 1.toFloat()
                    binding.editText12n.textSize = 1.toFloat()
                    binding.editText12.textSize = 1.toFloat()
                    binding.editText11n.textSize = 1.toFloat()
                    binding.editText11.textSize = 1.toFloat()
                    binding.editText9n.textSize = 1.toFloat()
                    binding.editText7n.textSize = 1.toFloat()
                    binding.editText15n.textSize = 1.toFloat()
                    binding.editText15.textSize = 1.toFloat()
                    binding.editText17n.textSize = 1.toFloat()
                    binding.editText14n.textSize = 1.toFloat()
                    binding.editText16.textSize = 1.toFloat()
                    binding.editText14.textSize = 1.toFloat()
                    binding.editText18.textSize = 1.toFloat()
                    binding.editText17.textSize = 1.toFloat()
                    binding.editText18n.textSize = 1.toFloat()
                    binding.editText16n.textSize = 1.toFloat()
                    binding.textView.textSize = 1.toFloat()
                    binding.textView2.textSize = 1.toFloat()
                    binding.textView3.textSize = 1.toFloat()
                    binding.textView4.textSize = 1.toFloat()
                    binding.textView5.textSize = 1.toFloat()
                    binding.textView6.textSize = 1.toFloat()
                    binding.textView7.textSize = 1.toFloat()
                    binding.textView8.textSize = 1.toFloat()
                    binding.textView9.textSize = 1.toFloat()
                    binding.textView10.textSize = 1.toFloat()
                    binding.textView11.textSize = 1.toFloat()
                    binding.textView12.textSize = 1.toFloat()
                    binding.textView13.textSize = 1.toFloat()
                    binding.textView14.textSize = 1.toFloat()

                    binding.editText8.textSize = textSize
                    binding.editText4.textSize = textSize
                    binding.editText13.textSize = textSize
                    binding.editText13n.textSize = textSize
                    binding.editText9.textSize = textSize
                    binding.editText7.textSize = textSize
                    binding.editText8n.textSize = textSize
                    binding.editText4n.textSize = textSize
                    binding.editTextn.textSize = textSize
                    binding.editText10n.textSize = textSize
                    binding.editText10.textSize = textSize
                    binding.editText.textSize = textSize
                    binding.editText12n.textSize = textSize
                    binding.editText12.textSize = textSize
                    binding.editText11n.textSize = textSize
                    binding.editText11.textSize = textSize
                    binding.editText9n.textSize = textSize
                    binding.editText7n.textSize = textSize
                    binding.editText15n.textSize = textSize
                    binding.editText15.textSize = textSize
                    binding.editText17n.textSize = textSize
                    binding.editText14n.textSize = textSize
                    binding.editText16.textSize = textSize
                    binding.editText14.textSize = textSize
                    binding.editText18.textSize = textSize
                    binding.editText17.textSize = textSize
                    binding.editText18n.textSize = textSize
                    binding.editText16n.textSize = textSize
                    binding.textView.textSize = textSize
                    binding.textView2.textSize = textSize
                    binding.textView3.textSize = textSize
                    binding.textView4.textSize = textSize
                    binding.textView5.textSize = textSize
                    binding.textView6.textSize = textSize
                    binding.textView7.textSize = textSize
                    binding.textView8.textSize = textSize
                    binding.textView9.textSize = textSize
                    binding.textView10.textSize = textSize
                    binding.textView11.textSize = textSize
                    binding.textView12.textSize = textSize
                    binding.textView13.textSize = textSize
                    binding.textView14.textSize = textSize
                } catch (e: Exception) {
                        Toast.makeText(applicationContext, R.string.error, Toast.LENGTH_LONG).show()
                    }
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


    @SuppressLint("SimpleDateFormat")
    private fun create() {
        mRealm.executeTransaction {
            val id: Long = if (locale == Locale.JAPAN) {
                SimpleDateFormat("MMddHHmmss").format(Date()).toLong()
            } else {
                SimpleDateFormat("MMddyyyyhhmmss", Locale.US).format(Date()).toLong()
            }
            val book = mRealm.createObject<Book>(primaryKeyValue = id + 1000000000000000)
            book.name = binding.editText8n.text.toString()
            mRealm.copyToRealm(book)
            val book2 = mRealm.createObject<Book>(primaryKeyValue = id + 2000000000000000)
            book2.name = binding.editText8.text.toString()
            mRealm.copyToRealm(book2)
            val book3 = mRealm.createObject<Book>(primaryKeyValue = id + 3000000000000000)
            book3.name = binding.editText4n.text.toString()
            mRealm.copyToRealm(book3)
            val book4 = mRealm.createObject<Book>(primaryKeyValue = id + 4000000000000000)
            book4.name = binding.editText4.text.toString()
            mRealm.copyToRealm(book4)
            val book5 = mRealm.createObject<Book>(primaryKeyValue = id + 5000000000000000)
            book5.name = binding.editText13n.text.toString()
            mRealm.copyToRealm(book5)
            val book6 = mRealm.createObject<Book>(primaryKeyValue = id + 6000000000000000)
            book6.name = binding.editText13.text.toString()
            mRealm.copyToRealm(book6)
            val book7 = mRealm.createObject<Book>(primaryKeyValue = id + 7000000000000000)
            book7.name = binding.editTextn.text.toString()
            mRealm.copyToRealm(book7)
            val book8 = mRealm.createObject<Book>(primaryKeyValue = id + 8000000000000000)
            book8.name = binding.editText.text.toString()
            mRealm.copyToRealm(book8)
            val book9 = mRealm.createObject<Book>(primaryKeyValue = id + 9000000000000000)
            book9.name = binding.editText11n.text.toString()
            mRealm.copyToRealm(book9)
            val book10 = mRealm.createObject<Book>(primaryKeyValue = id + 10000000000000000)
            book10.name = binding.editText11.text.toString()
            mRealm.copyToRealm(book10)
            val book11 = mRealm.createObject<Book>(primaryKeyValue = id + 11000000000000000)
            book11.name = binding.editText10n.text.toString()
            mRealm.copyToRealm(book11)
            val book12 = mRealm.createObject<Book>(primaryKeyValue = id + 12000000000000000)
            book12.name = binding.editText10.text.toString()
            mRealm.copyToRealm(book12)
            val book13 = mRealm.createObject<Book>(primaryKeyValue = id + 13000000000000000)
            book13.name = binding.editText12n.text.toString()
            mRealm.copyToRealm(book13)
            val book14 = mRealm.createObject<Book>(primaryKeyValue = id + 14000000000000000)
            book14.name = binding.editText12.text.toString()
            mRealm.copyToRealm(book14)
            val book15 = mRealm.createObject<Book>(primaryKeyValue = id + 15000000000000000)
            book15.name = binding.editText9n.text.toString()
            mRealm.copyToRealm(book15)
            val book16 = mRealm.createObject<Book>(primaryKeyValue = id + 16000000000000000)
            book16.name = binding.editText9.text.toString()
            mRealm.copyToRealm(book16)
            val book17 = mRealm.createObject<Book>(primaryKeyValue = id + 17000000000000000)
            book17.name = binding.editText7n.text.toString()
            mRealm.copyToRealm(book17)
            val book18 = mRealm.createObject<Book>(primaryKeyValue = id + 18000000000000000)
            book18.name = binding.editText7.text.toString()
            mRealm.copyToRealm(book18)
            val book19 = mRealm.createObject<Book>(primaryKeyValue = id + 19000000000000000)
            book19.name = binding.editText15n.text.toString()
            mRealm.copyToRealm(book19)
            val book20 = mRealm.createObject<Book>(primaryKeyValue = id + 20000000000000000)
            book20.name = binding.editText15.text.toString()
            mRealm.copyToRealm(book20)
            val book21 = mRealm.createObject<Book>(primaryKeyValue = id + 21000000000000000)
            book21.name = binding.editText16n.text.toString()
            mRealm.copyToRealm(book21)
            val book22 = mRealm.createObject<Book>(primaryKeyValue = id + 22000000000000000)
            book22.name = binding.editText16.text.toString()
            mRealm.copyToRealm(book22)
            val book23 = mRealm.createObject<Book>(primaryKeyValue = id + 23000000000000000)
            book23.name = binding.editText18n.text.toString()
            mRealm.copyToRealm(book23)
            val book24 = mRealm.createObject<Book>(primaryKeyValue = id + 24000000000000000)
            book24.name = binding.editText18.text.toString()
            mRealm.copyToRealm(book24)
            val book25 = mRealm.createObject<Book>(primaryKeyValue = id + 25000000000000000)
            book25.name = binding.editText17n.text.toString()
            mRealm.copyToRealm(book25)
            val book26 = mRealm.createObject<Book>(primaryKeyValue = id + 26000000000000000)
            book26.name = binding.editText17.text.toString()
            mRealm.copyToRealm(book26)
            val book27 = mRealm.createObject<Book>(primaryKeyValue = id + 27000000000000000)
            book27.name = binding.editText14n.text.toString()
            mRealm.copyToRealm(book27)
            val book28 = mRealm.createObject<Book>(primaryKeyValue = id + 28000000000000000)
            book28.name = binding.editText14.text.toString()
            mRealm.copyToRealm(book28)
            val book29 = mRealm.createObject<Book>(primaryKeyValue = id + 29000000000000000)
            book29.name = binding.textView.text.toString()
            mRealm.copyToRealm(book29)
            val book30 = mRealm.createObject<Book>(primaryKeyValue = id + 30000000000000000)
            book30.name = binding.textView2.text.toString()
            mRealm.copyToRealm(book30)
            val book31 = mRealm.createObject<Book>(primaryKeyValue = id + 31000000000000000)
            book31.name = binding.textView3.text.toString()
            mRealm.copyToRealm(book31)
            val book32 = mRealm.createObject<Book>(primaryKeyValue = id + 32000000000000000)
            book32.name = binding.textView4.text.toString()
            mRealm.copyToRealm(book32)
            val book33 = mRealm.createObject<Book>(primaryKeyValue = id + 33000000000000000)
            book33.name = binding.textView5.text.toString()
            mRealm.copyToRealm(book33)
            val book34 = mRealm.createObject<Book>(primaryKeyValue = id + 34000000000000000)
            book34.name = binding.textView6.text.toString()
            mRealm.copyToRealm(book34)
            val book35 = mRealm.createObject<Book>(primaryKeyValue = id + 35000000000000000)
            book35.name = binding.textView7.text.toString()
            mRealm.copyToRealm(book35)
            val book36 = mRealm.createObject<Book>(primaryKeyValue = id + 36000000000000000)
            book36.name = binding.textView8.text.toString()
            mRealm.copyToRealm(book36)
            val book37 = mRealm.createObject<Book>(primaryKeyValue = id + 37000000000000000)
            book37.name = binding.textView9.text.toString()
            mRealm.copyToRealm(book37)
            val book38 = mRealm.createObject<Book>(primaryKeyValue = id + 38000000000000000)
            book38.name = binding.textView10.text.toString()
            mRealm.copyToRealm(book38)
            val book39 = mRealm.createObject<Book>(primaryKeyValue = id + 39000000000000000)
            book39.name = binding.textView11.text.toString()
            mRealm.copyToRealm(book39)
            val book40 = mRealm.createObject<Book>(primaryKeyValue = id + 40000000000000000)
            book40.name = binding.textView12.text.toString()
            mRealm.copyToRealm(book40)
            val book41 = mRealm.createObject<Book>(primaryKeyValue = id + 41000000000000000)
            book41.name = binding.textView13.text.toString()
            mRealm.copyToRealm(book41)
            val book42 = mRealm.createObject<Book>(primaryKeyValue = id + 42000000000000000)
            book42.name = binding.textView14.text.toString()
            mRealm.copyToRealm(book42)
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
                menuLamp.setIcon(R.drawable.shuffle_w)
            }
            2 -> {
                menuLamp.setIcon(R.drawable.search_w)
            }
            3 -> {
                menuLamp.setIcon(R.drawable.dinner_w)
            }
            4 -> {
                menuLamp.setIcon(R.drawable.salad_w)
            }
            5 -> {
                menuLamp.setIcon(R.drawable.soup_w)
            }
            6 -> {
                menuLamp.setIcon(R.drawable.dessert_w)
            }
            7 -> {
                menuLamp.setIcon(R.drawable.beef_w)
            }
            8 -> {
                menuLamp.setIcon(R.drawable.pork_w)
            }
            9 -> {
                menuLamp.setIcon(R.drawable.chiken_w)
            }
            10 -> {
                menuLamp.setIcon(R.drawable.ingen_w)
            }
            11 -> {
                menuLamp.setIcon(R.drawable.okura_w)
            }
            12 -> {
                menuLamp.setIcon(R.drawable.kabu_w)
            }
            13 -> {
                menuLamp.setIcon(R.drawable.kabocya_w)
            }
            14 -> {
                menuLamp.setIcon(R.drawable.kyabetu_w)
            }
            15 -> {
                menuLamp.setIcon(R.drawable.kyuuri_w)
            }
            16 -> {
                menuLamp.setIcon(R.drawable.gobou_w)
            }
            17 -> {
                menuLamp.setIcon(R.drawable.komatsuna_w)
            }
            18 -> {
                menuLamp.setIcon(R.drawable.satsumaimo_w)
            }
            19 -> {
                menuLamp.setIcon(R.drawable.jyagaimo_w)
            }
            20 -> {
                menuLamp.setIcon(R.drawable.daikon_w)
            }
            21 -> {
                menuLamp.setIcon(R.drawable.tamanegi_w)
            }
            22 -> {
                menuLamp.setIcon(R.drawable.chingensai_w)
            }
            23 -> {
                menuLamp.setIcon(R.drawable.tomato_w)
            }
            24 -> {
                menuLamp.setIcon(R.drawable.nasu_w)
            }
            25 -> {
                menuLamp.setIcon(R.drawable.nira_w)
            }
            26 -> {
                menuLamp.setIcon(R.drawable.carrot_w)
            }
            27 -> {
                menuLamp.setIcon(R.drawable.negi_w)
            }
            28 -> {
                menuLamp.setIcon(R.drawable.hakusai_w)
            }
            29 -> {
                menuLamp.setIcon(R.drawable.piman_w)
            }
            30 -> {
                menuLamp.setIcon(R.drawable.burokkori_w)
            }
            31 -> {
                menuLamp.setIcon(R.drawable.hourensou_w)
            }
            32 -> {
                menuLamp.setIcon(R.drawable.moyashi_w)
            }
            33 -> {
                menuLamp.setIcon(R.drawable.retasu_w)
            }
            34 -> {
                menuLamp.setIcon(R.drawable.renkon_w)
            }
            35 -> {
                menuLamp.setIcon(R.drawable.enoki_w)
            }
            36 -> {
                menuLamp.setIcon(R.drawable.eringi_w)
            }
            37 -> {
                menuLamp.setIcon(R.drawable.siitake_w)
            }
            38 -> {
                menuLamp.setIcon(R.drawable.shimeji_w)
            }
            39 -> {
                menuLamp.setIcon(R.drawable.tamago_w)
            }
            40 -> {
                menuLamp.setIcon(R.drawable.toufu_w)
            }
            41 -> {
                menuLamp.setIcon(R.drawable.aji_w)
            }
            42 -> {
                menuLamp.setIcon(R.drawable.iwashi_w)
            }
            43 -> {
                menuLamp.setIcon(R.drawable.ebi_w)
            }
            44 -> {
                menuLamp.setIcon(R.drawable.katsuo_w)
            }
            45 -> {
                menuLamp.setIcon(R.drawable.sake_w)
            }
            46 -> {
                menuLamp.setIcon(R.drawable.saba_w)
            }
            47 -> {
                menuLamp.setIcon(R.drawable.sanma_w)
            }
            48 -> {
                menuLamp.setIcon(R.drawable.tara_w)
            }
            49 -> {
                menuLamp.setIcon(R.drawable.buri_w)
            }
            50 -> {
                menuLamp.setIcon(R.drawable.hokke_w)
            }
            51-> {
                menuLamp.setIcon(R.drawable.mekajiki_w)
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
                handler.postDelayed( {
                    create()
                    getBitmapFromView(binding.allView)
                                     }, 50)
                handler.postDelayed( { binding.adView.visibility = View.VISIBLE }, 100)
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