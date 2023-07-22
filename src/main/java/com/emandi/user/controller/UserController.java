package com.emandi.user.controller;


import com.emandi.user.dto.UserRequest;
import com.emandi.user.model.User;
import com.emandi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1")
@RefreshScope
//@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.registerUser(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(id, userRequest), HttpStatus.CREATED);

    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.findByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }
}
