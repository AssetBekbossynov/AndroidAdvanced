package com.example.asset.aalab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    private var actors: ArrayList<Actor> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        if (savedInstanceState != null){
//            Log.d("TAG", "list " + savedInstanceState.getSerializable("key"))
            actors = savedInstanceState.getSerializable("key") as ArrayList<Actor>
        }else{
            addingActors()
        }
        val adapter = ListAdapter(actors, this)
        rv.adapter = adapter

        fab.setOnClickListener({
            Log.d("TAG", "fab clicked")
            val actor = Actor("Elijah Wood ${actors.size}", "The Lord of the Ring")
            actors.add(actor)
            Log.d("TAG", "actors " + actors)
            adapter.notifyItemInserted(actors.size)
        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putSerializable("key", actors)
    }

    fun addingActors(){
        for (i in 0 until 5){
            val actor = Actor("Johnny Dep $i", "Pirates of the Carribbean")
            actors.add(actor)
        }
    }
}
