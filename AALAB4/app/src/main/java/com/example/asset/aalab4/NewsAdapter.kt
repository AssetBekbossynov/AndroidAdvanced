package com.example.asset.aalab4

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class NewsAdapter(private val list: ArrayList<News>, private val context: Context) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title.setText(list.get(position).title)
        holder.itemView.date.setText(list.get(position).date)
        holder.itemView.content.setText(list.get(position).content)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}