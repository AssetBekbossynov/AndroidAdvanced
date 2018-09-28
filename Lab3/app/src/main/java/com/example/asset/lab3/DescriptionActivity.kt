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
            content.text = "You can spell check very long text areas without compromising any performance hits. Regardless of the size of the text, UltimateSpell only sends small portions of the text to the server as needed, while the user spell checks through the text.\n" +
                    "\n" +
                    "Basically the spell check dialog box makes on-demand calls to a callback page on the server without refreshing the whole page or dialog. It keeps processing small blocks of text using the AJAX (Asynchronous JavaScript and XML) techniques.\n" +
                    "\n" +
                    "Note that UltimateSpell displays the text in the dialog box sentence-by-sentence just like Microsoft Word. This helps the user understand the actual context in which the spelling error occurs. "
        }else{
            newsTitle.text = ""
            date.text = ""
            content.text = ""
        }

        imageView2.setOnClickListener { onBackPressed() }
    }
}
