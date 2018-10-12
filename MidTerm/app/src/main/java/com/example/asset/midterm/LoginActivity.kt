package com.example.asset.midterm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userDao = (applicationContext as MyApp).database.userDao()

        login.setOnClickListener {
            Thread(Runnable {
                val user = userDao.getUsersByName(email.editText!!.text.toString())
                if (password.editText!!.text.equals(user.password)){
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("user_id", user.id)
                    startActivity(intent)
                }else{
                    val user = User(userDao.getCount() + 1, email.editText!!.text.toString(), password.editText!!.toString())
                    userDao.insertUser(user)
                    runOnUiThread {
                        Toast.makeText(this, "User created username ${email.editText!!.text} password ${password.editText!!.text}", Toast.LENGTH_LONG).show()
                    }
                }
            }).start()


//
//            }else{
//
//            }
        }
    }
}
