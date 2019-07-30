package com.databasetest.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View

import android.support.v7.app.AlertDialog
import android.widget.EditText
import com.databasetest.DBHelper
import com.databasetest.R
import com.databasetest.databaseClasses.StudentGroup
import android.view.LayoutInflater


/**
 * Activity that is invoked after pressing button "For admin" in the Main activity
 */
class AdminActivity : AppCompatActivity() {
    private val myDatabaseHelper: DBHelper = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

//        myDatabaseHelper.addGroup(StudentGroup("ІК-71", 2017, "цушщеьщцуешцуеп"))
//        val groups = myDatabaseHelper.getAllStudentGroups()
//        Toast.makeText(baseContext, groups.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == android.R.id.home) {
            finish()
        }
        return true
    }

    fun onAddGroupClicked(v : View) {

        val createGroupDialog = AlertDialog.Builder(this)

        createGroupDialog.setView(R.layout.create_group_layout)
        createGroupDialog.setTitle(R.string.create_group)

        val linf = LayoutInflater.from(this)
        val popupInputDialogView = linf.inflate(R.layout.create_group_layout, null)

        createGroupDialog.setView(popupInputDialogView)

        val groupNameField: EditText = popupInputDialogView.findViewById(R.id.group_name_alert_dialog)
        val groupYearField: EditText = popupInputDialogView.findViewById(R.id.group_year_alert_dialog)
        val groupSpecializationField: EditText = popupInputDialogView.findViewById(R.id.group_specialization_alert_dialog)

        createGroupDialog.setPositiveButton("Готово") { dialog, which ->
            try {
                val groupName = groupNameField.getText().toString()
                val groupYear = groupYearField.text.toString().toInt()
                val groupSpecialization = groupSpecializationField.text.toString()

                myDatabaseHelper.addGroup(StudentGroup(groupName, groupYear, groupSpecialization))
            } catch (e : Exception) {
                return@setPositiveButton
            } finally {
                dialog.dismiss()
            }
        }.setNegativeButton("Скасувати") { dialog, id ->
                dialog.cancel()
            }

        createGroupDialog.create()
        createGroupDialog.show()
    }


}
