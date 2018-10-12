package com.example.asset.midterm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodoActivity : AppCompatActivity() {

    private lateinit var todoDao: TodoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        todoDao = (applicationContext as MyApp).database.todoDao()

        add.setOnClickListener {
            if (intent.getLongExtra("user_id", -1) == -1)
            val todo = Todo(todoDao.getCount() + 1, todoTitle.text.toString(), description.text.toString(), intent.getLongExtra("1"))
        }
    }
}
