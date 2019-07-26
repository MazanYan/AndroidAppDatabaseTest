package com.databasetest.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.databasetest.R

/**
 * Class of window which opens after pressing Sign up button in Main activity
 */
class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_activity)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == android.R.id.home) {
            finish()
        }
        return true
    }

    fun testFun(v : View) {
        Toast.makeText(baseContext, "ewytweywe", Toast.LENGTH_LONG).show()
    }
}
