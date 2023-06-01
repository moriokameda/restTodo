package com.moriokameda.todorestapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class TodoController {

    /**
     * 一覧取得
     */
    @GetMapping
    fun list(): ResponseEntity<String> {
        TODO()
    }

    @PostMapping
    fun post(): ResponseEntity<String> {
        TODO()
    }
}