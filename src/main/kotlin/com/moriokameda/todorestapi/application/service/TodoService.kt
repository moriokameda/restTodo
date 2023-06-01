package com.moriokameda.todorestapi.application.service

import com.moriokameda.todorestapi.application.repository.TodoRepository
import com.moriokameda.todorestapi.domain.model.todo.Status
import com.moriokameda.todorestapi.domain.model.todo.Todo
import com.moriokameda.todorestapi.infra.entity.TodoEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional(readOnly = true)
class TodoService(
    private val todoRepository: TodoRepository
) {
    fun list(title: String?): List<Todo> {
        val entities = if (title != null) todoRepository.findByTitle(title) else todoRepository.findAll()
        return entities.map { Todo(it.id, it.title, it.deadline, it.status) }
    }

    @Transactional(readOnly = false)
    fun create(title: String, deadLine: LocalDateTime): Todo {
        val entity = todoRepository.save(TodoEntity(title = title, deadline = deadLine, status = Status.NOT_YET_STARTED))
        return Todo(entity.id,entity.title,entity.deadline,entity.status)
    }
}