package com.example.home_pc.myfirstkotlinapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var showCountTextView:TextView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btn_toast)
        btnToast.setOnClickListener({ showToast() })

        showCountTextView = findViewById(R.id.textView) as TextView

        val btnCount = findViewById(R.id.btn_count) as Button
        btnCount.setOnClickListener({ increaseNumber() })

        val btnRandom = findViewById<Button>(R.id.btn_random)
        btnRandom.setOnClickListener({startSecondActivity()})
    }

    private fun increaseNumber() {
        var curentNumber: Int = Integer.parseInt(showCountTextView?.text.toString())
        curentNumber++
        showCountTextView?.text = curentNumber.toString()
    }

    private fun showToast() {
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    private fun startSecondActivity(){
        val randomIntent = Intent(this, SecondActivity::class.java)
        val countString = textView.text.toString()
        val count = Integer.parseInt(countString)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }
}
