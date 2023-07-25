package com.example.kioskproject

fun main(){
    println("1. 식사하실 장소를 선택해주세요.")
        println("a. 매장")
        println("b. 테이크 아웃")
        var place = readLine()?.toString() ?: "장소를 선택해주세요"

        if(place == "a"){
            //매장식사
        }
        else if(place == "b"){
            //테이크아웃
        }
}
