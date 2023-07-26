package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString


class MacLunch: Display {
    var title = "[점심만의 특별한 할인으로 즐길 수 있는 [맥런치 세트]를 만나보세요]"

    var macLunchList = listOf(
        Product(
            "진도 대파 크림 크로켓 버거 세트",
            "8000", "100% 국내산 진도 대파가 들어간 겉바속촉 크로켓에 구운 대파 마요 소스로 풍미 가득!"),

        Product(
            "빅맥 세트",
            "5900", "100% 순 쇠고기 패티 두 장에 빅맥®만의 특별한 소스. 입안에서 살살 녹는 치즈와 신선한 양상추, 양파, 그리고 피클까지. 50년 넘게 전 세계인의 입맛을 사로 잡은 버거의 대명사."),

        Product(
            "맥스파이시 상하이 버거 세트",
            "5900", "매콤한 시즈닝을 입힌 100% 닭가슴 통살 위에 아삭아삭한 양상추와 신선한 토마토~ 겉은 바삭, 속은 부드러운 치킨 패티의 매콤함으로 입맛도 기분도 화끈하게!"),
         Product(
             "더블 불고기 세트",
             "5000", "진한 불고기 소스의 패티가 두 장! 여기에 고소한 치즈와 마요네즈, 신선한 양상추를 곁들인 깊고 풍부한 맛."),

         Product(
             "1995 버거 세트",
             "6800",
             "113g 두툼한 순 쇠고기 패티, 더 풍성해진 신선한 양상추, 깊은 풍미의 그릴드 어니언까지! 맥도날드가 처음 생긴 1955년의 맛을 담은 영원한 오리지널 1955 버거"),

        Product(
            "베이컨 토마토디럭스 세트",
            "6600", "두 장의 100% 순 쇠고기 패티에 그릴에 구워 더욱 고소한 1장의 베이컨을 얹고, 신선한 토마토와 양상추, 매콤달콤한 스위트 칠리 소스, 치즈, 마요네즈를 더해 더욱 풍부하고 신선한 맛의 프리미엄 버거"),

        Product(
            "맥크리스피 디럭스 버거 세트",
            "7500",
            "100% 통닭다리살 겉바속촉 케이준 치킨 패티, 촉촉한 포테이토 브리오쉬 번, 스페셜 스모키 소스가 선사하는 놀랍도록 새로운 맛의 치킨 버거!"),
        )

        override fun displayTitle() {
            println(title)
        }

        override fun displayInfo() {
            super.displayInfo()
            for(i in 0 until macLunchList.size) {
                println("${i+1}. ${macLunchList[i].name} | ${macLunchList[i].price}원 | ${macLunchList[i].info}")
            }
            println(GatherString.backTxt)
        }
    }