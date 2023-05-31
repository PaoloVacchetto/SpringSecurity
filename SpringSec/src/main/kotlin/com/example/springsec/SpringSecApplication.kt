package com.example.springsec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSecApplication

fun main(args: Array<String>) {
	runApplication<SpringSecApplication>(*args)
}
