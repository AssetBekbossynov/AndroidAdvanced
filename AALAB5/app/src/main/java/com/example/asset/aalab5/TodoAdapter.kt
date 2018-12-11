package com.example.asset.aalab5

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class TodoAdapter (private val list: ArrayList<Todo>, private val context: Context) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        Log.d("MY_TAG", "onCreateViewHolder")

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("MY_TAG", "getItemCount")
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("MY_TAG", "onBindViewHolder " + position)
        holder.itemView.title.setText(list.get(position).title)
        holder.itemView.completed.setText(list.get(position).body.toString())
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}