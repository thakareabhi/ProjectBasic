package com.example.defapplication

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_alertacti.*


class AlertActi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertacti)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val demoRef: DatabaseReference = rootRef.child("Vibrate").child("V1")


        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator


        /*demoRef.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                if(value.equals("true"))
                {
                    val pattern = longArrayOf(0, 1000, 1000)
                    v.vibrate(pattern, 0)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@AlertActi, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })*/

        demoRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                if(value.equals("true"))
                {
                    val pattern = longArrayOf(0, 1000, 1000)
                    v.vibrate(pattern, 0)
                }
                if(value.equals("false"))
                {
                    v.cancel();
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@AlertActi, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })

// Start without a delay
// Vibrate for 100 milliseconds
// Sleep for 1000 milliseconds

// Start without a delay
// Vibrate for 100 milliseconds
// Sleep for 1000 milliseconds


// The '0' here means to repeat indefinitely
// '0' is actually the index at which the pattern keeps repeating from (the start)
// To repeat the pattern from any other point, you could increase the index, e.g. '1'

// The '0' here means to repeat indefinitely
// '0' is actually the index at which the pattern keeps repeating from (the start)
// To repeat the pattern from any other point, you could increase the index, e.g. '1'


        button15.setOnClickListener {
            v.cancel();
        }
    }
}
