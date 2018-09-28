package com.example.asset.lab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Fragment
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapterViewPager: FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapterViewPager = PagerAdapter(supportFragmentManager)

        vPager.adapter = adapterViewPager
        tabLayout.setupWithViewPager(vPager)

        tabLayout.getTabAt(0)!!.text = "RECENT NEWS"
        tabLayout.getTabAt(1)!!.text = "CATEGORY"

        linearLayoutManager = LinearLayoutManager(this)


        vPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)!!.select()
            }
        })
    }
}
