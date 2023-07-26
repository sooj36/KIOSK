package com.example.kioskproject

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Random

class Payment(price : Int) {
    var price : Int

    var random = Random()
    // 고객번호 랜덤 생성 변수(0 ~ 1000)
    var customerNum : Int = random.nextInt(1000)
    // 조리시간 랜덤 생성 변수(0 ~ 30분)
    var cookingTime : Int = random.nextInt(30)
    init{
        this.price = price
    }
    fun pay(){

        // TODO : 장바구니에서 담은 상품의 총액을 받아와서 출력하는 기능 개발
        println("결제하실 금액은 ${price}원 입니다.")
        println("결제 방식을 선택해주세요.\na. 현금 \nb. 신용카드")

        // 결제방식 변수 선언
        var payOption = readLine()!!.toString()
        when(payOption){
            // 현금 결제
            "a" -> {
                println("카운터에서 도와드리겠습니다.")
            }
            // 카드 결제
            "b" -> {
                println("카드를 넣어주세요.")
                // 코루틴 job 객체를 이용한 delay()
                var job = GlobalScope.launch{
                    delay(1000)
                    println("결제중 입니다.. 잠시만 기다려 주세요!")
                    delay(3000)
                    println("결제가 완료되었습니다.")
                    delay(1000)
                }

                runBlocking {
                    job.join()
                }

                println("주문번호 ${customerNum}번 고객님 ${cookingTime}분 후 음식이 완료될 예정입니다.")
            }

        }
    }

}