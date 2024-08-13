package com.codegym.thi_module4.services;

import com.codegym.thi_module4.models.Order;


import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    List<Order> getOrders(LocalDate startDate, LocalDate endDate, Integer orderCount);
    List<Order> getTopOrders(int count);

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);
}