package com.databasetest.databaseClasses

data class Student(val login: String,
              val group: String,
              val password: String,
              val firstName: String,
              val secondName: String,
              val fatherName: String) {

    val fullName: String
        get() {
            return secondName + firstName + fatherName
        }
}