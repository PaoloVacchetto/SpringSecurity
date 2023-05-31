package com.example.springsec.simple_data

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleDataController {

    @GetMapping("/simple_data")
    fun all(): List<SimpleDataDTO> {
        return listOf(
            SimpleDataDTO(1, "Hello"),
            SimpleDataDTO(2, "Hello2")
        )

    }
}