package com.example.checkin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_login.*

class RegisterLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)

        supportActionBar!!.hide()

        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}
