package com.example.kioskproject

class RecommendInfo {
    fun showRecommendation() {
        println("추천 메뉴를 보시겠습니까 ?")
            println("a. 추천 메뉴 보기")
            println("b. 담은 메뉴만 보기")
        val userInput = readLine()

        if (userInput == "a") {
            println("추천 메뉴를 보여드리겠습니다.")
        }
        else if (userInput == "b") {
            println("지금까지 선택한 메뉴를 보기")
        }
        else {
            println("잘못된 입력입니다. 다시 선택해주세요.")
        }
    }
}
