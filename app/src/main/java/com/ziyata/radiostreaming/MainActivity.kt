package com.ziyata.radiostreaming

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRadio1.setOnClickListener {
            val intent = Intent(this, Radio1Activity::class.java)
            intent.putExtra("urlRadio1", "http://masima.rastream.com:80/masima-deltajakarta")
            startActivity(intent)
        }
    }
}
