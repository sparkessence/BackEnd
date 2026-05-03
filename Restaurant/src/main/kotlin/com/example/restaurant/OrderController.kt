package com.example.restaurant

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
){

    @GetMapping
    fun getOrders() = orderService.getAllOrders()

    @GetMapping("{id}")
    fun getOrderById(@PathVariable id: Long) = orderService.getOrderById(id)

    @DeleteMapping("{id}")
    fun deleteOrder(@PathVariable id: Long) = orderService.deleteOrder(id)

    @PostMapping
    fun createOrder(@RequestBody order: Order) = orderService.createOrder(order)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody order: Order
    ) = orderService.updateOrder(id, order)

}
