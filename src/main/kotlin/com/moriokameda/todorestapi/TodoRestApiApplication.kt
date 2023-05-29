package com.moriokameda.todorestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoRestApiApplication

fun main(args: Array<String>) {
	runApplication<TodoRestApiApplication>(*args)
}
