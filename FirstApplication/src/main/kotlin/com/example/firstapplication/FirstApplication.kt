package com.example.firstapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FirstApplication{

    @RestController
    class HelloController {

        @GetMapping( "/hello")
        fun hello() = "Hello, World!"
    }
}


fun main(args: Array<String>) {
    runApplication<FirstApplication>(*args)
}
