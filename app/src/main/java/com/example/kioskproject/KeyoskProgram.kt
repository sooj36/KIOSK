package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.abstract.InputHandler
import com.example.kioskproject.util.GatherString
import java.util.Scanner

// KEYOSK 메인 프로그램
class KeyoskProgram : Display, InputHandler {
    val title1 = "\"맥도날드 18호점에 오신것을 환영합니다\" \n 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n\n"
    val title2 = "[맥도날드 18호점 MENU]\n"
    val title3 =
        " 1. Burger\n 2. MacLunch\n 3. MacMorning\n 4. HappySnack\n 5. Side&Dessert\n 6. McCafe&Drink\n 7. HappyMeal\n 8. 프로그램 종료"
    var selectMenu: Int = -1

    // 메뉴동작을 관리하는 클레스
    var menuSelector: MenuSelector

    init{
        menuSelector = MenuSelector()
    }

    fun run() {
        while (true) {
            displayInfo()
            selectMenu = intInputHandler()
            menuSelector.handler(selectMenu)
        }
    }

    override fun displayTitle() {
        println("$title1$title2$title3 ")
    }

    // title1, 2, 3 출력
    override fun displayInfo() {
        super.displayInfo()
    }

    // 사용자로부터 입력받은 메뉴 예외검사
    override fun intInputHandler(): Int {
        var scanner = Scanner(System.`in`)
        var input = scanner.nextInt()
        try {
            if (input < 1 || input > 8 ) {
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