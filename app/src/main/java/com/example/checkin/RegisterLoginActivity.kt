package com.example.checkin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_register_login.*
import kotlin.concurrent.thread

class RegisterLoginActivity : AppCompatActivity() {

    val RC_LOGIN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)

        supportActionBar!!.hide()

        login.setOnClickListener {
            login()
        }

        register.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build())

        val muLayout = AuthMethodPickerLayout.Builder(R.layout.sign_up)
            .setEmailButtonId(R.id.email_register)
            .setGoogleButtonId(R.id.google_register)
            .build()

        val intent = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers)
                .setTheme(R.style.SingUp)
                .setAuthMethodPickerLayout(muLayout)
                .setIsSmartLockEnabled(true)
                .build()

        startActivityForResult(intent, RC_LOGIN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_LOGIN && resultCode == Activity.RESULT_OK) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}
