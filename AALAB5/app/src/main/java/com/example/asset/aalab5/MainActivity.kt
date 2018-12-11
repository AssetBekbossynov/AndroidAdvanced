package com.example.asset.aalab5

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var todoList: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = TodoAdapter(todoList, this)

        fab.setOnClickListener {
            val intent = Intent(this, AddTodo::class.java)
            startActivity(intent)
        }

    }

    fun loadData(){
        Thread(Runnable {
            val response: Response<List<Todo>>? = APICaller.getTodoAPI().getTodos().execute()
            if (response != null && response.isSuccessful){
                runOnUiThread {
                    todoList.clear()
                    todoList.addAll(response.body()!!)
                    rv.adapter.notifyDataSetChanged()
                }
            }else{
                runOnUiThread {
                    Toast.makeText(baseContext, "Download failure", Toast.LENGTH_LONG).show()
                }
            }
        }).start()
    }
}
