package com.example.kioskproject;

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString


class MacMorning:Display {
    var title = "[맥그리들과 함께 색다른 아침을 즐겨 보세요!]"

    var list = listOf(
        Product(
            "소세지 에그 맥그리들",
            "3700",
            "메이플 시럽이 들어간 달콤한 핫케이크 번에 국내산 1+등급 계란, 짭짤한 소시지 패티로 완성한 단짠의 맛! 맥그리들과 함께 색다른 아침을 즐겨 보세요!"),

        Product(
            "베이컨 에그 맥그리들",
            "3400",
            "메이플 시럽이 들어간 달콤한 핫케이크 번에 국내산 1+등급 계란, 바삭한 베이컨으로 완성한 단짠의 맛! 맥그리들과 함께 색다른 아침을 즐겨 보세요!"),

        Product(
            "치킨 치즈 머핀",
            "3600",
            "바삭한 치킨 패티와 고소한 치즈로 아침에도 든든하게!"),

        Product(
            "에그 맥머핀",
            "3000",
            "캐나디안 스타일 베이컨과 계란의 클래식한 만남, 맥도날드의 아침을 탄생하게 한 바로 그 메뉴."),

        Product(
            "소시지 에그 맥머핀",
            "3700",
            "잉글리쉬 머핀 위에 먹음직스럽게 올려진 치즈와 계란, 그리고 촉촉한 소시지 패티의 맛있는 조화!"),

        Product(
            "상하이 치킨 스낵랩",
            "2700",
            "매콤한 치킨에 달콤한 화이트 마요 소스로 매콤달콤하게! 베이컨에 양상추, 또띠아까지 어우러져 씹는 맛까지 즐겁다!"),

        Product(
            "디럭스 브렉퍼스트",
            "520",
            "정통 아메리칸 스타일의 브렉퍼스트와 달콤한 핫케익을 함께~ 프리미엄한 주말 브런치를 매일 즐겨보세요."),

        Product(
            "핫케익 3조각",
            "3300",
            "부드럽게 구워낸 핫케이크에 향긋한 버터와 달콤한 시럽을 살며시 부어 오늘 하루도 기분 좋게 시작하세요."),

        Product(
            "핫케익 2조각",
            "2800",
            "부드럽게 구워낸 핫케이크에 향긋한 버터와 3달콤한 시럽을 살며시 부어 오늘 하루도 기분 좋게 시작하세요.")
    )

    override fun displayTitle() {
        println(title)
    }

    override fun displayInfo() {
        super.displayInfo()
        for(i in 0 until list.size) {
            println("${i+1}. ${list[i].name} | ${list[i].price}원 | ${list[i].info}")
        }
        println(GatherString.backTxt)
    }
}