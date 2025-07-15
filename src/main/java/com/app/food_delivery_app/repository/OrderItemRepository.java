package com.app.food_delivery_app.repository;

import com.app.food_delivery_app.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Additional query methods can be defined here if needed
    // For example, you could add methods to find order items by order or menu item
    // List<OrderItem> findByOrderId(Long orderId);
    // List<OrderItem> findByMenuItemId(Long menuItemId);
}