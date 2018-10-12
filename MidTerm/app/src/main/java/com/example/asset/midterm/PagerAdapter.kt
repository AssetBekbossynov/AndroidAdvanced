package com.example.asset.midterm

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val NUM = 2

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return TodosFragment.Companion.newInstance()
            1 -> return DoneFragment.newInstance()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return NUM
    }
}