package com.emandi.user.controller;


import com.emandi.user.model.Cart;
import com.emandi.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
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
    public  ResponseEntity<?> findAllCartsById(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(cartService.findAllCartsById(userId), HttpStatus.OK);
    }
    @DeleteMapping("/cart/{productId}")
    public  ResponseEntity<?> deleteProductByProductId(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(cartService.deleteProductFromCart(productId), HttpStatus.OK);
    }

}
