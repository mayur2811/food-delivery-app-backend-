package com.app.food_delivery_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    private Long restaurantId;
    private String name;
    private String address;
    private String phone;
    private Double rating;

}