package com.emandi.user.service;


import com.emandi.user.model.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);

    List<Cart> findAllCartsById(Integer userId);


    String deleteProductFromCart(String productId);
}
