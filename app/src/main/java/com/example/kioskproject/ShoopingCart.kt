package com.example.kioskproject

import com.example.kioskproject.model.Product
import com.example.kioskproject.abstract.Display

class ShoppingCart : Display {
    var DrinkAndMacCafe = DrinkAndMacCafe()
    lateinit var listData: List<Product>

    // 선택한 메뉴를 저장할 리스트 생성
    var choicedMenuList = mutableListOf<Product>()

    fun run(selectedNum: Int, list: List<Product>) {
        // 배열 DeepCopy
        initListData(list)
        // Display Menu
        displayInfo()
        val userInput = readLine()!!.toString()
        // Handler 분기처리
        userInputHandler(userInput)
    }

    fun getRandomNumber(): MutableSet<Int> {
        var randomNumber = mutableSetOf<Int>()
        loop@ while (true) {
            randomNumber.add((0..DrinkAndMacCafe.macCafeList.size - 1).random()) //랜덤 메뉴를 선택하기 위해 Random 클래스 생성 / 맥카페 리스트 개수
            if (randomNumber.size == 3) break@loop
        }
        return randomNumber
    }

    fun userInputHandler(input: String) {
        // 1. 추천메뉴
        when (input) {
            "a" -> {
                printRecommandMenu()
                var choicedNumber: Int = readLine()!!.toInt()
                saveChoiceMenu(DrinkAndMacCafe.macCafeList, choicedNumber)
                // choicedMenuList에 담긴 값 출력 후 리스트 반환
                printShoppingCartList()
            }

            "b" -> {
                println("[선택한 메뉴]")
                printShoppingCartList()
            }

            else ->
                println("잘못된 입력입니다. 다시 선택해주세요.")
        }
    }

    fun printRecommandMenu() {
        var randomNumber = mutableSetOf<Int>()
        randomNumber = getRandomNumber()
        println("[추천 메뉴]\n")
        for (i in 0 until randomNumber.size) {
            println(
                "${randomNumber.elementAt(i)}. ${DrinkAndMacCafe.macCafeList[randomNumber.elementAt(i)].name} | ${
                    DrinkAndMacCafe.macCafeList[randomNumber.elementAt(
                        i
                    )].price
                }원 | ${DrinkAndMacCafe.macCafeList[randomNumber.elementAt(i)].info}"
            )
        }
    }

    fun printShoppingCartList() {
        println("[장바구니에 담긴 상품]")
        for (i in 0 until choicedMenuList.size) {
            println("${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원 | ${choicedMenuList[i]}")
        }
    }


    fun saveChoiceMenu(saveList: List<Product>, index: Int) =
        choicedMenuList.add(saveList[index - 1])


    fun initListData(list: List<Product>) {
        listData = list.map { it.copy() }
    }

    override fun displayTitle() {
        println("[추천 메뉴를 확인하세요 -> a or b]")
    }

    override fun displayInfo() {
        super.displayInfo()
        println("a. 추천 메뉴 보기")
        println("b. 담은 메뉴만 보기")

    }
}