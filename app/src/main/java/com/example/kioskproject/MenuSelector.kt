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
    var macMorning: MacMorning
    var macLunch: MacLunch
    var burger: Burger
    var happyMeal: HappyMeal
    var mcCafeAndDrink: DrinkAndMacCafe
    var happySnack: HappySnack
    var sideAndDessert: SideAndDessert
    var shoppingCart: ShoppingCart
    var recommendMenu : RecommendMenu
    var orderPage : OrderPage
    var payment: Payment

    var res: Int = 0
    lateinit var recoInfo: ShoppingCart
    lateinit var menuList: MutableMap<String, List<Product>>

    init {
        macMorning = MacMorning()
        macLunch = MacLunch()
        burger = Burger()
        happyMeal = HappyMeal()
        mcCafeAndDrink = DrinkAndMacCafe()
        happySnack = HappySnack()
        sideAndDessert = SideAndDessert()
        shoppingCart = ShoppingCart()
        recommendMenu = RecommendMenu()
        orderPage = OrderPage()
        payment = Payment()

        initMenuList()
    }

    // 전체메뉴 데이터init
    fun initMenuList() {
        menuList = mutableMapOf(
            macMorning.javaClass.simpleName to macMorning.list,
            macLunch.javaClass.simpleName to macLunch.list,
            burger.javaClass.simpleName to burger.list,
            happyMeal.javaClass.simpleName to happyMeal.list,
            mcCafeAndDrink.javaClass.simpleName to mcCafeAndDrink.list,
            happySnack.javaClass.simpleName to happySnack.list,
            sideAndDessert.javaClass.simpleName to sideAndDessert.list
        )
    }

    // 실제 프로그램 분기 Handler
    fun handler(select: Int) {
        when (select) {
            1 -> {
                // Burger
                runSelectedMenu<Burger>(burger, menuList.getValue(burger.javaClass.simpleName))
            }

            2 -> {
                // MacLunch
                runSelectedMenu<MacLunch>(
                    macLunch,
                    menuList.getValue(macLunch.javaClass.simpleName)
                )
            }

            3 -> {
                // MacMorning
                runSelectedMenu<MacMorning>(
                    macMorning,
                    menuList.getValue(macMorning.javaClass.simpleName)
                )
            }


            4 -> {
                // HappySnack
                runSelectedMenu<HappySnack>(
                    happySnack,
                    menuList.getValue(happySnack.javaClass.simpleName)
                )
            }

            5 -> {
                // Side&Dessert
                runSelectedMenu<SideAndDessert>(
                    sideAndDessert,
                    menuList.getValue(sideAndDessert.javaClass.simpleName)
                )
            }

            6 -> {
                // McCafe&Drink
                runSelectedMenu<DrinkAndMacCafe>(
                    mcCafeAndDrink,
                    menuList.getValue(mcCafeAndDrink.javaClass.simpleName)
                )

            }

            7 -> {
                // HappyMeal
                runSelectedMenu<HappyMeal>(
                    happyMeal,
                    menuList.getValue(happyMeal.javaClass.simpleName)
                )
            }

            8 -> {
                // Exit Program
                println(GatherString.exitProgram)
                exitProcess(0)
            }

            9 -> {
                orderPage.printSelectedMenu(payment, shoppingCart.choicedMenuList)
                recommendMenu.displayInfo()
                recommendMenu.recommendInputHandler(shoppingCart)
                orderPage.finalOrderConfirm(payment)
            }

            10 -> {
                shoppingCart.choicedMenuList.clear()
            }
        }
    }

    override fun inputHandlerInt(list: List<Product>): Int {
        var scanner = Scanner(System.`in`)
        var res = scanner.nextInt()
        try {
            if (res < 0 || res > list.size) {
                println(GatherString.exceptionNumber)
            }
        } catch (e: Exception) {
            handler(res)
            println(GatherString.exceptionError)
        }
        return res
    }

    // 선택된 메뉴 장바구니추가 선택팝업 띄워줌
    fun <T> runSelectedMenu(instance: Display, list: List<Product>) {
        instance.displayInfo()
        res = inputHandlerInt(list)
        if (res == 0) {
            return
        } else {
            shoppingCart.savePopup(list, res)
        }
    }
}