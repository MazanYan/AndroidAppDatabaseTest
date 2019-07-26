package com.databasetest.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.databasetest.R

import com.databasetest.dialogFragments.CreateGroupDialogFragment

/**
 * Activity that is invoked after pressing button "For admin" in the Main activity
 */
class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == android.R.id.home) {
            finish()
        }
        return true
    }

    fun onAddGroupClicked(v : View) {
        val dialog = CreateGroupDialogFragment()
        val fm = supportFragmentManager
        dialog.show(fm, "test_tag")
    }


}
