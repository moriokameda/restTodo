package com.moriokameda.todorestapi.controller

import com.moriokameda.todorestapi.application.service.TodoService
import com.moriokameda.todorestapi.domain.model.error.NotFoundException
import com.moriokameda.todorestapi.domain.model.todo.Todo
import com.moriokameda.todorestapi.dto.request.todo.CreateReq
import com.moriokameda.todorestapi.dto.request.todo.UpdateReq
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
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
    @ResponseStatus(HttpStatus.CREATED)
    fun post(
        @Validated @RequestBody req: CreateReq,
        bindingResult: BindingResult
    ): Todo {
        return service.create(req.title, req.deadline)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getDetail(
        @PathVariable(name = "id") id: Long
    ): Todo {
        if (!service.isExist(id)) throw NotFoundException("todoが存在しません", mapOf("id" to id))
        return service.get(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @Validated @RequestBody req: UpdateReq,
        @Valid @NotNull @PathVariable("id") id: Long
    ): Todo {
        if (!service.isExist(id)) throw NotFoundException("todoが存在しません", mapOf("id" to id))
        return service.update(id, req)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @Valid @NotNull @PathVariable("id") id: Long
    ) {
        if (!service.isExist(id)) throw NotFoundException("todoが存在しません", mapOf("id" to id))
        service.delete(id)
    }
}