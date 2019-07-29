package com.databasetest.databaseClasses

data class StudentGroup(val name: String,
                   val year: Int,
                   val specialization: String) {

    override fun toString() : String {
        return "StudentGroup:" +
                "\nname = " + name +
                "\nyear = " + year +
                "\nspecialization = " + specialization
    }
}