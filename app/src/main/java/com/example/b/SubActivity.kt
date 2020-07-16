package com.example.b

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*


class SubActivity : AppCompatActivity() {

    private var textView: TextView? = null
    private var editTextKey: EditText? = null
    private var editTextValue: EditText? = null
    private var helper: TestOpenHelper? = null
    private var db: SQLiteDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        editTextKey = edit_text_key
        editTextValue = edit_text_value
        textView = text_view

        val insertButton = button_insert

        insertButton.setOnClickListener {

            if (helper == null) {
                helper = TestOpenHelper(applicationContext)
            }

            if (db == null) {
                db = helper!!.writableDatabase
            }

            val key = edit_text_key.text.toString()
            val value = edit_text_value.text.toString()

            // 価格は整数を想定
            insertData(db, key, Integer.valueOf(value))
        }

        val readButton = button_read

        readButton.setOnClickListener {

            readData()
        }
    }

    private fun readData() {

        if (helper == null) {
            helper = TestOpenHelper(applicationContext)
        }

        if (db == null) {
            db = helper!!.readableDatabase
        }

        Log.d("debug", "**********Cursor")

        val cursor = db!!.query(
            "testdb", arrayOf("company", "stockprice"),
            null,
            null,
            null,
            null,
            null
        )

        cursor.moveToFirst()

        val sbuilder = StringBuilder()

        for (i in 0 until cursor.count) {

            sbuilder.append(cursor.getString(0))
            sbuilder.append(": ")
            sbuilder.append(cursor.getInt(1))
            sbuilder.append("\n")
            cursor.moveToNext()
        }

        // 忘れずに！
        cursor.close()

        Log.d("debug", "**********$sbuilder")

        textView!!.text = sbuilder.toString()
    }

    private fun insertData(db: SQLiteDatabase?, com: String, price: Int) {

        val values = ContentValues()

        values.put("company", com)
        values.put("stockprice", price)
        db!!.insert("testdb", null, values)
    }
}