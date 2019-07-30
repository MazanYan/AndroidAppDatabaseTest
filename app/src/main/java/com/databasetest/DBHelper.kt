package com.databasetest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.databasetest.databaseClasses.PairLesson
import com.databasetest.databaseClasses.Student
import com.databasetest.databaseClasses.StudentGroup

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    companion object {
        val DATABASE_NAME: String = "myDatabase.db"
        val DATABASE_VER: Int = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTablesQueries: ArrayList<String> = arrayListOf(
            """CREATE TABLE StudentGroup (
                Number INTEGER NOT NULL PRIMARY KEY, -- Hidden from user code of our studentGroup in the table --
                NumberCyr TEXT,     -- Cyrillic name of a group --
                Year INTEGER,
                Specialization TEXT
            );""",

            """CREATE TABLE Student (
                Login TEXT NOT NULL PRIMARY KEY,
                StudentGroup INTEGER,
                StudentGroupCyr TEXT,
                Password TEXT,
                FirstName TEXT,
                SecondName TEXT,
                FatherName TEXT,
                
                FOREIGN KEY(StudentGroup) REFERENCES StudentGroup(Number)
            );"""/*,

            """CREATE TABLE Lecturer (
                ID TEXT NOT NULL PRIMARY KEY,
                FirstName TEXT,
                LastName TEXT,
                FatherName TEXT
            );""",

            """CREATE TABLE LectureHall (
                Number INTEGER NOT NULL PRIMARY KEY,
                X REAL,
                Y REAL,
                Floor INTEGER,
                Photo TEXT
            );""",

            """CREATE TABLE Subject (
                Name TEXT PRIMARY KEY,
                ID TEXT NOT NULL
            );""",

            """CREATE TABLE PairLesson (
                ID INTEGER NOT NULL PRIMARY KEY,
                StudentGroup TEXT,
                LectureHall INTEGER,
                Lecturer TEXT,
                Subject INTEGER,
                Day INTEGER,
                LessonNumber INTEGER,

                FOREIGN KEY(StudentGroup) REFERENCES StudentGroup(Number),
                FOREIGN KEY(LectureHall) REFERENCES LectureHall(Number),
                FOREIGN KEY(Lecturer) REFERENCES Lecturer(ID),
                FOREIGN KEY(Subject) REFERENCES Subject(ID)
            );"""*/
        )
        for (query: String in createTablesQueries) {
            db!!.execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println("The database \"was\" updated")
    }

    // specific selects to be added
    fun getUserByLogin(login : String) : Student {
        return Student("","","","", "", "")
    }

    fun getUserByID(bookID : String) : Student {
        return Student("","","","", "", "")
    }

    //INSERT INTO Student VALUES ?
    fun addUser(student : Student) : Boolean {
        val db = this.writableDatabase
        var inserted = false
        try {
            val values = ContentValues()
            values.put("Login", student.login)
            values.put("StudentGroup", student.group.hashCode())
            values.put("StudentGroupCyr", student.group)
            values.put("Password", student.password)
            values.put("FirstName", student.firstName)
            values.put("SecondName", student.secondName)
            values.put("FatherName", student.fatherName)

            db.insert("Student", null, values)
            inserted = true
        } catch (e : Exception) {
            inserted = false
        } finally {
            db.close()
            return inserted
        }

    }

    // INSERT INTO StudentGroup VALUES ?;
    fun addGroup(group : StudentGroup) : Boolean {
        val values = ContentValues()
        values.put("Number", group.name.hashCode())
        values.put("NumberCyr", group.name)
        values.put("Year", group.year)
        values.put("Specialization", group.specialization)

        val db = this.writableDatabase

        db.insert("StudentGroup", null, values)
        db.close()
        return true
    }

    // SELECT * FROM StudentGroup
    fun getAllStudentGroups() : ArrayList<StudentGroup> {
        val myQuery = "SELECT * FROM StudentGroup;"
        val db = this.writableDatabase

        val sqlSelection = db.rawQuery(myQuery, null)
        val studentGroupsArray: ArrayList<StudentGroup> = ArrayList()
        if (sqlSelection.moveToFirst()) {
            do {
                val name = sqlSelection.getString(sqlSelection.getColumnIndex("Login"))
                val year = sqlSelection.getInt(sqlSelection.getColumnIndex("StudentGroup"))
                val specialization = sqlSelection.getString(sqlSelection.getColumnIndex("Specialization"))
                studentGroupsArray.add(StudentGroup(name, year, specialization))
            } while (sqlSelection.moveToNext())
        }
        sqlSelection.close()
        db.close()

        return studentGroupsArray
    }

    // SELECT * FROM Student
    fun getAllStudents() : ArrayList<Student> {
        val myQuery = "SELECT * FROM Student;"
        val db = this.writableDatabase

        val sqlSelection = db.rawQuery(myQuery, null)
        val studentGroupsArray: ArrayList<Student> = ArrayList()
        if (sqlSelection.moveToFirst()) {
            do {
                val login = sqlSelection.getString(sqlSelection.getColumnIndex("Login"))
                val group = sqlSelection.getString(sqlSelection.getColumnIndex("StudentGroupCyr"))
                val password = sqlSelection.getString(sqlSelection.getColumnIndex("Password"))
                val firstName = sqlSelection.getString(sqlSelection.getColumnIndex("FirstName"))
                val secondName = sqlSelection.getString(sqlSelection.getColumnIndex("SecondName"))
                val fatherName = sqlSelection.getString(sqlSelection.getColumnIndex("FatherName"))

                studentGroupsArray.add(Student(login, group, password, firstName, secondName, fatherName))
            } while (sqlSelection.moveToNext())
        }
        sqlSelection.close()
        db.close()

        return studentGroupsArray
    }

    // SELECT * FROM PairLesson WHERE StudentGroup=groupNumber
    fun getGroupSchedule(groupNumber : String) : Array<PairLesson> {
        return arrayOf(PairLesson(0, "IV-71", 100, "NOVOTARSKYI", "AMC", 1, 2))
    }

    fun dropTables() : Boolean {
        val myQuery = "DROP TABLE IF EXISTS StudentGroup;" +
                      "DROP TABLE IF EXISTS Student;"

        val db = this.writableDatabase

        db.rawQuery(myQuery, null).close()
        db.close()
        return true
    }

    fun clearTables() : Boolean {
        val db = this.writableDatabase
        db.delete("StudentGroup", null, null)
        db.delete("Student", null, null)
        return true
    }
}