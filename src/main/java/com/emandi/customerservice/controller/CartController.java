package com.emandi.customerservice.controller;


import com.emandi.customerservice.model.Cart;
import com.emandi.customerservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/v1")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/cart")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.addCart(cart), HttpStatus.OK);
    }

    @GetMapping("/carts/{userId}")
    public  ResponseEntity<List<Cart>> findAllCartsById(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(cartService.findAllCartsById(userId), HttpStatus.OK);
    }

}
