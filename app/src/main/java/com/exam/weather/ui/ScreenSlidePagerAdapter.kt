package com.exam.weather.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(
    fragment: Fragment,
    private val contents: List<String>,
    private val pageNumbers: Int
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = pageNumbers

    override fun createFragment(position: Int): Fragment {
        val fragment = WeatherFragment()
        fragment.setCity(contents[position])
        return fragment
    }
}
