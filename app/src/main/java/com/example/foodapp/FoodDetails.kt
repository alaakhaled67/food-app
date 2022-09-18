package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle=intent.extras
        findViewById<TextView>(R.id.name).text=bundle!!.getString("name")
        findViewById<TextView>(R.id.desc).text=bundle!!.getString("desc")
        findViewById<ImageView>(R.id.img).setImageResource(bundle!!.getInt("image"))
    }
}