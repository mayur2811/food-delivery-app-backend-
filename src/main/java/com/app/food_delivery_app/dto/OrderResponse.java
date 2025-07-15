package com.app.food_delivery_app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.app.food_delivery_app.dto.OrderItemDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse{
    private Long orderId;
    private Long userId;
    private Long restaurantId;
    private List<OrderItemDto> items;
    private Double totalAmount;
    private String status;

}