package com.example.asset.midterm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodoActivity : AppCompatActivity() {

    private lateinit var todoDao: TodoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        todoDao = (applicationContext as MyApp).database.todoDao()

        add.setOnClickListener {
            if (intent.getLongExtra("user_id", -1).toInt() != -1){
                Thread(Runnable {
                    val todo = Todo(todoDao.getCount() + 1, todoTitle.text.toString(), description.text.toString(), "todo", intent.getLongExtra("user_id", -1))
                    todoDao.insertTodo(todo)
                    runOnUiThread {
                        Toast.makeText(this, "TODO was created $todo", Toast.LENGTH_LONG).show()
                        finish()
                    }
                })
            }
        }
    }
}
