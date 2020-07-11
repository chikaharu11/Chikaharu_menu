package com.example.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class MenuListFragmentActivity1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainFrame = inflater.inflate(R.layout.menufragment_list1,container,false)
        val lunches2 = arrayListOf(

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

        val listView1 = mainFrame.findViewById(R.id.list_view1) as ListView

        val arrayAdapter1 = this.context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1, lunches2.sorted()
            )
        }

        listView1.adapter = arrayAdapter1

        return mainFrame
    }
}