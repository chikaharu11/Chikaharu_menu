package com.example.b

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_baby.*

class BabyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baby)

        val cuisines = arrayListOf(

            "ハンバーグ　　　　[ハンバーグ]\n\n",
            "ギョーザ　　　　　[冷凍ギョーザ]\n\n",
            "焼きウインナー　　[ウインナー]\n\n",
            "肉野菜炒め　　　　[豚こま肉、\n野菜炒め用野菜]\n\n",
            "唐揚げ　　　　　　[鳥もも肉、\n唐揚げ粉]\n\n",
            "豚汁　　　　　　　[豚こま肉、\n豚汁の素]\n\n",
            "マーボー豆腐　　　[豆腐、\nマーボー豆腐の素]\n\n",
            "マーボー春雨　　　[マーボー春雨]\n\n",
            "人参しりしり　　　[ニンジン、\n卵、\nシーチキン]\n\n",
            "煮付け　　　　　　[油ふ、\nニンジン、\nこんにゃく、\nさつま揚げ、\nキャベツ]\n\n",
            "焼きそば　　　　　[豚こま肉、\n野菜炒め用野菜、\n焼きそばの麺、\n天かす]\n\n",
            "焼きワンタン　　　[ワンタン、\nごま油]\n\n",
            "チャーハン　　　　[焼き豚、\n卵]\n\n",
            "豚生姜焼き　　　　[豚ロース、\n生姜焼きの素]\n\n",
            "エビフライ　　　　[冷凍エビフライ]\n\n",
            "キノコ炒め　　　　[しめじ、\nエリンギ、\n豚こま肉、\nキノコ炒めの素]\n\n",
            "ビーフン炒め　　　[冷凍ビーフン]\n\n",
            "チキングラタン　　[鳥もも肉、\nタマネギ、\nとろけるチーズ、\n粉チーズ、\nグラタンの素、\n牛乳]\n\n",
            "ミートグラタン　　[合い挽き肉、\nタマネギ、\n牛乳、\nとろけるチーズ、\n粉チーズ、\nグラタンの素]\n\n",
            "シチュー　　　　　[鶏もも、\n人参、\nジャガイモ、\nタマネギ、\n牛乳、\nシチューの素]\n\n",
            "ビーフシチュー　　[シチュー用牛肉、\nジャガイモ、\nタマネギ、\nニンジン、\nビーフシチューの素]\n\n",
            "うどん　　　　　　[うどん玉、\nネギ、\nかき揚げ天ぷら、\nかまぼこ、\nめんつゆ]\n\n",
            "パスタ　　　　　　[パスタ、\nパスタソース]\n\n",
            "鯖マヨ　　　　　　[鯖缶]\n\n",
            "ジャガチーズ焼き　[ジャガイモ、\n合い挽き肉、\nとろけるチーズ、\nチーズ焼きの素]\n\n",
            "ハムカツ　　　　　[ハムカツ]\n\n",
            "サイコロステーキ　[サイコロステーキ]\n\n",
            "チキンステーキ　　[チキンステーキ]\n\n",
            "オムライス　　　　[ハム、\nミックスベジタブル、\n卵]\n\n",
            "肉じゃが㋬　　　　[ジャガイモ、\n豚or牛こま肉、\nタマネギ、\nニンジン]\n\n",
            "牛丼　　　　　　　[牛薄切り肉、\nタマネギ、\n牛丼のタレ]\n\n",
            "豚バラ白菜㋬　　　[和風だしorコンソメ、\n白菜、\n豚バラ肉]\n\n",
            "カレー㋬　　　　　[カレー用牛肉or豚肉、\nジャガイモ、\n人参、\nタマネギ、\nカレールー]\n\n",
            "八宝菜　　　　　　\n\n",
            "ラーメン　　　　　\n\n",
            "チーズ餃子　　　　\n\n",
            "焼きハム　　　　　\n\n",
            "けんちん汁㋬　　　\n\n",
            "ラザニア　　　　　\n\n",
            "サンドイッチ　　　\n\n",
            "冷やし中華　　　　\n\n",
            "マーボー茄子　　　\n\n",
            "あんかけ卵　　　　\n\n"
        )

        val clumsiness = arrayListOf(

            "生野菜　　　　　　　[生野菜]\n\n",
            "豆腐　　　　　　　　[絹ごし豆腐]\n\n",
            "パウチサラダ　　　　[パウチサラダ]\n\n",
            "レンジ野菜　　　　　[レンジ野菜]\n\n",
            "シューマイ　　　　　[シューマイ]\n\n",
            "きゅうり酢和え　　　[玉ふ、\nきゅうり]\n\n",
            "ツナレタスサラダ　　[ツナ缶、\nきゅうり、\nレタス]\n\n",
            "ショーロンポー　　　[ショーロンポー]\n\n",
            "こんぶキャベツ　　　[キャベツ、\n塩こんぶ]\n\n",
            "レンジ豚もやし　　　[豚ばら肉、\nもやし]\n\n",
            "のりきゅうり　　　　[海苔、\nきゅうり]\n\n",
            "茶碗むし　　　　　　[茶碗むし]\n\n",
            "レンジコロッケ　　　[冷凍コロッケ]\n\n",
            "じゃがブロッコリー　[ブロッコリー、\nじゃがいも]\n\n",
            "スティックサラダ　　[にんじん、\n大根、\nきゅうり]\n\n",
            "味噌田楽　　　　　　[味噌田楽]\n\n",
            "かぼちゃチーズ　　　[かぼちゃ、\nスライスチーズ]\n\n",
            "マカロニサラダ　　　[マカロニ、\nカニカマ、\nハム、\nツナコーン]\n\n",
            "フライドポテト　　　[フライドポテト]\n\n",
            "大学いも　　　　　　[さつまいも、\n大学いもの素、\nごま]\n\n",
            "卵豆腐　　　　　　　\n\n",
            "レンジ青椒肉絲　　　\n\n",
            "春巻　　　　　　　　\n\n",
            "レンジ唐揚げ　　　　\n\n",
            "コーンスープ　　　　\n\n"
        )

        val lunches = arrayListOf(

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

        val baboon = arrayListOf(

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

        val listView = ListView(this)

        val arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, cuisines.sorted())

        val listView2 = ListView(this)

        val arrayAdapter2 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, clumsiness.sorted())

        val listView3 = ListView(this)

        val arrayAdapter3 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, lunches.sorted())

        val listView4 = ListView(this)

        val arrayAdapter4 = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, baboon.sorted())

        listView.adapter = arrayAdapter
        listView2.adapter = arrayAdapter2
        listView3.adapter = arrayAdapter3
        listView4.adapter = arrayAdapter4

        mainButton.setOnClickListener {

            finish()
        }

        button.setOnClickListener {

            setContentView(listView)

        }

        button4.setOnClickListener {

            setContentView(listView2)

        }

        button3.setOnClickListener {

            setContentView(listView3)

        }

        button5.setOnClickListener {

            setContentView(listView4)

        }
    }
}