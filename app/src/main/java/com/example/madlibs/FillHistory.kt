package com.example.madlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fill_history.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class FillHistory : AppCompatActivity() {

    lateinit var parameter: InputStream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_history)

        val file = intent.getStringExtra("file")
        Toast.makeText(this, "$file", Toast.LENGTH_LONG).show()

        if (file == "0"){
            parameter = resources.openRawResource(R.raw.madlib0_simple)
        } else if (file == "1"){
            parameter = resources.openRawResource(R.raw.madlib1_tarzan)
        } else if(file == "2"){
            parameter = resources.openRawResource(R.raw.madlib2_university)
        } else if (file == "3"){
            parameter = resources.openRawResource(R.raw.madlib3_clothes)
        } else if (file == "4"){
            parameter = resources.openRawResource(R.raw.madlib4_dance)
        }
        readFile()
    }

    private fun readFile(){
        val file: InputStream = this.parameter
        val line: String
        val reader: BufferedReader = BufferedReader(InputStreamReader(file))
        line = reader.readLine()
        if(file != null){
            while ( line != null){

                val jobResult = Regex("""<[a-z]+>""").replace("${file}", "${textInput}")
            }
        }
        file.close()
    }
}