package com.example.asset.midterm

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TodosFragment: Fragment(), Communicator {

    companion object {

        internal var todosFragment = TodosFragment()

        fun newInstance(): TodosFragment {
            return todosFragment
        }
    }

    private var rv: RecyclerView? = null
    private lateinit var list: ArrayList<Todo>

    private lateinit var todoDao: TodoDao

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.todo_fragment, container, false)
        rv = view.findViewById(R.id.rv)

//        (activity as MainActivity).communicator = this

        return view
    }

    override fun getUser(userId: Long, context: Context) {
//        todoDao = (activity as MyApp).database.todoDao()
//        Thread(Runnable {
//            list = todoDao.getTodosByStatusAndUser(userId, "todo") as ArrayList<Todo>
//            rv!!.adapter = TodoAdapter(list, context!!)
//        }).start()
    }

}