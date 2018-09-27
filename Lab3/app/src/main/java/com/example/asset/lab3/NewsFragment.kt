package com.example.asset.lab3

import android.app.Activity
import android.content.res.Configuration
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.news_fragment.*


class NewsFragment : Fragment() {

    companion object {

        internal var newsFragment = NewsFragment()

        fun newInstance(): NewsFragment {
            return newsFragment
        }
    }

    private var rv: RecyclerView? = null

    private lateinit var list: ArrayList<News>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.news_fragment, container, false)

        if (savedInstanceState != null){
//            Log.d("TAG", "list " + savedInstanceState.getSerializable("key"))
            list = savedInstanceState.getSerializable("key") as ArrayList<News>
        }else{
            createData()
        }

        rv = view.findViewById(R.id.rv)
        rv!!.adapter = NewsAdapter(list, context!!)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rv!!.layoutManager = GridLayoutManager(context, 2)
        }else{
            rv!!.layoutManager = LinearLayoutManager(context)
        }



        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState!!.putSerializable("key", list)
    }

    private fun createData(){
        list = ArrayList()
        for (i in 0..5){
            val news = News("Some title$i", "28-09-2018", "Some Looooooooooooooooooooooooooong content")
            list.add(news)
        }
    }
}