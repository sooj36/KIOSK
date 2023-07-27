package com.example.kioskproject

import com.example.kioskproject.abstract.InputHandler
import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString
import java.lang.Exception
import java.util.Scanner
import kotlin.system.exitProcess

/// 메뉴 선택에 따른 분기처리 Handling
class MenuSelector : InputHandler {
    // MacMorining
    var MacMorning: MacMorning

    // MacLunch
    var MacLunch: MacLunch

    //Burger
    var Burger: Burger

    // HappyMeal
    var happyMeal: HappyMeal

    // McCafe
    var mcCafeAndDrink: DrinkAndMacCafe

    // HappySnack
    var happySnack: HappySnack
  
    // SideAndDessert
    var sideAndDessert: SideAndDessert

    var res : Int = 0
    lateinit var recoInfo : RecommendInfo

    var price : Int = 0

    init {
        MacMorning = MacMorning()
        MacLunch = MacLunch()
        Burger = Burger()
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
                Burger.displayInfo()
                inputHandler(Burger.burgerList)
            }

            2 -> {
                // MacLunch
                MacLunch.displayInfo()
                inputHandler(MacLunch.macLunchList)
            }

            3 -> {
                // MacMorning
                MacMorning.displayInfo()
                inputHandler(MacMorning.MacMorniningList)
            }

            4 -> {
                // HappySnack
                happySnack.displayInfo()
                res = inputHandlerInt(happySnack.happySnack)

                // 쇼핑카트 객체 생성
                recoInfo = RecommendInfo(res)
                var choicedMenuList = recoInfo.showRecommendation()
                // choicedMenuList 값이 잘 담겼나 확인용 코드
                // println("${choicedMenuList.toString()}")

                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            5 -> {
                // Side&Dessert
                sideAndDessert.displayInfo()
                //inputHandler(sideAndDessert.sideAndDessert)
                var res = inputHandlerInt(sideAndDessert.sideAndDessert)
                price  = sideAndDessert.sideAndDessert[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
            }

            6 -> {
                // McCafe&Drink
                mcCafeAndDrink.displayInfo()
                inputHandler(mcCafeAndDrink.macCafeList)
            }

            7 -> {
                // HappyMeal
                happyMeal.displayInfo()
                inputHandler(happyMeal.happyMealList)
            }

            8 -> {
                // Exit Program
                println(GatherString.exitProgram)
                exitProcess(0)
            }
        }
    }
    override fun <T> inputHandlerInt(list: List<T>) : Int {
        var scanner = Scanner(System.`in`)
        var res = scanner.nextInt()
        try {
            if (res < 0 || res > list.size) {
                println(GatherString.exceptionNumber)
                inputHandlerInt<T>(list)
            }
        } catch (e: Exception) {
            println(GatherString.exceptionError)
            inputHandlerInt<T>(list)
        }
        return res

        //TODO 장바구니 기능추가
        //TODO 장바구니에 추가했을경우 메뉴판 && ORDER MENU 등장 아닐경우 처음 메뉴판만 띄우기
    }

    override fun <T> inputHandler(list: List<T>) {
        var scanner = Scanner(System.`in`)
        res = scanner.nextInt()
        try {
            if (res < 0 || res > list.size) {
                println(GatherString.exceptionNumber)
                inputHandler<T>(list)
            }
        } catch (e: Exception) {
            println(GatherString.exceptionError)
            inputHandler<T>(list)
        }
        //TODO 장바구니 기능추가
        //TODO 장바구니에 추가했을경우 메뉴판 && ORDER MENU 등장 아닐경우 처음 메뉴판만 띄우기
    }
}