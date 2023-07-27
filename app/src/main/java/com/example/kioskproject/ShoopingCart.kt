package com.example.kioskproject

import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString
import java.util.ArrayList
import kotlin.random.Random // 랜덤 생성
import com.example.kioskproject.abstract.Display

class RecommendInfo() : Display {
    var DrinkAndMacCafe = DrinkAndMacCafe()
    lateinit var listData : List<Product>

    // 선택한 메뉴를 저장할 리스트 생성
    var choicedMenuList = mutableListOf<Product>()

    fun showRecommendation(selectedNum: Int, list: List<Product>): MutableList<Product> {

        val userInput = readLine()!!.toString()


        return choicedMenuList
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

                // 추천메뉴를 보고 사용자로부터 값 입력 받음
                var choicedNumber: Int = readLine()!!.toInt()

                // 메뉴화면에서 선택한 메뉴 choicedMenuList에 추가
                choicedMenuList.add(list[(selectedNum) - 1])
                // 추천메뉴에서 선택한 메뉴 choicedMenuList에 추가
                choicedMenuList.add(DrinkAndMacCafe.macCafeList[choicedNumber])

                // choicedMenuList에 담긴 값 출력 후 리스트 반환
                println("[장바구니에 담긴 상품]")
                for (i in 0 until choicedMenuList.size) {
                    println("${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원")
                }
            }

            "b" -> {
                println("[선택한 메뉴]")
                // 메뉴화면에서 선택한 메뉴 choicedMenuList에 추가
                choicedMenuList.add(list[(selectedNum) - 1])
                // choicedMenuList에 담긴 값 출력 후 리스트 반환
                for (i in 0 until choicedMenuList.size) {
                    println("[장바구니에 담긴 상품]\n${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원")
                }
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
                    println("${i+1}. ${DrinkAndMacCafe.macCafeList[randomNumber.indexOf(i)].name} | ${DrinkAndMacCafe.macCafeList[randomNumber.indexOf(i)].price}원 | ${DrinkAndMacCafe.macCafeList[randomNumber.indexOf(i)].info}")
                }
    }

    fun initListData(list: List<Product>){
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