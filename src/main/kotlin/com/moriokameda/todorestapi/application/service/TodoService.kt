package com.moriokameda.todorestapi.application.service

import com.moriokameda.todorestapi.application.repository.TodoRepository
import com.moriokameda.todorestapi.domain.model.error.NotFoundException
import com.moriokameda.todorestapi.domain.model.todo.Status
import com.moriokameda.todorestapi.domain.model.todo.Todo
import com.moriokameda.todorestapi.dto.request.todo.UpdateReq
import com.moriokameda.todorestapi.infra.entity.TodoEntity
import org.springframework.data.repository.findByIdOrNull
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
        val entity =
            todoRepository.save(TodoEntity(title = title, deadline = deadLine, status = Status.NOT_YET_STARTED))
        return Todo(entity.id, entity.title, entity.deadline, entity.status)
    }

    fun isExist(id: Long): Boolean {
        return todoRepository.existsById(id)
    }

    fun get(id: Long): Todo {
        val entity = todoRepository.findByIdOrNull(id)
            ?: throw NotFoundException("todoが存在しません", mapOf("todoId" to id))
        return Todo(entity.id, entity.title, entity.deadline, entity.status)
    }

    @Transactional(readOnly = false)
    fun update(id: Long, req: UpdateReq): Todo {
        val oldEntity = todoRepository.findByIdOrNull(id)
            ?: throw NotFoundException("todoが存在しません", mapOf("todoId" to id))
        val newEntity = todoRepository.save(
            oldEntity.copy(
                title = req.title,
                deadline = req.deadline,
                status = req.status,
            )
        )
        return Todo(newEntity.id, newEntity.title, newEntity.deadline, newEntity.status)
    }

    @Transactional(readOnly = false)
    fun delete(id: Long) {
        return todoRepository.deleteById(id)
    }
}