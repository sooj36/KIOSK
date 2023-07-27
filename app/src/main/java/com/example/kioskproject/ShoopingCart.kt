package com.example.kioskproject

import com.example.kioskproject.model.Product
import com.example.kioskproject.abstract.Display
import com.example.kioskproject.util.GatherString

class ShoppingCart {
    // 선택한 메뉴를 저장할 리스트 생성
    var choicedMenuList = mutableListOf<Product>()

    // 장바구니에 존재하는 상품목록 print
    fun printShoppingCartList() {
        println("[ 장바구니에 담긴 상품 ]")
        for (i in 0 until choicedMenuList.size) {
            println("${i + 1}. ${choicedMenuList[i].name} | ${choicedMenuList[i].price}원 | ${choicedMenuList[i]}")
        }
    }

    // 장바구니에 메뉴저장 처리
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

    // 선택메뉴 저장
    fun saveChoiceMenu(saveList: List<Product>, index: Int) =
        choicedMenuList.add(saveList[index - 1])
}