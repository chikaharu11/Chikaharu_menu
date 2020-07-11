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