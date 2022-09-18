package com.example.foodapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import java.util.zip.Inflater
class MainActivity : AppCompatActivity() {
    var listOfFood= ArrayList<Foods>()
    var adapter:foodAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFood()
        adapter= foodAdapter(listOfFood,this)
        findViewById<ListView>(R.id.lv_food).adapter=adapter
    }
    fun addFood()
    {
        listOfFood.add(Foods("app_title","general",R.drawable.rice))
        listOfFood.add(Foods("fride chicken","slice of chicken cooked in oil covered with egg and flour",R.drawable.fridechicken))
        listOfFood.add(Foods("rice","rice cooked in chicken soup with onion",R.drawable.rice))
        listOfFood.add(Foods("soup","chicken mixed with water and onion",R.drawable.soup))
        listOfFood.add(Foods("app_title","brevelage",R.drawable.rice))
        listOfFood.add(Foods("sepageti","sepageti with tomato in water",R.drawable.sepageti))
        listOfFood.add(Foods("jelly","dessert",R.drawable.jelly))
        listOfFood.add(Foods("potato chips","potato cooked in oil with flaver",R.drawable.potatochips))

    }
}