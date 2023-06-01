package com.moriokameda.todorestapi.controller

import com.moriokameda.todorestapi.domain.model.error.Error
import com.moriokameda.todorestapi.domain.model.error.NotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.net.http.HttpRequest

@RestControllerAdvice
class ExceptionHandler(
    private val messageSource: MessageSource
) {
    @ExceptionHandler(BindException::class)
    fun handleValidationError(bindException: BindException,request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity(Error(bindException.message,HttpStatus.BAD_REQUEST,bindException.stackTrace),HttpStatus.BAD_REQUEST,)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(notFoundException: NotFoundException,request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity(Error(notFoundException.message,HttpStatus.NOT_FOUND,notFoundException.stackTrace),HttpStatus.NOT_FOUND)
    }
}