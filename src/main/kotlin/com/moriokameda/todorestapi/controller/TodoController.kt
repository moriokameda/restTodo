package com.moriokameda.todorestapi.controller

import com.moriokameda.todorestapi.application.service.TodoService
import com.moriokameda.todorestapi.domain.model.todo.Todo
import com.moriokameda.todorestapi.dto.request.todo.CreateReq
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController(
    private val service: TodoService
) {

    /**
     * 一覧取得
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(
        @RequestParam("title") @Valid title: String? = null
    ): List<Todo> {
        return service.list(title)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun post(
        @Validated @RequestBody req: CreateReq
    ): Todo {
        return service.create(req.title, req.deadline)
    }
}