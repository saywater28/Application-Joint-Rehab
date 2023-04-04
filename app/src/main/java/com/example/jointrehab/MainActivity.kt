package com.example.jointrehab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.nav_edit_profile -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_change_pass -> Toast.makeText(
                    applicationContext,
                    "Clicked Change Pass",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_personal_records -> Toast.makeText(
                    applicationContext,
                    "Clicked Records",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_location -> Toast.makeText(
                    applicationContext,
                    "Clicked Location",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_log_out -> Toast.makeText(
                    applicationContext,
                    "Clicked Log Out",
                    Toast.LENGTH_SHORT
                ).show()

            }

            true
        }

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        if (toggle.onOptionsItemSelected(item)) {
//            return true
//        }
//    }
}
