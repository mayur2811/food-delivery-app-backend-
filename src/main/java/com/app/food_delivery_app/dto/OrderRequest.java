package com.app.food_delivery_app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long restaurantId;

    @NotNull
    private List<OrderItemRequest> items;

    @NotNull
    private Double totalAmount;

}

@Data
class OrderItemRequest {
    @NotNull
    private Long itemId;

    @NotNull
    private Integer quantity;
}