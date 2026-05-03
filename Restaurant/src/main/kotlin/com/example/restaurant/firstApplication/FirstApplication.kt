package com.example.restaurant.firstApplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(scanBasePackages = ["com.example.restaurant"])

@RestController
class FirstApplication {

    @GetMapping("/hello")
    fun hello() = "Hello, World!"
}

fun main(args: Array<String>) {
    runApplication<FirstApplication>(*args)
}
