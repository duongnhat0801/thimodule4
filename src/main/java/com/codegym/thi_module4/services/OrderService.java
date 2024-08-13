package com.codegym.thi_module4.services;

import com.codegym.thi_module4.models.Order;
import com.codegym.thi_module4.models.Product;
import com.codegym.thi_module4.repositories.IOrderRepository;
import com.codegym.thi_module4.repositories.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IProductTypeRepository productTypeRepository;

    public List<Order> getOrders(LocalDate startDate, LocalDate endDate, Integer orderCount) {
        int limit = (orderCount != null && orderCount > 0) ? orderCount : 10;
        return orderRepository.findOrdersByDateRange(startDate, endDate, PageRequest.of(0, limit));
    }

    public List<Order> getTopOrders(int count) {
        return orderRepository.findTopOrdersByTotalPrice(PageRequest.of(0, count));
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        }
        return null;
    }
}
