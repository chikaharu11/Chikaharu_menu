package com.example.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class MenuListFragmentActivity3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainFrame = inflater.inflate(R.layout.menufragment_list3,container,false)
        val cuisines2 = arrayListOf(

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

        val listView3 = mainFrame.findViewById(R.id.list_view3) as ListView

        val arrayAdapter3 = this.context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1, cuisines2.sorted()
            )
        }

        listView3.adapter = arrayAdapter3

        return mainFrame
    }
}