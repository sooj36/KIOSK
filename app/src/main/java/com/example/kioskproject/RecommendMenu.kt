package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.util.GatherString

/// 추천메뉴
class RecommendMenu : Display {
    var DrinkAndMacCafe = DrinkAndMacCafe()

    // 추천메뉴를 볼지 선택한메뉴만 주문할지 선택하는 페이지
    fun recommendInputHandler(shoppingCart: ShoppingCart) {
        var input = readLine() ?: ""
        when (input) {
            "a" -> {
                printRecommandMenu()
                var choicedNumber: Int = readLine()!!.toInt()
                if (choicedNumber == 0) {
                    displayInfo()
                    recommendInputHandler(shoppingCart)
                } else {
                    shoppingCart.saveChoiceMenu(DrinkAndMacCafe.list, choicedNumber)
                    shoppingCart.printShoppingCartList()
                }
            }

            "b" -> {
                println("[선택한 메뉴]")
                shoppingCart.printShoppingCartList()
            }

            else -> {
                println(GatherString.exceptionError)
                this.recommendInputHandler(shoppingCart)
            }
        }
    }


    // 추천메뉴 print
    fun printRecommandMenu() {
        var randomNumber = mutableSetOf<Int>()
        randomNumber = getRandomNumber()
        println("[추천 메뉴]\n")
        for (i in 0 until randomNumber.size) {
            println(
                "${randomNumber.elementAt(i)}. ${
                    DrinkAndMacCafe.list[randomNumber.elementAt(
                        i
                    )].name
                } | ${
                    DrinkAndMacCafe.list[randomNumber.elementAt(
                        i
                    )].price
                }원 | ${DrinkAndMacCafe.list[randomNumber.elementAt(i)].info}"
            )
        }
        println(GatherString.backTxt)
    }

    // 최종 주문선택창
    fun finalOrderConfirm(payment: Payment) {
        println("1. 주문                2. 메뉴판")
        var input = readLine()!!.toInt()
        var userMoney = (5000..100000).random()
        when (input) {
            1 -> payment.pay()
            2 -> {}
            else -> {

            }
        }
    }

    override fun displayTitle() {
        println("[ 추천 메뉴를 확인하세요 -> a or b ]")
    }

    override fun displayInfo() {
        super.displayInfo()
        println("a. 추천 메뉴 보기")
        println("b. 담은 메뉴만 주문하기")
    }

    // 겹치지 않는 랜덤한 숫자를 뽑아 Drink메뉴 추천시 index로 사용
    fun getRandomNumber(): MutableSet<Int> {
        var randomNumber = mutableSetOf<Int>()
        loop@ while (true) {
            randomNumber.add((0..DrinkAndMacCafe.list.size - 1).random()) //랜덤 메뉴를 선택하기 위해 Random 클래스 생성 / 맥카페 리스트 개수
            if (randomNumber.size == 3) break@loop
        }
        return randomNumber
    }

}