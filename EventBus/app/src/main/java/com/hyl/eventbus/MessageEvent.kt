package com.hyl.eventbus

class MessageEvent internal constructor(message: String) {
    private var message: String? = null;
    init {
        this.message = message;
    }
    internal fun getMessage(): String? {
        return message;
    }

    companion object {// 包裹范围内 属于静态方法
        fun temprrr(): String {
            println("Ffffff")
            return "ffff";
         }
    }

    fun setMessage(message: String) {
        this.message = message;
    }
}