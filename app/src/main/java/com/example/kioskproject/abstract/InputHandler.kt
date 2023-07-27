package com.example.kioskproject.abstract

import com.example.kioskproject.model.Product

/// 사용자로부터 입력받은 값을 처리하는 Interface
interface InputHandler {
    // return값이 없을경우
    fun inputHandlerInt(list:List<Product>) : Int {return 0}
    // Int Tyle return시 사용
    fun intInputHandler() : Int {
        return 0
    }
}