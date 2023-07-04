package com.emandi.customerservice.controller;


import com.emandi.customerservice.dto.UserDTO;
import com.emandi.customerservice.model.User;
import com.emandi.customerservice.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) throws JsonProcessingException {
        User createdUser = customerService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        customerService.deleteUser(id);
        return new ResponseEntity<>("user deleted successfully", HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User updatedUser = customerService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable("id") Integer id) {
        UserDTO user = customerService.findByUserId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
