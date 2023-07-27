package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.abstract.InputHandler
import com.example.kioskproject.model.Product
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
                isEmptyShoppingCart<Burger>(Burger, Burger.burgerList)
            }

            2 -> {
                // MacLunch
                isEmptyShoppingCart<MacLunch>(MacLunch, MacLunch.macLunchList)
            }

            3 -> {
                // MacMorning
                isEmptyShoppingCart<MacMorning>(MacMorning, MacMorning.MacMorniningList)
            }


            4 -> {
                // HappySnack
                isEmptyShoppingCart<HappySnack>(happySnack, happySnack.happySnackList)
            }

            5 -> {
                // Side&Dessert
                isEmptyShoppingCart<SideAndDessert>(
                    sideAndDessert,
                    sideAndDessert.sideAndDessertList
                )
            }

            6 -> {
                // McCafe&Drink
                isEmptyShoppingCart<DrinkAndMacCafe>(mcCafeAndDrink, mcCafeAndDrink.macCafeList)

            }

            7 -> {
                // HappyMeal
                isEmptyShoppingCart<HappyMeal>(happyMeal, happyMeal.happyMealList)
            }

            8 -> {
                // Exit Program
                println(GatherString.exitProgram)
                exitProcess(0)
            }

            9 -> {
                shoppingCart.printConfirmOrder(payment)
                shoppingCart.displayInfo()
                shoppingCart.userInputHandler()
                shoppingCart.finalOrderConfirm(payment)
            }

            10 -> {
                shoppingCart.choicedMenuList.clear()
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
    }

    fun <T> isEmptyShoppingCart(instance: Display, list: List<Product>) {
        instance.displayInfo()
        res = inputHandlerInt(list)
        if (res == 0) {
            return
        } else {
            shoppingCart.savePopup(list, res)
        }
    }

}