package com.example.asset.lab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapterViewPager: FragmentPagerAdapter

//    private var actors: ArrayList<Actor> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout.getTabAt(0)!!.text = "RECENT NEWS"
        tabLayout.getTabAt(1)!!.text = "CATEGORY"

        linearLayoutManager = LinearLayoutManager(this)

        adapterViewPager = PagerAdapter(supportFragmentManager)

        vPager.adapter = adapterViewPager
        tabLayout.setupWithViewPager(vPager)

        vPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)!!.select()
            }
        })

//        rv.layoutManager = linearLayoutManager
//        if (savedInstanceState != null){
////            Log.d("TAG", "list " + savedInstanceState.getSerializable("key"))
//            actors = savedInstanceState.getSerializable("key") as ArrayList<Actor>
//        }else{
//            addingActors()
//        }
//        val adapter = ListAdapter(actors, this)
//        rv.adapter = adapter
//
//        fab.setOnClickListener({
//            Log.d("TAG", "fab clicked")
//            val actor = Actor("Elijah Wood ${actors.size}", "The Lord of the Ring")
//            actors.add(actor)
//            Log.d("TAG", "actors " + actors)
//            adapter.notifyItemInserted(actors.size)
//        })
    }
}
