package com.example.restaurant

import jakarta.persistence.*

@Entity
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var dishName: String,
    var quantity: Int,
    var status: String
)