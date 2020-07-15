package com.example.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class MenuListFragmentActivity4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainFrame = inflater.inflate(R.layout.menufragment_list4,container,false)
        val clumsiness2 = arrayListOf(

            """
生野菜　　　　　　　[生野菜]
""",
            """
豆腐　　　　　　　　[絹ごし豆腐]
""",
            """
パウチサラダ　　　　[パウチサラダ]
""",
            """
レンジ野菜　　　　　[レンジ野菜]
""",
            """
シューマイ　　　　　[シューマイ]
""",
            """
きゅうり酢和え　　　[玉ふ]
　　　　　　　　　　[きゅうり]
""",
            """
ツナレタスサラダ　　[ツナ缶]
　　　　　　　　　　[きゅうり]
　　　　　　　　　　[レタス]
""",
            """
ショーロンポー　　　[ショーロンポー]
""",
            """
こんぶキャベツ　　　[キャベツ]
　　　　　　　　　　[塩こんぶ]
""",
            """
レンジ豚もやし　　　[豚ばら肉]
　　　　　　　　　　[もやし]
""",
            """
のりきゅうり　　　　[海苔]
　　　　　　　　　　[きゅうり]
""",
            """
茶碗むし　　　　　　[茶碗むし]
""",
            """
レンジコロッケ　　　[冷凍コロッケ]
""",
            """
じゃがブロッコリー　[ブロッコリー]
　　　　　　　　　　[じゃがいも]
""",
            """
スティックサラダ　　[にんじん]
　　　　　　　　　　[大根]
　　　　　　　　　　[きゅうり]
""",
            """
味噌田楽　　　　　　[味噌田楽]
""",
            """
かぼちゃチーズ　　　[かぼちゃ]
　　　　　　　　　　[スライスチーズ]
""",
            """
マカロニサラダ　　　[マカロニ]
　　　　　　　　　　[カニカマ]
　　　　　　　　　　[ハム]
　　　　　　　　　　[ツナコーン]
""",
            """
フライドポテト　　　[フライドポテト]
""",
            """
大学いも　　　　　　[さつまいも]
　　　　　　　　　　[大学いもの素]
　　　　　　　　　　[ごま]
""",
            """
卵豆腐　　　　　　　[卵豆腐]
""",
            """
レンジ青椒肉絲　　　[レンジ青椒肉絲]
""",
            """
春巻　　　　　　　　[レンジ春巻]
""",
            """
レンジ唐揚げ　　　　[レンジ唐揚げ]
""",
            """
コーンスープ　　　　[コーンスープ]
　　　　　　　　　　[牛乳]
"""
        )

        val listView4 = mainFrame.findViewById(R.id.list_view4) as ListView

        val arrayAdapter4 = this.context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1, clumsiness2.sorted()
            )
        }

        listView4.adapter = arrayAdapter4

        return mainFrame
    }
}