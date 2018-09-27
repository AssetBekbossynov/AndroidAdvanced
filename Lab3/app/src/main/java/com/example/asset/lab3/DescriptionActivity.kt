package com.example.asset.lab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val intent = intent

        val news = intent.extras.getParcelable<News>("news")

        if (news != null){
            newsTitle.text = news.title
            date.text = news.date
            content.text = news.content
        }else{
            newsTitle.text = ""
            date.text = ""
            content.text = ""
        }
    }
}
