package com.databasetest
//
//import android.content.Context
//import android.widget.Toast
//import com.databasetest.databaseClasses.StudentGroup
//import org.junit.Test
//
//import org.junit.Assert.*
//import android.support.test.InstrumentationRegistry;
//import android.support.test.runner.AndroidJUnit4;
//
//import org.junit.After
//import org.junit.Before;
//import org.junit.runner.RunWith;
//
//import junit.framework.Assert.assertNotNull;
//import junit.framework.Assert.assertTrue;
//import org.hamcrest.MatcherAssert.assertThat;
//
////@RunWith(AndroidJUnit4::class.java)
//class ExampleUnitTest {
//
//    lateinit var dbHelper: DBHelper // Your DbHelper class
//
//    @Before
//    fun setUp() {
//        val mDataSource = RateDataSource(InstrumentationRegistry.getTargetContext())
//        mDataSource.open()
//    }
//
//    @Test
//    fun testDatabaseInsert() {
//        val myDatabaseHandler = DBHelper(Context.)
//        myDatabaseHandler.clearTables()
//        val testGroup = StudentGroup("ІВ-71", 2019, "ErA")
//        val testGroup2 = StudentGroup("ІВ-72", 2019, "ErA")
//        myDatabaseHandler.addGroup(testGroup)
//        myDatabaseHandler.addGroup(testGroup2)
//
//        val studentGroupsArray = myDatabaseHandler.getAllStudentGroups()
//
//    }
//
//}
