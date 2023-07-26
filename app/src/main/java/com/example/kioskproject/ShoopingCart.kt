package com.example.kioskproject

import com.example.kioskproject.model.Product
import java.util.ArrayList
import kotlin.random.Random // 랜덤 생성

class RecommendInfo {
    var DrinkAndMacCafe : DrinkAndMacCafe = DrinkAndMacCafe() //클래스에 instance를 만든다 = 메모리에 올린다
    var SideAndDessert : SideAndDessert = SideAndDessert()

    fun showRecommendation() {
        var randomNumber = (0..DrinkAndMacCafe.macCafeList.size-1).random() //랜덤 메뉴를 선택하기 위해 Random 클래스 생성 / 맥카페 리스트 개수
        var randomThree = mutableListOf<Product>() // 3개 랜덤


        println("[추천 메뉴를 확인하세요 -> a or b]")
            println("a. 추천 메뉴 보기")
            println("b. 담은 메뉴만 보기")

        val userInput = readLine()!!.toString()

        if (userInput == "a") {
            println("[추천 메뉴]")

            for (i in 0..2) {
                var randomMenu = (0 until DrinkAndMacCafe.macCafeList.size-1).random() // 0 ~ size(갯수)-1 中 랜덤으로 고른 하나
                var randomDrinkAndMacCafe = DrinkAndMacCafe.macCafeList[randomMenu] // list 요소 ex) index[3] = 4
                randomThree.add(randomDrinkAndMacCafe)
                println("${randomMenu}. ${randomThree[i].name} | ${randomThree[i].price} | ${randomThree[i].info}")
            }
        }
        else if (userInput == "b") {
            println("[선택한 메뉴]")
        }
        else {
            println("잘못된 입력입니다. 다시 선택해주세요.")
        }
    }
}