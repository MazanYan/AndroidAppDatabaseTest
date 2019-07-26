package com.databasetest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.databasetest.Activities.AdminActivity
import com.databasetest.Activities.SignUpActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onRegisterClicked(v: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivityForResult(intent, 1)
    }

    fun onLogInClicked(v: View) {

    }

    fun onAdminClicked(v: View) {
        val intent = Intent(this, AdminActivity::class.java)
        startActivityForResult(intent, 0)
    }
}
