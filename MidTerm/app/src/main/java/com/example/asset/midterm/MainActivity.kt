package com.example.asset.midterm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var communicator: Communicator

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapterViewPager: FragmentPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterViewPager = PagerAdapter(supportFragmentManager)

        vPager.adapter = adapterViewPager
        tabLayout.setupWithViewPager(vPager)

        tabLayout.getTabAt(0)!!.text = "TODO"
        tabLayout.getTabAt(1)!!.text = "DONE"

        linearLayoutManager = LinearLayoutManager(this)

//        communicator.getUser(intent.getLongExtra("user_id", -1), applicationContext)

        vPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)!!.select()
            }
        })

        fab.setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            intent.putExtra("user_id", intent.getLongExtra("user_id", -1))
            startActivity(intent)
        }
    }
}
