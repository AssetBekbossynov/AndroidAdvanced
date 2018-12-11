package com.example.asset.aalab5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        add.setOnClickListener {
            Thread(Runnable {
                val response = APICaller.getTodoAPI().createPost(Post(1, 101, etTitle.text.toString(), etBody.text.toString())).execute()
                if (response != null && response.isSuccessful){
                    Log.d("KTP", "success " + response.body())
                    runOnUiThread {
                        finish()
                    }
                }else{
                    Log.d("KTP", "error " + response.message())
                }
            }).start()
        }
    }
}
