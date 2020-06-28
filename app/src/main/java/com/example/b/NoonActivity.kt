package com.example.b

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_noon.*

class NoonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noon)

        val lunches = arrayListOf(

            //"\n\n",

            "　　　　　　　　　\n\n",
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

        val spinnerItems3 = lunches.sorted()

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

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val baboon = arrayListOf(

            //"\n\n",

            "　　　　　　　　　\n\n",
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

        val spinnerItems4 = baboon.sorted()

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
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        button2.setOnClickListener{

            val intent = Intent(application, BabyActivity::class.java)
            startActivity(intent)
        }

        babyButton2.setOnClickListener {

            finish()
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
}

/*
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
 */