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

    var recommendInfo: RecommendInfo

    var res: Int = 0
    lateinit var recoInfo: RecommendInfo


    init {
        MacMorning = MacMorning()
        MacLunch = MacLunch()
        Burger = Burger()
        happyMeal = HappyMeal()
        mcCafeAndDrink = DrinkAndMacCafe()
        happySnack = HappySnack()
        sideAndDessert = SideAndDessert()
        recommendInfo = RecommendInfo()
    }

    // 실제 프로그램 분기 Handler
    fun handler(select: Int) {
        when (select) {
            1 -> {
                // Burger
                Burger.displayInfo()
                res = inputHandlerInt(Burger.burgerList)
                recommendInfo.initListData(Burger.burgerList)

                var choicedMenuList = recoInfo.showRecommendation()
                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            2 -> {
                // MacLunch
                MacLunch.displayInfo()
                res = inputHandlerInt(MacLunch.macLunchList)

                recommendInfo.initListData(Burger.burgerList)

                var choicedMenuList = recoInfo.showRecommendation()
                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            3 -> {
                // MacMorning
                MacMorning.displayInfo()
                res = inputHandlerInt(MacMorning.MacMorniningList)

                recommendInfo.initListData(Burger.burgerList)

                // 쇼핑카트 객체 생성
                recoInfo = RecommendInfo(res, MacMorning.MacMorniningList)
                var choicedMenuList = recoInfo.showRecommendation()
                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }


            4 -> {
                // HappySnack
                happySnack.displayInfo()
                res = inputHandlerInt(happySnack.happySnack)

                recommendInfo.initListData(Burger.burgerList)

                recoInfo = RecommendInfo(res, happySnack.happySnack)
                var choicedMenuList = recoInfo.showRecommendation()
                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            5 -> {
                // Side&Dessert
                sideAndDessert.displayInfo()
                res = inputHandlerInt(sideAndDessert.sideAndDessert)
                recommendInfo.initListData(Burger.burgerList)
                var choicedMenuList = recoInfo.showRecommendation()
                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            6 -> {
                // McCafe&Drink
                mcCafeAndDrink.displayInfo()
                res = inputHandlerInt(mcCafeAndDrink.macCafeList)

                recommendInfo.initListData(Burger.burgerList)
                var choicedMenuList = recoInfo.showRecommendation()

                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
                }
                var payment = Payment(price)
                payment.pay()
            }

            7 -> {
                // HappyMeal
                happyMeal.displayInfo()
                res = inputHandlerInt(happyMeal.happyMealList)

                recommendInfo.initListData(Burger.burgerList)
                var choicedMenuList = recoInfo.showRecommendation()
                var price = 0
                for (i in 0 until choicedMenuList.size) {
                    price += choicedMenuList[i].price.toInt()
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