package com.app.food_delivery_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto{
    private Long orderItemId;
    private Long orderId;
    private Long itemId;
    private Integer quantity;
    private Double price;

}