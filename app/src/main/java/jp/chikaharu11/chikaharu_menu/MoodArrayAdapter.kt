package jp.chikaharu11.chikaharu_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MoodArrayAdapter(ctx: Context,
                       moods: List<Mood>) :
    ArrayAdapter<Mood>(ctx, 0, moods) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {

        val mood = getItem(position)

        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.demo_spinner,
            parent,
            false
        )

        mood?.image?.let { view.findViewById<ImageView>(R.id.moodImage).setImageResource(it) }
        view.findViewById<TextView>(R.id.moodText).text = mood?.description

        return view
    }
}