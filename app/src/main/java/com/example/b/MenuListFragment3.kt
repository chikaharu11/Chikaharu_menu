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

            """
ハンバーグ　　　　[ハンバーグ]
""",
            """
ギョーザ　　　　　[冷凍ギョーザ]
""",
            """
焼きウインナー　　[ウインナー]
""",
            """
肉野菜炒め　　　　[豚こま肉]
　　　　　　　　　[野菜炒め用野菜]
""",
            """
唐揚げ　　　　　　[鳥もも肉]
　　　　　　　　　[唐揚げ粉]
""",
            """
豚汁　　　　　　　[豚こま肉]
　　　　　　　　　[豚汁の素]
""",
            """
マーボー豆腐　　　[豆腐]
　　　　　　　　　[マーボー豆腐の素]
""",
            """
マーボー春雨　　　[マーボー春雨]
""",
            """
人参しりしり　　　[ニンジン]
　　　　　　　　　[卵]
　　　　　　　　　[シーチキン]
""",
            """
煮付け　　　　　　[油ふ]
　　　　　　　　　[ニンジン]
　　　　　　　　　[こんにゃく]
　　　　　　　　　[さつま揚げ]
　　　　　　　　　[キャベツ]
""",
            """
焼きそば　　　　　[豚こま肉]
　　　　　　　　　[野菜炒め用野菜]
　　　　　　　　　[焼きそばの麺]
　　　　　　　　　[天かす]
""",
            """
焼きワンタン　　　[ワンタン]
　　　　　　　　　[ごま油]
""",
            """
チャーハン　　　　[焼き豚]
　　　　　　　　　[卵]
""",
            """
豚生姜焼き　　　　[豚ロース]
　　　　　　　　　[生姜焼きの素]
""",
            """
エビフライ　　　　[冷凍エビフライ]
""",
            """
キノコ炒め　　　　[しめじ]
　　　　　　　　　[エリンギ]
　　　　　　　　　[豚こま肉]
　　　　　　　　　[キノコ炒めの素]
""",
            """
ビーフン炒め　　　[冷凍ビーフン]
""",
            """
チキングラタン　　[鳥もも肉]
　　　　　　　　　[タマネギ]
　　　　　　　　　[とろけるチーズ]
　　　　　　　　　[粉チーズ]
　　　　　　　　　[グラタンの素]
　　　　　　　　　[牛乳]
""",
            """
ミートグラタン　　[合い挽き肉]
　　　　　　　　　[タマネギ]
　　　　　　　　　[牛乳]
　　　　　　　　　[とろけるチーズ]
　　　　　　　　　[粉チーズ]
　　　　　　　　　[グラタンの素]
""",
            """
シチュー　　　　　[鶏もも]
　　　　　　　　　[人参]
　　　　　　　　　[ジャガイモ]
　　　　　　　　　[タマネギ]
　　　　　　　　　[牛乳]
　　　　　　　　　[シチューの素]
""",
            """
ビーフシチュー　　[シチュー用牛肉]
　　　　　　　　　[ジャガイモ]
　　　　　　　　　[タマネギ]
　　　　　　　　　[ニンジン]
　　　　　　　　　[ビーフシチューの素]
""",
            """
うどん　　　　　　[うどん玉]
　　　　　　　　　[ネギ]
　　　　　　　　　[かき揚げ天ぷら]
　　　　　　　　　[かまぼこ]
　　　　　　　　　[めんつゆ]
""",
            """
パスタ　　　　　　[パスタ]
　　　　　　　　　[パスタソース]
""",
            """
鯖マヨ　　　　　　[鯖缶]
""",
            """
ジャガチーズ焼き　[ジャガイモ]
　　　　　　　　　[合い挽き肉]
　　　　　　　　　[とろけるチーズ]
　　　　　　　　　[チーズ焼きの素]
""",
            """
ハムカツ　　　　　[ハムカツ]
""",
            """
サイコロステーキ　[サイコロステーキ]
""",
            """
チキンステーキ　　[チキンステーキ]
""",
            """
オムライス　　　　[ハム]
　　　　　　　　　[ミックスベジタブル]
　　　　　　　　　[卵]
""",
            """
肉じゃが㋬　　　　[ジャガイモ]
　　　　　　　　　[豚or牛こま肉]
　　　　　　　　　[タマネギ]
　　　　　　　　　[ニンジン]
""",
            """
牛丼　　　　　　　[牛薄切り肉]
　　　　　　　　　[タマネギ]
　　　　　　　　　[牛丼のタレ]
""",
            """
豚バラ白菜㋬　　　[和風だしorコンソメ]
　　　　　　　　　[白菜]
　　　　　　　　　[豚バラ肉]
""",
            """
カレー㋬　　　　　[カレー用牛肉or豚肉]
　　　　　　　　　[ジャガイモ]
　　　　　　　　　[人参]
　　　　　　　　　[タマネギ]
　　　　　　　　　[カレールー]
""",
            """
八宝菜　　　　　　[]
""",
            """
ラーメン　　　　　[]
""",
            """
チーズ餃子　　　　[]
""",
            """
焼きハム　　　　　[]
""",
            """
けんちん汁㋬　　　[]
""",
            """
ラザニア　　　　　[]
""",
            """
サンドイッチ　　　[]
""",
            """
冷やし中華　　　　[]
""",
            """
マーボー茄子　　　[]
""",
            """
あんかけ卵　　　　[]
"""
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