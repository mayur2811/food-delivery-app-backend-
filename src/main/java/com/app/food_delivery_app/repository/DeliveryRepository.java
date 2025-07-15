package com.app.food_delivery_app.repository;

import com.app.food_delivery_app.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    // Additional query methods can be defined here if needed
    // For example, you could add methods to find deliveries by user or restaurant
    // Delivery findByUserId(Long userId);
    // List<Delivery> findByRestaurantId(Long restaurantId);    
}