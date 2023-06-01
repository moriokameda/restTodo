package com.moriokameda.todorestapi.domain.model.error

class NotFoundException(
    override val message: String,
    val target: Map<String, Any>,
) : RuntimeException() {
}