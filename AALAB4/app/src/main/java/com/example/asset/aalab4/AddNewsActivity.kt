package com.example.asset.aalab4

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_add_news.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AddNewsActivity : AppCompatActivity() {

    private lateinit var newsDao: NewsDao

    private lateinit var title: String
    private lateinit var content: String
    private lateinit var publishedDate: String

    private var newsList: ArrayList<News> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        newsDao = (applicationContext as MyApp).database.newsDao()

        val date = Date()
        val spf = SimpleDateFormat("yyyy-MM-dd")

        date_label.text = spf.format(date)

        add_news.setOnClickListener {

            title = news_title.text.toString()
            content = news_content.text.toString()
            publishedDate = date_label.text.toString()

            Thread(Runnable {
                val news = News(newsDao.getCount() + 1, title, publishedDate, content)
                newsDao.insertNews(news)
                newsList = newsDao.getNews() as ArrayList<News>
                runOnUiThread {
                    setResult(Activity.RESULT_OK)
                    Log.d("MY_TAG", "news " + newsList)
                    finish()
                }
            }).start()
        }

    }
}
