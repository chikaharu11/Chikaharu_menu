package jp.chikaharu11.chikaharu_menu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

interface CustomAdapterListener {
    fun clicked(cuisine: Cuisine)
    fun clicked2(cuisine: Cuisine)
}

class CustomAdapter(context: Context, private var mCuisines: List<Cuisine>, private val listener: CustomAdapterListener) : ArrayAdapter<Cuisine>(context, 0, mCuisines) {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val cuisineList = mCuisines[position]

        var view = convertView
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_list, parent, false)
        }

        val name = view?.findViewById<TextView>(R.id.name)
        name?.text = cuisineList.name
        name?.setOnClickListener {
            listener.clicked2(cuisineList)
        }

        val imageButton = view?.findViewById<ImageView>(R.id.imageButton)
        imageButton?.setOnClickListener {
            listener.clicked(cuisineList)
        }

        return view!!
    }
}