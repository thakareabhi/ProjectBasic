package com.example.defapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_fetch_data.*
import kotlinx.android.synthetic.main.activity_main.*

class FetchData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_data)


        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video")
        var vidid=""


        button17.setOnClickListener {

            //vidid = "2vP1CMK4I3Y"
            //demoRef.setValue(vidid)
            val intent = Intent(this, Youtubeact::class.java)
            demoRef.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val value = dataSnapshot.getValue(String::class.java)
                    vidid=value.toString();
                    Log.d("taga","scev"+value)

                    intent.putExtra("VDID",vidid)
                    startActivity(intent)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(this@FetchData, "Error fetching data", Toast.LENGTH_LONG)
                        .show()
                }
            })



        }

    }
}
