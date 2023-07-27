package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString

class DrinkAndMacCafe: Display {
    var title = "[DrinkAndMacCafe MENU]"
    var list = listOf(
        Product("디카페인 아이스크림 라떼", "4100", "입안 가득 달콤한 아이스크림과 바로 내린 100% 친환경 커피 & 신선한 우유를 담은 진한 라떼의 만남! 이제 디카페인으로도 즐겨보세요!"),
        Product("아이스크림 라떼", "3300", "입안 가득 달콤한 아이스크림과 바로 내린 100% 친환경 커피 & 신선한 우유를 담은 진한 라떼의 만남! 이전 메뉴다음 메뉴"),
        Product("자두 천도복숭아 칠러", "2700", "상콤한 자두와 달콤한 천도복숭아의 만남! 자두 천도복숭아 칠러"),
        Product("제주 한라봉 칠러", "2700", "제주 한라봉의 상큼새콤한 맛과 향을 즐겨보세요!"),
        Product("바닐라 라떼", "3200", "바로 내린 100% 친환경 커피의 진한 맛과 향, 1A등급 우유, 그리고 천연 바닐라 향으로 달콤함까지!"),
        Product("아이스 바닐라 라떼", "3300", "바로 내린 100% 친환경 커피의 진한 맛과 향, 1A등급 우유, 그리고 천연 바닐라 향으로 달콤함까지!"),
        Product("카페라떼", "2500", "바로 내린 100% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!"),
        Product("디카페인 카페라떼", "2600", "바로 내린 100% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!"),
        Product("아이스 카페라떼", "2500", "바로 내린 100% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!"),
        Product("디카페인 아이스 카페라떼", "2800", "바로 내린 100% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!"),
        Product("아메리카노", "2700", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!"),
        Product("디카페인 아메리카노", "2300", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!"),
        Product("아이스 아메리카노", "2700", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!"),
        Product("디카페인 아이스 아메리카노", "2300", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!"),
        Product("카푸치노", "2500", "바로 내린 100% 친환경 커피로 추출한 에스프레소 위에 갓 만든 우유 거품으로 더 부드럽게!"),
        Product("디카페인 카푸치노", "2600", "바로 내린 100% 친환경 커피로 추출한 에스프레소 위에 갓 만든 우유 거품으로 더 부드럽게!"),
        Product("드립 커피", "1500", "100% 아라비카 원두를 드립 커피의 부드러움으로 만나보세요."),
        Product("아이스 드립 커피", "1000", "100% 아라비카 원두를 드립 커피의 부드러움으로 만나보세요."),
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