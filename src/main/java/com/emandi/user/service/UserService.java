package com.emandi.user.service;


import com.emandi.user.dto.LoginRequest;
import com.emandi.user.dto.UserRequest;
import com.emandi.user.dto.UserResponse;
import com.emandi.user.model.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    String registerUser(UserRequest userRequest);

    String deleteUser(Integer id);

    User updateUser(Integer id, UserRequest user);

    UserResponse findByUserId(Integer id);

    List<UserResponse> findAllUsers();

    String login(LoginRequest loginRequest);

    Mono<String> readingList();
}
