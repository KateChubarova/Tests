package com.example.tests

import com.example.tests.presenter.OrderListPresenter
import com.example.tests.presenter.OrderRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class OrderListPresenterTest {

    private lateinit var presenter: OrderListPresenter
    @Mock
    lateinit var mockOrderRepository: OrderRepository
    @Mock
    lateinit var mockView: OrderListContract.View

    val orders = listOf(Order(1, 100f, "Order 1"), Order(2, 200f, "Order 2"))

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        presenter = OrderListPresenter(
            mockOrderRepository,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )
        presenter.attachView(mockView)
    }

    @Test
    fun refreshSuccess(){

        Mockito.`when`(mockOrderRepository.orders).thenReturn(Observable.just(orders))
        presenter.refresh()
        verify(mockView).showProgress()
        verify(mockView).hideProgress()
        verify(mockView).showOrders(orders)
        verify(mockView, never()).showError(anyString())

    }

    @Test
    @Throws(java.lang.Exception::class)
    fun refreshFailed() {
        val error = "Network error"
        `when`(mockOrderRepository.orders).thenReturn(Observable.error(java.lang.Exception(error)))
        presenter.refresh()
        verify(mockView).showProgress()
        verify(mockView).hideProgress()
        verify(mockView).showError(error)
        verify(mockView, never()).showOrders(ArgumentMatchers.anyList())
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun refreshWithoutView() {
        presenter.detachView()
        presenter.refresh()
        verify(mockOrderRepository, never()).orders
        verify(mockView, never()).showProgress()
        verify(mockView, never()).showOrders(ArgumentMatchers.anyList())
    }
}