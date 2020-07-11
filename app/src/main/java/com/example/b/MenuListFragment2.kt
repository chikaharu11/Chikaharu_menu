package com.example.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class MenuListFragmentActivity2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainFrame = inflater.inflate(R.layout.menufragment_list2,container,false)
        val baboon2 = arrayListOf(

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

        val listView2 = mainFrame.findViewById(R.id.list_view2) as ListView

        val arrayAdapter2 = this.context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1, baboon2.sorted()
            )
        }

        listView2.adapter = arrayAdapter2

        return mainFrame
    }
}