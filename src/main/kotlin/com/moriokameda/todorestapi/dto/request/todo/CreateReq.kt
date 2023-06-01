package com.moriokameda.todorestapi.dto.request.todo

import jakarta.validation.Valid
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import java.time.LocalDateTime
import kotlin.math.min

data class CreateReq(
    @field:NotBlank
    @field:Size(min = 1, max = 30)
    val title: String,
    val deadLine: LocalDateTime

) {
    @AssertTrue(message = "期限日時が現在日時より未来")
    fun isLater(): Boolean {
        return deadLine.isAfter(LocalDateTime.now())
    }
}