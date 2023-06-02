package com.moriokameda.todorestapi.application.repository

import com.moriokameda.todorestapi.infra.entity.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<TodoEntity, Long> {
    fun findByTitle(title: String): List<TodoEntity>
}