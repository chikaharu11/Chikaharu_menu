package com.example.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.menufragment_list4.view.*

class MenuListFragmentActivity4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainFrame = inflater.inflate(R.layout.menufragment_list4,container,false)
        val clumsiness2 = arrayListOf(

            """
長押しするとリストが出てきて、
クリックすると入力されます
""",
            """
豆腐　　　　　　　　[絹ごし豆腐]
"""
        )

        val listView4 = mainFrame.list_view4 as ListView

        val arrayAdapter4 = this.context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1, clumsiness2
            )
        }

        listView4.adapter = arrayAdapter4

        return mainFrame
    }
}