package com.example.kioskproject

import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString
import java.util.ArrayList
import kotlin.random.Random // 랜덤 생성

class RecommendInfo {
    var DrinkAndMacCafe : DrinkAndMacCafe = DrinkAndMacCafe() //클래스에 instance를 만든다 = 메모리에 올린다
    var SideAndDessert : SideAndDessert = SideAndDessert()

    // 선택한 메뉴를 저장할 리스트 생성
    var choicedMenu = mutableListOf<Product>()
    // 싱글톤을 사용하면 객체가 한개니까 다른 함수나 클래스에서 사용해도 파일의 무결성이 지켜지지 않을까..?
    // companion object var choicedMenu = mutableListOf<Product>()

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
            try {
                var choicedNumber: Int = readLine()!!.toInt()
                choicedMenu.add(DrinkAndMacCafe.macCafeList[choicedNumber])

                for (i in 0..choicedMenu.size) {
                    println("[장바구니에 담긴 상품]\n${i + 1}. ${choicedMenu[i].name} | ${choicedMenu[i].price}원")
                }
            } catch(e: Exception){
                println("")
            }

        }

        else if (userInput == "b") {
            try {
                println("[선택한 메뉴]")
                for (i in 0..choicedMenu.size) {
                    println("[장바구니에 담긴 상품]\n${i + 1}. ${choicedMenu[i].name} | ${choicedMenu[i].price}원")
                }
            } catch (e: Exception) {

            }
        }

        else {
            println("잘못된 입력입니다. 다시 선택해주세요.")
        }

    }
}