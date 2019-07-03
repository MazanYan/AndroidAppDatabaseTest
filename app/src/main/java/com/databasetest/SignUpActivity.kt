package com.databasetest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class SignUpActivity : AppCompatActivity() {

    companion object {
        val EXTRA_TASK_DESCRIPTION = "task"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_activity)
        //val actionBar = actionBar
        //actionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, SignUpFragment.newInstance())
//                .commitNow()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == android.R.id.home) {
            finish()
        }
        return true
    }

}
