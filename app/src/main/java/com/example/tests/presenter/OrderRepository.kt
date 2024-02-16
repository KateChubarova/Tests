package com.example.tests.presenter

import com.example.tests.Order
import io.reactivex.Observable

interface OrderRepository {
    val orders: Observable<List<Order>>
}