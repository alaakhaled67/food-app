package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.zip.Inflater

    class foodAdapter: BaseAdapter {
        var context: Context?=null
        var listOfFoodLocal=ArrayList<Foods>()
        var foodview: Inflater?=null
        constructor(listOfFood:ArrayList<Foods>,context: Context)
        {
            this.listOfFoodLocal=listOfFood
            this.context=context
        }
        override fun getCount(): Int {
            return listOfFoodLocal.size
        }

        override fun getItem(p0: Int): Any {
            return listOfFoodLocal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food=listOfFoodLocal[p0]
            if(food.name=="app_title")
            {   val inflater = LayoutInflater.from(context) // context is now available in the receiver scope
                val foodview = inflater.inflate(R.layout.titles, null)
                foodview.findViewById<TextView>(R.id.title_tv).text=food.title
                return foodview
            }else {
                val inflater =
                    LayoutInflater.from(context) // context is now available in the receiver scope
                val foodview = inflater.inflate(R.layout.food_item, null)
                foodview.findViewById<TextView>(R.id.item_name).text = food.name
                foodview.findViewById<TextView>(R.id.item_desc).text = food.title
                foodview.findViewById<ImageView>(R.id.item_img).setImageResource(food.img!!)
                foodview.findViewById<ImageView>(R.id.item_img).setOnClickListener {
                    var intent = Intent(context, FoodDetails::class.java)
                    intent.putExtra("name", food.name)
                    intent.putExtra("desc", food.title)
                    intent.putExtra("image", food.img)
                    context!!.startActivity(intent)
                }
                return foodview
            }
        }
        fun delate(index:Int)
        {
            listOfFoodLocal.removeAt(index)
            notifyDataSetChanged()
        }
        fun add(index:Int)
        {
            listOfFoodLocal.add(index,listOfFoodLocal[index])
            notifyDataSetChanged()
        }
    }