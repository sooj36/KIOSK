package com.example.kioskproject

import com.example.kioskproject.abstract.InputHandler
import com.example.kioskproject.util.GatherString
import java.lang.Exception
import java.util.Scanner
import kotlin.system.exitProcess

/// 메뉴 선택에 따른 분기처리 Handling
class MenuSelector : InputHandler {
    var MacMorning: MacMorning
    var MacLunch: MacLunch
    var Burger: Burger
    var happyMeal: HappyMeal
    var mcCafeAndDrink: DrinkAndMacCafe
    var happySnack: HappySnack
    var sideAndDessert: SideAndDessert
    var shoppingCart: ShoppingCart
    var payment: Payment

    var res: Int = 0
    lateinit var recoInfo: ShoppingCart


    init {
        MacMorning = MacMorning()
        MacLunch = MacLunch()
        Burger = Burger()
        happyMeal = HappyMeal()
        mcCafeAndDrink = DrinkAndMacCafe()
        happySnack = HappySnack()
        sideAndDessert = SideAndDessert()
        shoppingCart = ShoppingCart()
        payment = Payment()
    }

    // 실제 프로그램 분기 Handler
    fun handler(select: Int) {
        when (select) {
            1 -> {
                // Burger
                Burger.displayInfo()
                res = inputHandlerInt(Burger.burgerList)

                shoppingCart.saveChoiceMenu(Burger.burgerList, res)
                shoppingCart.run(res, Burger.burgerList)
                payment.pay(shoppingCart.choicedMenuList)
            }

            2 -> {
                // MacLunch
                MacLunch.displayInfo()
                res = inputHandlerInt(MacLunch.macLunchList)

                shoppingCart.saveChoiceMenu(MacLunch.macLunchList, res)
                shoppingCart.run(res, MacLunch.macLunchList)
                payment.pay(shoppingCart.choicedMenuList)
            }

            3 -> {
                // MacMorning
                MacMorning.displayInfo()
                res = inputHandlerInt(MacMorning.MacMorniningList)

                shoppingCart.saveChoiceMenu(MacMorning.MacMorniningList, res)
                shoppingCart.run(res, MacMorning.MacMorniningList)
                payment.pay(shoppingCart.choicedMenuList)

            }


            4 -> {
                // HappySnack
                happySnack.displayInfo()
                res = inputHandlerInt(happySnack.happySnack)

                shoppingCart.saveChoiceMenu(happySnack.happySnack, res)
                shoppingCart.run(res, happySnack.happySnack)
                payment.pay(shoppingCart.choicedMenuList)

            }

            5 -> {
                // Side&Dessert
                sideAndDessert.displayInfo()
                res = inputHandlerInt(sideAndDessert.sideAndDessert)

                shoppingCart.saveChoiceMenu(sideAndDessert.sideAndDessert, res)
                shoppingCart.run(res, sideAndDessert.sideAndDessert)
                payment.pay(shoppingCart.choicedMenuList)

            }

            6 -> {
                // McCafe&Drink
                mcCafeAndDrink.displayInfo()
                res = inputHandlerInt(mcCafeAndDrink.macCafeList)

                shoppingCart.saveChoiceMenu(mcCafeAndDrink.macCafeList, res)
                shoppingCart.run(res, mcCafeAndDrink.macCafeList)
                payment.pay(shoppingCart.choicedMenuList)

            }

            7 -> {
                // HappyMeal
                happyMeal.displayInfo()
                res = inputHandlerInt(happyMeal.happyMealList)

                shoppingCart.saveChoiceMenu(happyMeal.happyMealList, res)
                shoppingCart.run(res, happyMeal.happyMealList)
                payment.pay(shoppingCart.choicedMenuList)

            }

            8 -> {
                // Exit Program
                println(GatherString.exitProgram)
                exitProcess(0)
            }
        }
    }

    override fun <T> inputHandlerInt(list: List<T>): Int {
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