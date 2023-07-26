package com.example.kioskproject
import com.example.kioskproject.Food
class HappySnack{
    var happySnack = listOf<Food>(
        Food("케이준 비프 스낵랩","2400","매콤한 케이준 소스와 100% 순 쇠고기 패티의 만남"),
        Food("아이스 아메리카노","2700","바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!"),
        Food("아이스 바닐라라뗴","3400","바로 내린 100% 친환경 커피의 진한 맛과 향, 1A등급 우유, 그리고 천연 바닐라 향으로 달콤함까지!"),
        Food("코카콜라 제로", "1200","상쾌한 맛은 살리면서 웰빙 트렌드에 맞춰 설탕과 칼로리를 제로로 줄인 코카-콜라 제로"),
        Food("치즈버거","2400","고소하고 부드러운 치즈와 100% 순 쇠고기 패티, 맥도날드만의 심플한 클래식 치즈버거"),
        Food("골든 모짜렐라 치즈스틱","2000","속이 꽉 찬 황금빛 바삭함! 자연 모짜렐라 치즈로 빈틈 없이 고소한 맥도날드 치즈스틱을 즐겨보세요!"),
        Food("바닐라 선데이 아이스크림","1600","신선한 우유로 만든 부드럽고 달콤한 아이스크림")
    )

    fun show(){
        println("===해피스낵===")
        for(index in 0 .. (happySnack.size) - 1){
            println("${index + 1 }. ${happySnack[index].name} : ${happySnack[index].price}원, ${happySnack[index].info}")

        }
    }
}





