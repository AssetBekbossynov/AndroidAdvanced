package com.example.asset.aalab4

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import java.util.logging.Logger

class LoginActivity : AppCompatActivity() {

    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pref = PreferenceManager.getDefaultSharedPreferences(this)

        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            pref!!.edit().putString("username", email.editText!!.text.toString()).apply()
            pref!!.edit().putString("password", password.editText!!.text.toString()).apply()

            startActivity(intent)
            finish()
        }
    }
}
