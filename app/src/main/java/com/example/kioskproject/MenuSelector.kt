package com.example.kioskproject

import com.example.kioskproject.util.GatherString
import java.lang.Exception
import java.util.Scanner
import kotlin.system.exitProcess

/// 메뉴 선택에 따른 분기처리 Handling
class MenuSelector{
    // HappyMeal
    var happyMeal: HappyMeal
    // McCafe
    var mcCafeAndDrink: DrinkAndMacCafe
    // HappySnack
    var happySnack: HappySnack
    // SideAndDessert
    var sideAndDessert: SideAndDessert
    init {
        happyMeal = HappyMeal()
        mcCafeAndDrink = DrinkAndMacCafe()
        happySnack = HappySnack()
        sideAndDessert = SideAndDessert()
    }

    // 실제 프로그램 분기 Handler
    fun handler(select: Int) {
        when (select) {
            1 -> {
                // Burger
                println(GatherString.develop)
            }

            2 -> {
                // MacLunch
                println(GatherString.develop)
            }

            3 -> {
                // MacMorning
                println(GatherString.develop)
            }

            4 -> {
                // HappySnack
                happySnack.displayInfo()
                happySnackHandler()

                // 결제 클래스 테스트
                //var paymentTest = Payment()
                //paymentTest.pay()
            }

            5 -> {
                // Side&Dessert
                sideAndDessert.displayInfo()
                sideAndDessertHandler()
            }


            6 -> {
                // McCafe&Drink
                mcCafeAndDrink.displayInfo()
                mcCafeDrinkHandler()
            }

            7 -> {
                // HappyMeal
                happyMeal.displayInfo()
                happyMealHandler()
            }

            8 -> {
                // Exit Program
                println(GatherString.exitProgram)
                exitProcess(0)
            }
        }
    }
    // 맥카페 입력 핸들러
    fun mcCafeDrinkHandler() {
        var scanner = Scanner(System.`in`)
        var res = scanner.nextInt()
        try {
            if (res < 0 || res > mcCafeAndDrink.macCafeList.size) {
                println(GatherString.exceptionNumber)
                mcCafeDrinkHandler()
            }
        } catch (e: Exception) {
            println(GatherString.exceptionError)
            mcCafeDrinkHandler()
        }
        //TODO 장바구니 기능추가
        //TODO 장바구니에 추가했을경우 메뉴판 && ORDER MENU 등장 아닐경우 처음 메뉴판만 띄우기
    }
    // 해피밀 입력 핸들러
   fun happyMealHandler() {
        var scanner = Scanner(System.`in`)
        var res = scanner.nextInt()
        try {
            if (res < 0 || res > happyMeal.happyMealList.size) {
                println(GatherString.exceptionNumber)
                happyMealHandler()
            }
        } catch (e: Exception) {
            println(GatherString.exceptionError)
            happyMealHandler()
        }
        //TODO 장바구니 기능추가
        //TODO 장바구니에 추가했을경우 메뉴판 && ORDER MENU 등장 아닐경우 처음 메뉴판만 띄우기
    }
    // 해피스낵 입력 핸들러
    fun happySnackHandler() {
        var scanner = Scanner(System.`in`)
        var res = scanner.nextInt()
        try {
            if (res < 0 || res > happySnack.happySnack.size) {
                println(GatherString.exceptionNumber)
                happyMealHandler()
            }
        } catch (e: Exception) {
            println(GatherString.exceptionError)
            happyMealHandler()
        }
        //TODO 장바구니 기능추가
        //TODO 장바구니에 추가했을경우 메뉴판 && ORDER MENU 등장 아닐경우 처음 메뉴판만 띄우기
    }
    // 사이드 앤 디저트 입력 핸들러
    fun sideAndDessertHandler() {
        var scanner = Scanner(System.`in`)
        var res = scanner.nextInt()
        try {
            if (res < 0 || res > sideAndDessert.sideAndDessert.size) {
                println(GatherString.exceptionNumber)
                happyMealHandler()
            }
        } catch (e: Exception) {
            println(GatherString.exceptionError)
            happyMealHandler()
        }
        //TODO 장바구니 기능추가
        //TODO 장바구니에 추가했을경우 메뉴판 && ORDER MENU 등장 아닐경우 처음 메뉴판만 띄우기
    }

}