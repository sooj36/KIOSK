package com.example.kioskproject.abstract

interface Display {
    fun displayTitle()
    fun displayInfo(){
        displayTitle()
    }
}