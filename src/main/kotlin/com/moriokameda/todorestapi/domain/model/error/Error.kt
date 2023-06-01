package com.moriokameda.todorestapi.domain.model.error

import jdk.jfr.StackTrace
import org.springframework.http.HttpStatus

class Error(
    val message: String,
    val status: HttpStatus,
    val stackTrace: Array<out StackTraceElement>? = null
) {
}