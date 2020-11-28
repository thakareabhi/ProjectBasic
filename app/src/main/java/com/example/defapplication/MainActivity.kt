package com.example.defapplication




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synnapps.carouselview.CarouselView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var sampleImages = intArrayOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carouselView.pageCount=sampleImages.size

        carouselView.setImageListener{position, imageView ->
            imageView.setImageResource(sampleImages[position])
        }


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