package com.example.kioskproject

import com.example.kioskproject.model.Product
import com.example.kioskproject.abstract.Display
import com.example.kioskproject.util.GatherString

class ShoppingCart : Display {
    var DrinkAndMacCafe = DrinkAndMacCafe()

    // 선택한 메뉴를 저장할 리스트 생성
    var choicedMenuList = mutableListOf<Product>()

    fun getRandomNumber(): MutableSet<Int> {
        var randomNumber = mutableSetOf<Int>()
        loop@ while (true) {
            randomNumber.add((0..DrinkAndMacCafe.macCafeList.size - 1).random()) //랜덤 메뉴를 선택하기 위해 Random 클래스 생성 / 맥카페 리스트 개수
            if (randomNumber.size == 3) break@loop
        }
        return randomNumber
    }

    fun userInputHandler() {
        var input = readLine() ?: ""
        when (input) {
            "a" -> {
                printRecommandMenu()
                var choicedNumber: Int = readLine()!!.toInt()
                saveChoiceMenu(DrinkAndMacCafe.macCafeList, choicedNumber)
                printShoppingCartList()
            }

            "b" -> {
                println("[선택한 메뉴]")
                printShoppingCartList()
            }
            else -> {
                println(GatherString.exceptionError)
                userInputHandler()
            }
        }
    }

    fun finalOrderConfirm(payment: Payment) {
        println("1. 주문                2. 메뉴판")
        var input = readLine()!!.toInt()
        var userMoney = (5000 ..100000).random()
        when(input) {
            1 -> payment.pay()
            2 -> {}
            else -> {

            }
        }
    }

    fun printOrderMenu() {
        println("\n[ORDER MENU]")
        println("9. Order | 장바구니를 확인 후 주문합니다.")
        println("10. Cancel | 진행중인 주문을 취소합니다.")
    }

    fun printOrderdMenus(payment: Payment) {
        println("아래와 같이 주문하시겠습니까?")
        println("[ Orders ]")
        for(i in 0 until choicedMenuList.size) {
            println("${choicedMenuList[i].name} | ${choicedMenuList[i].price} | ${choicedMenuList[i].info}")
        }
        println("[ Total ]")
       payment.printPrice(choicedMenuList)
    }

    fun printRecommandMenu() {
        var randomNumber = mutableSetOf<Int>()
        randomNumber = getRandomNumber()
        println("[추천 메뉴]\n")
        for (i in 0 until randomNumber.size) {
            println(
                "${randomNumber.elementAt(i)}. ${
                    DrinkAndMacCafe.macCafeList[randomNumber.elementAt(
                        i
                    )].name
                } | ${
                    DrinkAndMacCafe.macCafeList[randomNumber.elementAt(
                        i
                    )].price
                }원 | ${DrinkAndMacCafe.macCafeList[randomNumber.elementAt(i)].info}"
            )
        }
    }

    fun printShoppingCartList() {
        println("[ 장바구니에 담긴 상품 ]")
        for (i in 0 until choicedMenuList.size) {
            println("${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원 | ${choicedMenuList[i]}")
        }
    }

    fun savePopup(selectedList: List<Product>, index: Int) {
        println("${selectedList[index].name} | ${selectedList[index].price}원 | ${selectedList[index]}")
        println("위 메뉴를 장바구니에 추가하시겠습니까?")
        println("1. 확인                2. 취소")
        var input = readLine()!!.toInt()
        when (input) {
            1 -> {
                saveChoiceMenu(selectedList, index)
                println("${selectedList[index].name} 가 장바구니에 추가되었습니다.\n")
            }

            2 -> return
            else -> {
                println(GatherString.exceptionError)
                savePopup(selectedList, index)
            }
        }
    }

    fun saveChoiceMenu(saveList: List<Product>, index: Int) =
        choicedMenuList.add(saveList[index - 1])


    override fun displayTitle() {
        println("[ 추천 메뉴를 확인하세요 -> a or b ]")
    }

    override fun displayInfo() {
        super.displayInfo()
        println("a. 추천 메뉴 보기")
        println("b. 담은 메뉴만 주문하기")

    }
}