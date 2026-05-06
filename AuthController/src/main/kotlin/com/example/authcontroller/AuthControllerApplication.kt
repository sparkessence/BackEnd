package com.example.authcontroller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication

@RestController
@RequestMapping("/auth")
class AuthControllerApplication(
    private val jwtUtil: JwtUtil
){

    @PostMapping("/login")
    fun login(@RequestBody requestBody: LoginRequest) : AuthResponse {

        // In a real application, you would validate the username and password against a database
        if (requestBody.username == "user" && requestBody.password == "password") {
            val token =  jwtUtil.generateToken(requestBody.username)
            return AuthResponse(token)
        } else {
            throw RuntimeException("Invalid credentials")
        }

    }
}

data class LoginRequest(val username: String, val password: String)
data class AuthResponse(val token: String)

fun main(args: Array<String>) {
    runApplication<AuthControllerApplication>(*args)
}
