package com.example.tests.presenter

import com.example.tests.Order
import com.example.tests.OrderListContract
import com.example.tests.OrderListContract.Presenter
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver

class OrderListPresenter(
    private val orderRepository: OrderRepository,
    private val workScheduler: Scheduler,
    private val resultScheduler: Scheduler,
) : BasePresenter<OrderListContract.View>(), Presenter {

    override fun refresh() {
        if (view == null) return
        view?.showProgress()
        orderRepository.orders
            .subscribeOn(workScheduler)
            .observeOn(resultScheduler)
            .subscribe(object : DisposableObserver<List<Order>>() {
                override fun onNext(orders: List<Order>) {
                    if (view == null) return
                    view?.hideProgress()
                    view?.showOrders(orders)
                }

                override fun onError(e: Throwable) {
                    if (view == null) return
                    view?.hideProgress()
                    view?.showError(e.message)
                }

                override fun onComplete() {}
            })
    }
}