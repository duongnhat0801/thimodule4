package com.codegym.thi_module4.repositories;

import com.codegym.thi_module4.models.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE (:startDate IS NULL OR o.purchaseDate >= :startDate) " +
            "AND (:endDate IS NULL OR o.purchaseDate <= :endDate) " +
            "ORDER BY o.purchaseDate DESC")
    List<Order> findOrdersByDateRange(@Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate,
                                      Pageable pageable);

    @Query("SELECT o FROM Order o ORDER BY (o.product.price * o.quantity) DESC")
    List<Order> findTopOrdersByTotalPrice(Pageable pageable);
}
