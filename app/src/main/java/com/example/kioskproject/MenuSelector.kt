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
                //inputHandler(Burger.burgerList)
                var res = inputHandlerInt(Burger.burgerList)
                var price : Int = Burger.burgerList[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
            }

            2 -> {
                // MacLunch
                MacLunch.displayInfo()
                //inputHandler(MacLunch.macLunchList)
                var res = inputHandlerInt(MacLunch.macLunchList)
                var price : Int = MacLunch.macLunchList[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
            }

            3 -> {
                // MacMorning
                MacMorning.displayInfo()
                var res = inputHandlerInt(MacMorning.MacMorniningList)
                var price : Int = MacMorning.MacMorniningList[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
            }

            4 -> {
                // HappySnack
                happySnack.displayInfo()
                var res = inputHandlerInt(happySnack.happySnack)

                var recoInfo = RecommendInfo()
                recoInfo.showRecommendation()

                //var price : Int = happySnack.happySnack[(res)-1].price.toInt()
                //var payment = Payment(price)
                //payment.pay()
                //inputHandler(happySnack.happySnack)
            }

            5 -> {
                // Side&Dessert
                sideAndDessert.displayInfo()
                //inputHandler(sideAndDessert.sideAndDessert)
                var res = inputHandlerInt(sideAndDessert.sideAndDessert)
                var price : Int = sideAndDessert.sideAndDessert[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
            }

            6 -> {
                // McCafe&Drink
                mcCafeAndDrink.displayInfo()
                //inputHandler(mcCafeAndDrink.macCafeList)
                var res = inputHandlerInt(mcCafeAndDrink.macCafeList)
                var price : Int = mcCafeAndDrink.macCafeList[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
            }

            7 -> {
                // HappyMeal
                happyMeal.displayInfo()
                //inputHandler(happyMeal.happyMealList)
                var res = inputHandlerInt(happyMeal.happyMealList)
                var price : Int = happyMeal.happyMealList[(res)-1].price.toInt()
                var payment = Payment(price)
                payment.pay()
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
}