package com.exam.weather.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.exam.weather.R
import com.exam.weather.db.DatabaseHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var weatherCityPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherCityPager = view.findViewById(R.id.weatherCityPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        editText = view.findViewById(R.id.editText)
        button = view.findViewById(R.id.button)

        val cities: ArrayList<String> = arrayListOf()
        val dbHelper = DatabaseHelper(requireContext())
        val cursor = dbHelper.getRecords()
        cursor!!.moveToFirst()
        while (cursor.moveToNext()) {
            cities.add(cursor.getString(cursor.getColumnIndex("city_name")))
        }
        cursor.close()
        weatherCityPager.adapter = ScreenSlidePagerAdapter(this, cities, cities.size)

        val tabLayoutMediator = TabLayoutMediator(tabLayout, weatherCityPager) { _, _ -> }
        tabLayoutMediator.attach()

        button.setOnClickListener {
            if (editText.text.toString().isNotEmpty()) {
                dbHelper.createCity(editText.text.toString())
                editText.setText("")
            } else {
                Toast.makeText(context, "Please enter cityName", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
