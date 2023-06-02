package com.moriokameda.todorestapi.dto.request.todo

import com.fasterxml.jackson.annotation.JsonProperty
import com.moriokameda.todorestapi.domain.model.todo.Status
import com.moriokameda.todorestapi.domain.model.todo.Title
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class UpdateReq(
    @field:NotBlank
    @field:Size(min = Title.MIN_SIZE, max = Title.MAX_SIZE)
    val title: String,
    @field:JsonProperty
    val deadline: LocalDateTime,
    @field:JsonProperty
    val status: Status
) {
    @AssertTrue(message = "期限日時が現在日時より未来")
    fun isLater(): Boolean {
        return deadline.isAfter(LocalDateTime.now())
    }
}