package com.databasetest.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.databasetest.DBHelper
import com.databasetest.R
import com.databasetest.databaseClasses.Student

/**
 * Class of window which opens after pressing Sign up button in Main activity
 */
class SignUpActivity : AppCompatActivity() {
    private val myDatabaseHelper: DBHelper = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_activity)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == android.R.id.home) {
            finish()
        }
        return true
    }

    fun registerUser(v : View) {
        val getLogin: EditText = findViewById(R.id.input_login)
        val getPassword: EditText = findViewById(R.id.input_password)
        val getRealName: EditText = findViewById(R.id.input_name)
        val getGroup: EditText = findViewById(R.id.input_group)
        try {

            val userLogin = getLogin.text.toString()
            val userGroup = getGroup.text.toString()
            val userPassword = getPassword.text.toString()
            //first word - second name, second word - first name, third word - father's name
            val userFullName: List<String> = getRealName.text.toString().split(" ")
            myDatabaseHelper.addUser(Student(userLogin, userGroup, userPassword, userFullName[1], userFullName[0], userFullName[2]))

        } catch (e : Exception) {
            Toast.makeText(baseContext, e.stackTrace.toString(), Toast.LENGTH_LONG).show()
        }

        Toast.makeText(baseContext, myDatabaseHelper.getAllStudents().toString(), Toast.LENGTH_LONG).show()
    }
}
