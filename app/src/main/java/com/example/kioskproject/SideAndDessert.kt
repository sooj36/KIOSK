package com.example.kioskproject

import com.example.kioskproject.abstract.Display
import com.example.kioskproject.model.Product
import com.example.kioskproject.util.GatherString

class SideAndDessert : Display {
    var title = "[SideAndDessert MENU]"
    var sideAndDessertList = listOf<Product>(
        Product("허니버터 인절미 맥쉐이커 후라이","2700","100% 국산 5곡의 고소함과 허니버터의 단짠 조합!" ),
        Product("케이준 비프 스낵랩","2400","매콤한 케이준 소스와 100% 순 쇠고기 패티의 만남"),
        Product("맥윙","3200", "겉은 바삭! 속은 쫄~깃한 치킨 윙!"),
        Product("코울슬로","1900","양배추, 당근, 양파가 상큼하고 크리미한 마요 드레싱과 어우러져 아삭하게 씹히는 샐러드"),
        Product("상하이 치킨 스낵랩","2700","매콤한 치킨에 달콤한 화이트 마요 소스로 매콤달콤하게! 베이컨에 양상추, 또띠아까지 어우러져 씹는 맛까지 즐겁다!"),
        Product("골든 모짜렐라 치즈스틱","2000","속이 꽉 찬 황금빛 바삭함! 자연 모짜렐라 치즈로 빈틈 없이 고소한 맥도날드 치즈스틱을 즐겨보세요!"),
        Product("후렌치 후라이","2000","통으로 썰어낸 감자를 맥도날드만의 노하우로 튀겨낸 남다른 맛과 바삭함! 맥도날드의 역사가 담긴 월드 클래스 후렌치 후라이"),
        Product("맥너겟","2500","바삭하고 촉촉한 치킨이 한 입에 쏙! 다양한 소스로 입맛에 맞게 즐겨보세요!"),
        Product("맥스파이시 치킨 텐더","2700","부드러운 100% 닭안심살을 스파이시 시즈닝으로 매콤 바삭하게 튀겨낸 치킨 텐더! 2가지 소스로 입맛에 맞게 즐겨보세요!"),
        Product("해쉬 브라운","1000","씹으면 바삭바삭, 속은 부드러운 감자의 고소함."),
        Product("베리 스트로베리 맥플러리", "3000", "신선한 1등급 원유에 국내산 딸기 과즙이 들어간 스트로베리 아이스크림에 오레오가 블랜드 되어 있는 맥플러리" ),
        Product("오레오 맥플러리","3000","우유 듬뿍 신선한 아이스크림에 아삭아삭 오레오 쿠키가 가득!"),
        Product("딸기 오레오 맥플러리","3000","상큼한 딸기와 달콤한 오레오 쿠키가 신선한 우유 아이스크림에 퐁당!"),
        Product("초코 오레오 맥플러리","3000","초콜릿 퍼지와 오레오 쿠키까지! 달달함이 두 배로!"),
        Product("스트로베리콘","1400","신선한 1등급 원유와 딸기과즙으로 만든 아이스크림"),
        Product("아이스크림콘","1100","신선한 우유로 만든 부드러운 아이스크림 콘."),
        Product("바닐라 선데이 아이스크림","1600","신선한 우유로 만든 부드럽고 달콤한 아이스크림"),
        Product("초코 선데이 아이스크림","2100","신선한 우유로 만든 아이스크림에 달콤한 초콜렛 시럽이 입안 가득."),
        Product("딸기 선데이 아이스크림","2100","신선한 우유와 딸기가 아이스크림으로 만났다!"),
        Product("오레오 아포카토","3500","진한 에스프레소에 바닐라 아이스크림으로 달콤 쌉쌀하게, 오레오 쿠키로 바삭함까지!")

    )

    override fun displayTitle() {
        println(title)
    }

    override fun displayInfo() {
        super.displayInfo() // 물어보기
        for(i in 0 until sideAndDessertList.size){
            println("${i+1}. ${sideAndDessertList[i].name} | ${sideAndDessertList[i].price}원 | ${sideAndDessertList[i].info}")
        }
        println(GatherString.backTxt)
    }
}