package com.emandi.user.service;


import com.emandi.user.config.KafkaProducerConfig;
import com.emandi.user.dto.CartResponse;
import com.emandi.user.dto.LoginRequest;
import com.emandi.user.dto.UserRequest;
import com.emandi.user.dto.UserResponse;
import com.emandi.user.model.Role;
import com.emandi.user.model.User;
import com.emandi.user.repository.UserRepository;
import com.emandi.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EventServiceLog eventServiceLog;

    private  WebClient webClient=WebClient.create("http://localhost:8083");




    //    public UserServiceImpl(UserRepository userRepository, ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory) {
//        this.userRepository = userRepository;
//        this.reactiveCircuitBreaker = circuitBreakerFactory.create("recommended");
//
//        this.webClient = WebClient.builder().baseUrl("http://localhost:8083").build();
//    }

    @Override
    public String registerUser(UserRequest userRequest) {
        User user = new User(userRequest);
        Set<Role> roles1 = new HashSet<>();
        roles1.add(new Role("user"));
        user.setRoles(roles1);
        user.setPassword("nagaraju");
        User user1 = userRepository.save(user);
        // kafkaProducerConfig.kafkaTemplate().send("createUser",user1.toString());
        eventServiceLog.addEvent(user1, "ADD_USER");
        return "User created successfully";

    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        eventServiceLog.addEvent(id, "DELETE_USER");
        return "User deleted successfully";

    }

    @Override
    public User updateUser(Integer id, UserRequest userRequest) {
        User user = new User(userRequest);
        user.setId(id);
        User updatedUser = userRepository.save(user);
        eventServiceLog.addEvent(updatedUser, "UPDATE_USER");
        return updatedUser;
    }

    @Override
    @Transactional
    public UserResponse findByUserId(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        List<CartResponse> cartResponseList = new ArrayList<>();
        UserResponse userResponse = null;
        if (user != null) {
            userResponse = new UserResponse(user);
            user.getCarts().forEach(cart -> {
                CartResponse cartResponse = new CartResponse(cart);
                cartResponseList.add(cartResponse);
            });
            //   userResponse.setCartResponseList(cartResponseList);
            //   eventServiceLog.addEvent(user, "GET_USER_BY_ID");
        }

        return userResponse;
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> userlist = (List<User>) userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        List<CartResponse> cartResponse = new ArrayList<>();
        userlist.forEach(user -> {
            UserResponse userResponse = new UserResponse(user);
            user.getCarts().forEach(cart -> {
                CartResponse cartResponse1 = new CartResponse(cart);
                cartResponse.add(cartResponse1);
            });
            //     userResponse.setCartResponseList(cartResponse);
            //   userResponse.setCartResponseList(cartResponse);
            userResponses.add(userResponse);
        });
        // eventServiceLog.addEvent(userlist, "GET_ALL_USER_BY_ID");
        return userResponses;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        if (user != null) {
            eventServiceLog.addEvent(loginRequest, "USER_LOGGED_IN");
            return "User LoggedIn successfully";
        } else {
            return "User details not found";
        }

    }


    @Override
    public Mono<String> readingList() {
       return webClient.get().uri("/recommended").retrieve().bodyToMono(String.class);
//        stringMono.subscribe(System.out::println);
//        return stringMono.block();
    }
}
