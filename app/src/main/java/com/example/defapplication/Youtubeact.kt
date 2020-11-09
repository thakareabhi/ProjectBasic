package com.example.defapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_youtubeact.*


class Youtubeact : YouTubeBaseActivity() {
    //val VIDEO_ID:String="";
     lateinit var database: DatabaseReference.CompletionListener

     lateinit var binding: Youtubeact
        var vidid:String=""
        companion object {
        val YOUTUBE_API_KEY: String = "AIzaSyAGYLzqvpEt3RECmwamycY217516f6frug"
    }

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtubeact)
         vidid=intent.getStringExtra("ID")




        initUI()
    }


     fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {

                youtubePlayer?.loadVideo(vidid)

            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext, "Something went wrong !! ", Toast.LENGTH_SHORT).show()
            }
        }

         btnPlay.setOnClickListener(View.OnClickListener { v ->
             youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
         })

    }
}