package com.example.defapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import kotlinx.android.synthetic.main.activity_speechttext.*
import java.lang.Exception
import java.util.*


class Speechttext : AppCompatActivity() {
    private var REQUEST_CODE_SPEECH_INPUT=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speechttext)

        buttonmic.setOnClickListener {
            speak()
        }

    }
    private fun speak()
    {
        val mIntent=Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        mIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to get Text")

        try {
            Log.d("Hi","msg2")
                startActivityForResult(mIntent,REQUEST_CODE_SPEECH_INPUT)
        }
        catch (e:Exception)
        {

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("Hi","msg4")
        when(requestCode){

            REQUEST_CODE_SPEECH_INPUT->{
                Log.d("Hi","msg5")
                if(null!=data)
                {
                    Log.d("Hi","msg2")

                    var result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    textView.text=result[0]

                    Log.d("Hi","msg3")


                }
            }
        }
    }


}
