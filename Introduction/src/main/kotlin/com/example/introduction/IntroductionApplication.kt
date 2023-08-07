package com.example.introduction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IntroductionApplication

fun main(args: Array<String>) {
    runApplication<IntroductionApplication>(*args)
}
