package com.example.kioskproject

import com.example.kioskproject.model.Product

/// 주문 관련 페이지 처리
class OrderPage {

    // 주문하는 메뉴목록 확인 및 총 금액 표기
    fun printSelectedMenu(payment: Payment, choicedMenuList: List<Product>) {
        println("아래와 같이 주문하시겠습니까?")
        println("[ Orders ]")
        for(i in 0 until choicedMenuList.size) {
            println("${choicedMenuList[i].name} | ${choicedMenuList[i].price} | ${choicedMenuList[i].info}")
        }
        println("[ Total ]")
        payment.printPrice(choicedMenuList)
    }

    // 장바구니에 담은 메뉴가 있을경우 메인화면에 띄우는 메세지
    fun printOrderMenu() {
        println("\n[ORDER MENU]")
        println("9. Order | 장바구니를 확인 후 주문합니다.")
        println("10. Cancel | 진행중인 주문을 취소합니다.")
    }

    // 최종 주문선택창
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
}