package com.example.asset.aalab4

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val ADD_NEWS = 1

    private var newsList: ArrayList<News> = ArrayList()

    private lateinit var newsDao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsDao = (applicationContext as MyApp).database.newsDao()

        loadData()

        rv.adapter = NewsAdapter(newsList, this)
        rv.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            val intent = Intent(this, AddNewsActivity::class.java)
            startActivityForResult(intent, ADD_NEWS)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == ADD_NEWS){
            loadData()
        }
    }

    private fun loadData(){
        Thread(Runnable {
            newsList = newsDao.getNews() as ArrayList<News>
            runOnUiThread {
                Log.d("MY_TAG", "news mian " + newsList)
                rv.adapter.notifyDataSetChanged()
            }
        }).start()
    }
}
