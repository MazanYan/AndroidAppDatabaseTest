package com.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    companion object {
        val DATABASE_NAME: String = "myDatabase.db"
        val DATABASE_VER: Int = 1
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTablesQueries: ArrayList<String> = arrayListOf(
            """CREATE TABLE StudentGroup (
                Number TEXT NOT NULL PRIMARY KEY,
                NumberCyr TEXT,     -- Cyrillic name of a group --
                Year INTEGER,
                Specialization TEXT
            );""",

            """CREATE TABLE Student (
                BookID TEXT NOT NULL PRIMARY KEY,
                FirstName TEXT,
                SecondName TEXT,
                FatherName TEXT,
                StudentGroup TEXT,
                Login TEXT,
                Password TEXT,

                FOREIGN KEY(StudentGroup) REFERENCES StudentGroup(Number)
            );""",

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
            );"""
        )
        for (query: String in createTablesQueries) {
            db!!.execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println("The database \"was\" updated")
    }

    // specific selects to be added
}