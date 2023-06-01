package com.moriokameda.todorestapi.domain.model

import com.moriokameda.todorestapi.domain.model.todo.Status
import jakarta.validation.Valid
import java.time.LocalDateTime

data class Todo(
    val id: Long? = null,
    val title: String,
    val deadLine: LocalDateTime,
    val status: Status
)
