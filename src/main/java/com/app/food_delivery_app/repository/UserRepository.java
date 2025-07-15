package com.app.food_delivery_app.repository;

import com.app.food_delivery_app.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods (if needed) can be defined here
    User findByEmail(String email);
    User findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    
    // Other custom query methods can be added as needed
    @Query("SELECT u FROM User u WHERE u.customerId = ?1")
    User findByCustomerId(Integer customerId);
}