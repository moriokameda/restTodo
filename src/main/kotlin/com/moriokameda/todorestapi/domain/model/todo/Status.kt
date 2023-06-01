package com.moriokameda.todorestapi.domain.model.todo


enum class Status(val value: Int) {
    NOT_YET_STARTED(1),
    IN_PROGRESS(2),
    FINISHED(3);

    companion object {
        fun valueOf(value: Int): Status {
            return Status.values().firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("不正なstatusの値です")
        }

    }
}