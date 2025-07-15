package com.app.food_delivery_app.repository;

import com.app.food_delivery_app.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // Additional query methods can be defined here if needed
    // For example, you could add methods to find menu items by restaurant or category
    // List<MenuItem> findByRestaurantId(Long restaurantId);
    // List<MenuItem> findByCategory(String category);
}