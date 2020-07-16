package com.example.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.menufragment_list1.view.*

class MenuListFragmentActivity1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainFrame = inflater.inflate(R.layout.menufragment_list1,container,false)
        val lunches2 = arrayListOf(

            """
皿うどん　　　　　[皿うどん]
　　　　　　　　　[豚バラ肉]
　　　　　　　　　[野菜炒め用野菜]
""",
            """
ギョーザ　　　　　[冷凍ギョーザ]
""",
            """
焼きそば　　　　　[豚こま肉]
　　　　　　　　　[野菜炒め用野菜]
　　　　　　　　　[焼きそばの麺]
""",
            """
マーボー春雨　　　[マーボー春雨]
""",
            """
マーボー豆腐　　　[マーボー豆腐]
""",
            """
沖縄そば　　　　　[かまぼこ]
　　　　　　　　　[ネギ]
""",
            """
冷凍パスタ　　　　[冷凍パスタ]
""",
            """
すき焼き豆腐　　　[豆腐]
　　　　　　　　　[すき焼き豆腐の素]
""",
            """
レトルトカレー　　[レトルトカレー]
""",
            """
豚しょうが焼き　　[豚ロース肉]
　　　　　　　　　[豚しょうが焼きの素]
""",
            """
ハンバーグ　　　　[ハンバーグ]
""",
            """
あんかけ卵　　　　[卵]
　　　　　　　　　[あんかけの素]
""",
            """
肉野菜炒め　　　　[豚こま肉]
　　　　　　　　　[野菜炒めミックス]
""",
            """
ビーフン炒め　　　[冷凍ビーフン]
"""
        )

        val listView1 = mainFrame.list_view1 as ListView

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