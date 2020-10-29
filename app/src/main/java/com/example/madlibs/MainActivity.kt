package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Adapter as Adapter1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val archivos = arrayListOf<String>("Simple", "Tarzan", "Universidad", "Ropa", "Danza")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, archivos)
        listFile.adapter = adapter

        listFile.setOnItemClickListener { adapterView, view, i, l ->
            val intent= Intent(this, FillWords::class.java)
            intent.putExtra("file", "${i}")
            startActivity(intent)
        }


        buttonStart.setOnClickListener{
            val intent= Intent(this, FillWords::class.java)
            startActivity(intent)

            val simple = resources.openRawResource(R.raw.madlib0_simple)
            val tarzan = resources.openRawResource(R.raw.madlib1_tarzan)
            val university = resources.openRawResource(R.raw.madlib2_university)
            val clothes = resources.openRawResource(R.raw.madlib3_clothes)
            val dance = resources.openRawResource(R.raw.madlib4_dance)
        }
    }
}