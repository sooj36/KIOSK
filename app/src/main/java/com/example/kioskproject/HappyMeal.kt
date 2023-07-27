package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString

class HappyMeal : Display {
    var title = "[HappyMeal MENU]"
    var list = listOf<Product>(
        Product("에그 맥머핀", "3800", "캐나디안 스타일 베이컨과 계란의 클래식한 만남,맥도날드의 아침을 탄생하게 한 바로 그 메뉴."),
        Product(
            "핫케익 2조각",
            "3800",
            "부드럽게 구워낸 핫케이크에 향긋한 버터와 달콤한 시럽을 살며시 부어 오늘 하루도 기분 좋게 시작하세요."
        ),
        Product(
            "딸기 코코넛푸딩",
            "3800",
            "새콤 달콤 딸기 퓨레와 코코넛 젤리를 한 입에 먹을 수 있는 부드러운 딸기 코코넛 푸딩 이전 메뉴다음 메뉴"
        ),
        Product("해쉬브라운", "3800", "씹으면 바삭바삭, 속은 부드러운 감자의 고소함."),
        Product("생수", "3800", "활력을 되찾아주는 깔끔한 미네랄 생수."),
        Product("오렌지주스", "3800", "비타민 C를 함유한 4년 연속 세계 판매 1위 100% 오렌지 주스."),
    )
    var happyMealList = listOf<Product>(
        Product("불고기버거", "3800", "한국인의 입맛에 딱 맞는 불고기 소스에 잘 재운 패티와 고소한 마요네즈, 신선한 양상추의 맛있는 조합."),
        Product(
            "햄버거",
            "3800",
            "100% 순 쇠고기 패티에 상큼한 피클과 양파, 기본에 충실한 맥도날드 햄버거."
        ),
        Product(
            "맥너겟 4조각",
            "3800",
            "바삭하고 촉촉한 치킨이 한 입에 쏙! 다양한 소스로 입맛에 맞게 즐겨보세요!"
        ),
        Product(
            "딸기 코코넛푸딩",
            "3800",
            "새콤 달콤 딸기 퓨레와 코코넛 젤리를 한 입에 먹을 수 있는 부드러운 딸기 코코넛 푸딩 이전 메뉴다음 메뉴"
        ),
        Product(
            "후렌치후라이 Small",
            "3800",
            "통으로 썰어낸 감자를 맥도날드만의 노하우로 튀겨낸 남다른 맛과 바삭함! 맥도날드의 역사가 담긴 월드 클래스 후렌치 후라이"
        ),
        Product("생수", "3800", "활력을 되찾아주는 깔끔한 미네랄 생수."),
        Product("오렌지주스", "3800", "비타민 C를 함유한 4년 연속 세계 판매 1위 100% 오렌지 주스."),
    )

    override fun displayTitle() {
        println(title)
    }

    override fun displayInfo() {
        super.displayInfo()
        var data: List<Product> = happyMealList
        for (i in 0 until data.size) {
            println("${i + 1}. ${data[i].name} | ${data[i].price}원 | ${data[i].info}")
        }
        println(GatherString.backTxt)
    }
}

