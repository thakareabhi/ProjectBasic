package com.example.defapplication




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button11.setOnClickListener {
            val intent = Intent(this, Speechttext::class.java)
            startActivity(intent)
        }

        button12.setOnClickListener {
            val intent = Intent(this, PhotoCapture::class.java)
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this, FetchData::class.java)
            startActivity(intent)
        }

        button14.setOnClickListener {
            val intent = Intent(this, AlertActiviity::class.java)
            startActivity(intent)
        }

    }
}