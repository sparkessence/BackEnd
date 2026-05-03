package com.example.restaurant

import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var dishName: String = "",
    var quantity: Int = 0,
    var status: String = ""
)
