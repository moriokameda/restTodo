package com.moriokameda.todorestapi.infra.entity

import com.moriokameda.todorestapi.domain.model.todo.Status
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "todo")
data class TodoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val deadline: LocalDateTime,
    val status: Status,
    @Column(updatable = false, name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now()
)