package com.example.keshxotira

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        Myshared.init(this)
        var list = Myshared.list


        btn_save.setOnClickListener {
            val name = edt_name.text.toString().trim()
            val number = edt_number.text.toString().trim()

            if (name != "" && number != "") {

                val user = User(name, number)
                list.add(user)
                Myshared.list = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}