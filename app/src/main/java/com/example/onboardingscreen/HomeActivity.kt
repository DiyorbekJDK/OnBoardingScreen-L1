package com.example.onboardingscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.example.onboardingscreen.shared.SharePref

class HomeActivity : AppCompatActivity() {
    private val sharePref by lazy { SharePref(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.log_out, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            showDialog()
        }
        return true
    }

    private fun showDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("Log out")
            setMessage("Do you want to log out?")
            setPositiveButton("Yes") { _, _ ->
                sharePref.clear()
                finish()
            }
            setNegativeButton("No", null)
        }.show().create()
    }
}