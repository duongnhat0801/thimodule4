package com.codegym.thi_module4.controllers;

import com.codegym.thi_module4.models.Order;
import com.codegym.thi_module4.models.Product;
import com.codegym.thi_module4.services.IOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/orders")
    public String showOrders(@RequestParam(required = false) String startDate,
                             @RequestParam(required = false) String endDate,
                             @RequestParam(required = false) Integer orderCount,
                             Model model) {
        LocalDate start = null, end = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            if (startDate != null && !startDate.isEmpty()) {
                start = LocalDate.parse(startDate, formatter);
            }
            if (endDate != null && !endDate.isEmpty()) {
                end = LocalDate.parse(endDate, formatter);
            }

            if (start != null && end != null && start.isAfter(end)) {
                model.addAttribute("error", "End date must be greater than start date.");
                return "orderList";
            }
        } catch (DateTimeParseException e) {
            model.addAttribute("error", "Invalid date format. Please use dd/MM/yyyy.");
            return "orderList";
        }

        List<Order> orders = orderService.getOrders(start, end, orderCount);
        model.addAttribute("orders", orders);
        return "orderList";
    }

    @GetMapping("/orders/top")
    public String showTopOrders(@RequestParam(defaultValue = "10") Integer orderCount, Model model) {
        List<Order> orders = orderService.getTopOrders(orderCount);
        model.addAttribute("orders", orders);
        return "orderList";
    }
    @GetMapping("/orders/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return "error";
        }
        model.addAttribute("order", order);
        return "editOrder";
    }

    @PostMapping("/orders/update/{id}")
    public String updateOrder(@PathVariable Long id,
                              @ModelAttribute("order") @Valid Order order,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "editOrder";
        }
        Order updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder == null) {
            model.addAttribute("error", "Order not found.");
            return "error";
        }
        return "redirect:/orders";
    }


}
