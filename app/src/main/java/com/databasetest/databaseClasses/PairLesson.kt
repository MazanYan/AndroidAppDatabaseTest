package com.databasetest.databaseClasses

data class PairLesson(val id: Int,
                 val group: String,
                 val lectureHall: Int,
                 val lecturer: String,
                 val subject: String,
                 val day: Int,
                 val lessonNumber: Int) {
}