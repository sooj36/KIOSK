package com.example.kioskproject.abstract

/// 화면에 표시되는 정보들을 위한 Interface
interface Display {
    // 메뉴 Display시 최상단 Title 출력용
    fun displayTitle()
    // 출력할 정보들. 맨 먼저 설정한 Title이 출력되고 난 후 사용자가 정의한 Info가 출력됨
    fun displayInfo(){
        displayTitle()
    }
}