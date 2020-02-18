package com.example.checkin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import kotlin.concurrent.thread

class HomeActivity : AppCompatActivity(), FirebaseAuth.AuthStateListener {

    private var backKeyTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener(this)
    }

    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener(this)
    }


    override fun onAuthStateChanged(auth: FirebaseAuth) {
        if (auth.currentUser == null) {
            startActivity(Intent(this, RegisterLoginActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        if (backKeyTimes == 0) {
            Toast.makeText(this, "在按一次退出應用", Toast.LENGTH_SHORT).show()
            backKeyTimes = 1

            thread {
                Thread.sleep(2000)
                backKeyTimes = 0
            }

        } else {
            finish()
        }
    }
}
