package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.abstract.InputHandler
import com.example.kioskproject.util.GatherString
import java.util.Scanner

// KEYOSK 메인 프로그램
class KeyoskProgram : Display, InputHandler {

    val title1 = "\"맥도날드 18호점에 오신것을 환영합니다\" \n 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n\n"
    val title2 = "[맥도날드 18호점 MENU]"
    val title3 = " 1. Burger\n 2. MacLunch\n 3. MacMorning\n 4. HappySnack\n 5. Side&Dessert\n 6. McCafe&Drink\n 7. HappyMeal\n 8. 프로그램 종료"

    // 메뉴동작을 관리하는 클레스
    var menuSelector: MenuSelector = MenuSelector()

    fun run() {
        while (true) {
            displayInfo()
            if(menuSelector.shoppingCart.choicedMenuList.isNotEmpty()) {
                menuSelector.orderPage.printOrderMenu()
            }
            menuSelector.handler(intInputHandler())
        }
    }

    override fun displayTitle() {
        println("$title1$title2")
    }

    // title1, 2, 3 출력
    override fun displayInfo() {
        super.displayInfo()
        println(title3)
    }

    // 사용자로부터 입력받은 메뉴 예외검사
    override fun intInputHandler(): Int {
        var scanner = Scanner(System.`in`)
        var input = scanner.nextInt()
        var length = if(menuSelector.shoppingCart.choicedMenuList.isNotEmpty()) 10 else 8
        try {
            if (input < 1 || input > length ) {
            println(GatherString.exceptionNumber)
            intInputHandler()
        }
        }catch (e:Exception) {
            println(GatherString.exceptionError)
            intInputHandler()
        }
        return input
    }
}