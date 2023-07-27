package com.example.kioskproject

import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString
import java.util.ArrayList
import kotlin.random.Random // 랜덤 생성

class RecommendInfo(res : Int) {
    var res : Int
    var DrinkAndMacCafe : DrinkAndMacCafe = DrinkAndMacCafe() //클래스에 instance를 만든다 = 메모리에 올린다
    var happySnack = HappySnack()

    // 선택한 메뉴를 저장할 리스트 생성
    var choicedMenuList = mutableListOf<Product>()
    // 싱글톤을 사용하면 객체가 한개니까 다른 함수나 클래스에서 사용해도 파일의 무결성이 지켜지지 않을까..?
    // companion object var choicedMenu = mutableListOf<Product>()
    init{
        this.res = res
    }
    fun showRecommendation() : MutableList<Product> {
        var randomNumber = (0..DrinkAndMacCafe.macCafeList.size-1).random() //랜덤 메뉴를 선택하기 위해 Random 클래스 생성 / 맥카페 리스트 개수
        var randomThree = mutableListOf<Product>() // 3개 랜덤

        println("[추천 메뉴를 확인하세요 -> a or b]")
        println("a. 추천 메뉴 보기")
        println("b. 담은 메뉴만 보기")

        val userInput = readLine()!!.toString()

        // 1. 추천메뉴
        if(userInput == "a"){
            println("[추천 메뉴]")

            for(i in 0..2){
                var randomMenu =
                    (0 until DrinkAndMacCafe.macCafeList.size - 1).random() // 0 ~ size(갯수)-1 中 랜덤으로 고른 하나
                var randomDrinkAndMacCafe =
                    DrinkAndMacCafe.macCafeList[randomMenu] // list 요소 ex) index[3] = 4
                randomThree.add(randomDrinkAndMacCafe)
                println("${randomMenu}. ${randomThree[i].name} | ${randomThree[i].price}원 | ${randomThree[i].info}")
            }


            // 추천메뉴를 보고 사용자로부터 값 입력 받음
            var choicedNumber: Int = readLine()!!.toInt()

            // 메뉴화면에서 선택한 메뉴 choicedMenuList에 추가
            choicedMenuList.add(happySnack.happySnack[(res)-1])
            // 추천메뉴에서 선택한 메뉴 choicedMenuList에 추가
            choicedMenuList.add(DrinkAndMacCafe.macCafeList[choicedNumber])

            // choicedMenuList에 담긴 값 출력 후 리스트 반환
            println("[장바구니에 담긴 상품]")
            for(i in 0 until choicedMenuList.size) {
                println("${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원")
            }
            return choicedMenuList
        }

        // 2. 선택한 메뉴
        else if(userInput == "b") {

            println("[선택한 메뉴]")
            // 메뉴화면에서 선택한 메뉴 choicedMenuList에 추가
            choicedMenuList.add(happySnack.happySnack[(res) - 1])
            // choicedMenuList에 담긴 값 출력 후 리스트 반환
            for (i in 0..choicedMenuList.size) {
                println("[장바구니에 담긴 상품]\n${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원")
            }
            return choicedMenuList
        }

        // 3.
        else {
            println("잘못된 입력입니다. 다시 선택해주세요.")
        }
        return choicedMenuList
    }
}

// === 복원용 코드 ===
//            try {
//                var choicedNumber: Int = readLine()!!.toInt()
//                choicedMenuList.add(DrinkAndMacCafe.macCafeList[choicedNumber])
//
//                for (i in 0..choicedMenuList.size) {
//                    println("[장바구니에 담긴 상품]\n${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원")
//                    return choicedMenuList
//                }
//            } catch(e: Exception){
//                println("")
//            }

//            try {
//                println("[선택한 메뉴]")
//                choicedMenuList.add(happySnack.happySnack[(res)-1])
//                for (i in 0..choicedMenuList.size) {
//                    println("[장바구니에 담긴 상품]\n${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원")
//                    return choicedMenuList
//                }
//                } catch (e: Exception) {
//
//                }
//            }
