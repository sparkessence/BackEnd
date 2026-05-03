package com.example.restaurant

import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun getAllOrders() = orderRepository.findAll()

    fun getOrderById(id: Long) = orderRepository.findById(id).orElseThrow { RuntimeException("Order not found") }

    fun deleteOrder(id: Long) = orderRepository.deleteById(id)

    fun createOrder(order: Order) = orderRepository.save(order)


    fun updateOrder(id: Long, updatedOrder: Order): Order {
        val existing = orderRepository.findById(id).orElseThrow()
        existing.dishName = updatedOrder.dishName
        existing.quantity = updatedOrder.quantity
        existing.status = updatedOrder.status
        return orderRepository.save(existing)
    }

}