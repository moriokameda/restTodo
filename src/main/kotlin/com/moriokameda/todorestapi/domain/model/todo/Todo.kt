package com.moriokameda.todorestapi.domain.model.todo

import java.time.LocalDateTime

data class Todo(
    val id: Long = 0,
    val title: String,
    val deadline: LocalDateTime,
    val status: Status
)
