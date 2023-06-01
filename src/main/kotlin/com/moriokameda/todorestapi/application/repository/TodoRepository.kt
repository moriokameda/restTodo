package com.moriokameda.todorestapi.application.repository

import com.moriokameda.todorestapi.infra.entity.TodoEntity
import org.springframework.data.annotation.Id
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<TodoEntity, Id> {
    fun findByTitle(title: String): List<TodoEntity>
}