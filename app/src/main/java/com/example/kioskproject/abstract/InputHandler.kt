package com.example.kioskproject.abstract

/// 사용자로부터 입력받은 값을 처리하는 Interface
interface InputHandler {
    // return값이 없을경우
    fun inputHandler() {}
    // Int Tyle return시 사용
    fun intInputHandler() : Int {
        return 0
    }
    // String Type return시 사용
    fun stringInputHandler() : String {
        return ""
    }
}