package com.example.kioskproject

import com.example.kioskproject.model.Product
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.ChoiceFormat
import java.util.Random
import kotlin.system.exitProcess

class Payment() {
    var price: Int = 0
    var random = Random()

    // 고객번호 랜덤 생성 변수(0 ~ 1000)
    var customerNum: Int = random.nextInt(1000)

    // 조리시간 랜덤 생성 변수(0 ~ 30분)
    var cookingTime: Int = random.nextInt(30)

    fun pay() {
        println("결제 방식을 선택해주세요.\na. 현금 \nb. 신용카드")

        var payOption = readLine()!!.toString()
        var userMoney = (5000..50000).random()
        when (payOption) {
            // 현금 결제
            "a" -> {
                if (price > userMoney) {
                    println("현재 잔액은 $userMoney 이므로 ${price - userMoney}원이 부족해서 주문할 수 없습니다.")
                } else {
                    println(
                        "주문번호 ${customerNum}번 고객님 ${cookingTime}분 후 음식이 완료될 예정입니다.\n" +
                                "\n"
                    )
                }
                exitProcess(0)
            }
            // 카드 결제
            "b" -> {
                if (price > userMoney) {
                    println("현재 잔액은 $userMoney 이므로 ${price - userMoney}원이 부족해서 주문할 수 없습니다.")
                } else {
                    println("카드를 넣어주세요.")
                    var job = GlobalScope.launch {
                        delay(1000)
                        println("결제중 입니다.. 잠시만 기다려 주세요!")
                        delay(2000)
                        println("결제가 완료되었습니다.")
                        delay(1000)
                    }

                    runBlocking {
                        job.join()
                    }

                    println(
                        "주문번호 ${customerNum}번 고객님 ${cookingTime}분 후 음식이 완료될 예정입니다.\n" +
                                "\n"
                    )
                }
                exitProcess(0)
            }

        }
    }

    fun printPrice(choicedMenuList: List<Product>) {
        price = calcPrice(choicedMenuList)
        println("결제하실 금액은 ${price}원 입니다.")
    }

    fun calcPrice(choicedMenuList: List<Product>): Int {
        var res = 0
        for (i in 0 until choicedMenuList.size) {
            res += choicedMenuList[i].price.toInt()
        }
        return res
    }
}