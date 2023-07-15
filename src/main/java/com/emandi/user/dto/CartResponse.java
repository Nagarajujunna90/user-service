package com.emandi.user.dto;

import com.emandi.user.model.Cart;
import lombok.Data;

import java.util.List;

@Data
public class CartResponse {
    private String productId;
    private Integer customerId;

    public CartResponse(Cart cart) {
        this.customerId=cart.getCustomerId();
        this.productId=cart.getProductId();
    }
}
