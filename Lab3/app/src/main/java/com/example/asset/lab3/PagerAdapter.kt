package com.example.asset.lab3

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val NUM = 2

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return NewsFragment.Companion.newInstance()
            1 -> return CategoryFragment.newInstance()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return NUM
    }
}
