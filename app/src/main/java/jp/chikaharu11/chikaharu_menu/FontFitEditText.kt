package jp.chikaharu11.chikaharu_menu

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.EditText
import kotlin.math.abs


@SuppressLint("AppCompatCustomView")
class ResizeEditText : EditText {

    constructor(context: Context?) : super(context!!)

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        resize()
    }


    private fun resize() {

        val minTextSize = 10f
        val viewHeight = this.height
        val viewWidth = this.width

        var textSize = textSize

        val paint = Paint()
        paint.textSize = textSize

        var fm = paint.fontMetrics
        var textHeight = abs(fm.top) + abs(fm.descent)

        var textWidth = paint.measureText(this.text.toString())

        while (viewHeight < textHeight || viewWidth < textWidth) {

            if (minTextSize >= textSize) {

                textSize = minTextSize
                break
            }

            textSize--

            paint.textSize = textSize

            fm = paint.fontMetrics
            textHeight = abs(fm.top) + abs(fm.descent)

            textWidth = paint.measureText(this.text.toString())
        }

        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
    }
}