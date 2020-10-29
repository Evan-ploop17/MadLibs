package com.example.madlibs

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_fill_words.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

    const val textJob = ""
    val textAdjective = ""

class FillWords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_words)

        val file = intent.getStringExtra("file")
        Log.v("recibido", "$file")
        readFile()
    }

    fun readFile(){
        val file: InputStream = this.resources.openRawResource(R.raw.madlib0_simple)
        val line: String
        val reader: BufferedReader = BufferedReader(InputStreamReader(file))
        line = reader.readLine()
        if(file != null){
            while ( line != null){
                //  <[a-z]+>
                val jobResult = Regex("""<job>""").replace("${file}", "${textJob}")
                val adjectiveResult = Regex("""<adjective>""").replace("${file}", "${textAdjective}")
            }
        }
        file.close()

    }
}