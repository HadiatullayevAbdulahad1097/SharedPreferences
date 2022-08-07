package com.example.keshxotira

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onResume() {
        super.onResume()
        Myshared.init(this)

        ekran.removeAllViews()

        for (i in Myshared.list){
            val textView = TextView(this)
            textView.textSize = 20f
            textView.setText("${i.name} \n ${i.number}")
            textView.setOnClickListener {
                startActivity(Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:${i.number}")))
            }
            ekran.addView(textView)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, AddActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
}