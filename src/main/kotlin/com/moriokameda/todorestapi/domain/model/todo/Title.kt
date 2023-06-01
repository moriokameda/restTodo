package com.moriokameda.todorestapi.domain.model.todo

@JvmInline
value class Title(val value: String) {
    companion object {
        const val MIN_SIZE = 1
        const val MAX_SIZE = 30
    }
    fun hasSize() {
        if (value.length > MAX_SIZE) throw IllegalArgumentException("サイズエラー")
        if (value.length < MIN_SIZE) throw IllegalArgumentException("サイズエラー")
    }
}