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

    lateinit var shopingCart : ShopingCart



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
                res = inputHandlerInt(Burger.burgerList)

                // 쇼핑카트 객체 생성
                shopingCart = ShopingCart(res, Burger.burgerList )
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            2 -> {
                // MacLunch
                MacLunch.displayInfo()
                res = inputHandlerInt(MacLunch.macLunchList)

                // 쇼핑카트 객체 생성
                shopingCart = ShopingCart(res, MacLunch.macLunchList )
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            3 -> {
                // MacMorning
                MacMorning.displayInfo()
                res = inputHandlerInt(MacMorning.MacMorniningList)

                // 쇼핑카트 객체 생성
                shopingCart = ShopingCart(res, MacMorning.MacMorniningList )
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            4 -> {
                // HappySnack
                happySnack.displayInfo()
                res = inputHandlerInt(happySnack.happySnack)

                // 쇼핑카트 객체 생성
                shopingCart = ShopingCart(res, happySnack.happySnack )
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            5 -> {
                // Side&Dessert
                sideAndDessert.displayInfo()
                res = inputHandlerInt(sideAndDessert.sideAndDessert)

                shopingCart = ShopingCart(res, sideAndDessert.sideAndDessert)
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            6 -> {
                // McCafe&Drink
                mcCafeAndDrink.displayInfo()
                res = inputHandlerInt(mcCafeAndDrink.macCafeList)

                shopingCart = ShopingCart(res, mcCafeAndDrink.macCafeList)
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            7 -> {
                // HappyMeal
                happyMeal.displayInfo()
                res = inputHandlerInt(happyMeal.happyMealList)

                shopingCart = ShopingCart(res, happyMeal.happyMealList)
                var choicedMenuList = shopingCart.showCart()
                var price = 0
                for(i in 0 until choicedMenuList.size){
                    price +=  choicedMenuList[i].price.toInt()
                }
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
    }
}