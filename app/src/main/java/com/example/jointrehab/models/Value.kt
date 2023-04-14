package com.example.jointrehab.models

data class Value(
    val anglex: String ="",
    val angley: String="",
    val readings: Readings = Readings("","","","","","")
)