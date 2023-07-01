package com.emandi.customerservice.service;


import com.emandi.customerservice.model.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);

    List<Cart> findAllCartsById(Integer userId);
}
