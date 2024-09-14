package com.example.lodingsplace

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        startHeavyTastk()
    }

    private fun startHeavyTastk() {
        longOpration().execute()

    }

    private open inner class longOpration:AsyncTask<String?, Void?, String?>(){
        override fun doInBackground(vararg p0: String?): String? {
          for(i in 0..6){
              try {
                  Thread.sleep(1000)
              }
              catch (e:Exception){
                  Thread.interrupted()
              }
          }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val intent=Intent(this@MainActivity2,MainActivity::class.java)
            startActivity(intent)

            finish()
        }

    }



}