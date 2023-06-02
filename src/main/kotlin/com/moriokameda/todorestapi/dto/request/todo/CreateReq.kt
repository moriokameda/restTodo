package com.moriokameda.todorestapi.dto.request.todo

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class CreateReq(
    @field:NotBlank
    @field:Size(min = 1, max = 30)
    @get:JsonProperty
    val title: String,
    @get:JsonProperty
    val deadline: LocalDateTime

) {
    @AssertTrue(message = "期限日時が現在日時より未来")
    fun isLater(): Boolean {
        return deadline.isAfter(LocalDateTime.now())
    }
}