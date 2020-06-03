package com.example.b

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_noon.*

class NoonActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_MENU1n = "com.example.b.MENU1n"
        const val EXTRA_MENU2n = "com.example.b.MENU2n"
        const val EXTRA_MENU3n = "com.example.b.MENU3n"
        const val EXTRA_MENU4n = "com.example.b.MENU4n"
        const val EXTRA_MENU5n = "com.example.b.MENU5n"
        const val EXTRA_MENU6n = "com.example.b.MENU6n"
        const val EXTRA_MENU7n = "com.example.b.MENU7n"

        const val EXTRA_MENU01n = "com.example.b.MENU01n"
        const val EXTRA_MENU02n = "com.example.b.MENU02n"
        const val EXTRA_MENU03n = "com.example.b.MENU03n"
        const val EXTRA_MENU04n = "com.example.b.MENU04n"
        const val EXTRA_MENU05n = "com.example.b.MENU05n"
        const val EXTRA_MENU06n = "com.example.b.MENU06n"
        const val EXTRA_MENU07n = "com.example.b.MENU07n"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noon)

        class Lunch(val main: String, val ingre: String)

        val lunches = arrayListOf(

            //Lunch("\n", "\n"),

            Lunch("　　　　　　　　　　", "\n\n"),
            Lunch("皿うどん　　　　　　", "[皿うどん、\n豚バラ肉、\n野菜炒め用野菜]\n\n"),
            Lunch("ギョーザ　　　　　　", "[冷凍ギョーザ]\n\n"),
            Lunch("焼きそば　　　　　　", "[豚こま肉、\n野菜炒め用野菜、\n焼きそばの麺]\n\n"),
            Lunch("マーボー春雨　　　　", "[マーボー春雨]\n\n"),
            Lunch("マーボー豆腐　　　　", "[マーボー豆腐]\n\n"),
            Lunch("沖縄そば　　　　　　", "[かまぼこ、\nネギ]\n\n"),
            Lunch("冷凍パスタ　　　　　", "[冷凍パスタ]\n\n"),
            Lunch("すき焼き豆腐　　　　", "[豆腐、\nすき焼き豆腐の素]\n\n"),
            Lunch("レトルトカレー　　　", "[レトルトカレー]\n\n"),
            Lunch("豚しょうが焼き　　　", "[豚ロース肉、\n豚しょうが焼きの素]\n\n"),
            Lunch("ハンバーグ　　　　　", "[ハンバーグ]\n\n")
        )

        val intent = Intent(applicationContext, BabyActivity::class.java)

        val spinnerItems3 = lunches.map { it.main + it.ingre }

        val adapter3 = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems3)

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1n.adapter = adapter3
        spinner2n.adapter = adapter3
        spinner3n.adapter = adapter3
        spinner4n.adapter = adapter3
        spinner5n.adapter = adapter3
        spinner6n.adapter = adapter3
        spinner7n.adapter = adapter3

        spinner1n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText8n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU1n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner4n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText4n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU2n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner3n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editTextn.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU3n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner7n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText10n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU4n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner6n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText11n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU5n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner2n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText12n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU6n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner5n.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText13n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU7n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        class Babyhood(val main: String, val ingre: String)

        val baboon = arrayListOf(

            //Babyhood("\n", "\n"),

            Babyhood("　　　　　　　　　", "\n\n"),
            Babyhood("角切りにんじん　　", "[にんじん]\n"),
            Babyhood("ブロックかぼちゃ　", "[かぼちゃ]\n"),
            Babyhood("牛ひき肉　　　　　", "[牛ひき肉]\n"),
            Babyhood("豚ひき肉　　　　　", "[豚ひき肉]\n"),
            Babyhood("野菜ミックス　　　", "[野菜ミックス]\n"),
            Babyhood("ゆでしらす　　　　", "[しらす]\n"),
            Babyhood("ゆでブロッコリー　", "[ブロッコリー]\n"),
            Babyhood("ウインナー　　　　", "[子供用ウインナー]\n"),
            Babyhood("なす煮　　　　　　", "[ナス、\n和風だし]\n"),
            Babyhood("人参キャベツ千切り", "[にんじん、\nキャベツ]\n"),
            Babyhood("とり団子　　　　　", "[鳥ひき肉]\n"),
            Babyhood("とりささみ　　　　", "[とりささみ]\n")
        )

        val spinnerItems4 = baboon.map { it.main + it.ingre }

        val adapter4 = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, spinnerItems4)

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerAn.adapter = adapter4
        spinnerBn.adapter = adapter4
        spinnerCn.adapter = adapter4
        spinnerDn.adapter = adapter4
        spinnerEn.adapter = adapter4
        spinnerFn.adapter = adapter4
        spinnerGn.adapter = adapter4

        spinnerBn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText9n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU01n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerFn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText7n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU02n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerGn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText14n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU03n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerDn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText15n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU04n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerEn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText16n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU05n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerCn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText17n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU06n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerAn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                editText18n.setText(item.take(9).replace("　", ""), TextView.BufferType.NORMAL)
                intent.putExtra(EXTRA_MENU07n, item.drop(9).replace("[", "").replace("]", "").replace("、", ""))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        babyButton2.setOnClickListener {
            val intent3 = Intent(application, MainActivity::class.java)
            startActivity(intent3)
        }
    }
}