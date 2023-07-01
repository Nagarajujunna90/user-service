package com.emandi.customerservice.service;


import com.emandi.customerservice.config.ClientConfig;
import com.emandi.customerservice.model.Cart;
import com.emandi.customerservice.model.Product;
import com.emandi.customerservice.model.User;
import com.emandi.customerservice.repository.CartRepository;
import com.emandi.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ClientConfig clientConfig;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    @Qualifier("singleThreadPool")
    private ExecutorService executorService;

    public CartServiceImpl(CartRepository cartRepository, ClientConfig clientConfig) {
        this.cartRepository = cartRepository;
        this.clientConfig = clientConfig;
    }

    @Override
    public Cart addCart(Cart cart) {
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("productId", cart.getProductId());
        Mono<Product> product = clientConfig.getProductById("http://localhost:8084/product/v1/product/{productId}", pathParams, Product.class);
        product.subscribe(value -> System.out.println(value));
        User user = customerRepository.findById(cart.getUser().get(0).getId()).orElse(null);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        cart.setUser(userList);
        //  if (product != null) {
        return cartRepository.save(cart);
        //  }
        //return cart;
    }

    @Override
    public List<Cart> findAllCartsById(Integer userId) {
        return null;//cartRepository.findCartsByUserId(userId);
    }


    public <T> Future<T> execute(Callable<T> callable) {
        return executorService.submit(callable);
    }
}
