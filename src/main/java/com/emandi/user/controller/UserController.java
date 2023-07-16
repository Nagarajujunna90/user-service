package com.emandi.user.controller;


import com.emandi.user.dto.UserRequest;
import com.emandi.user.model.User;
import com.emandi.user.service.UserService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/emandi/v1")
//@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @RateLimiter(name = "getMessageRateLimit", fallbackMethod = "getMessageFallBack")
    // @Bulkhead(name = "getMessageBH", fallbackMethod = "getMessageFallBack")
    //@TimeLimiter(name = "getMessageTL")
    public ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest) {
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
    public ResponseEntity<?> findByUserId() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    public ResponseEntity<?> getMessageFallBack(int id, RequestNotPermitted ex) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Retry-After", "60s"); // retry after one second
        return new ResponseEntity<>("Too Many Requests - Retry After 1 Minute",HttpStatus.TOO_MANY_REQUESTS);

    }

    private String getResponse() {
        if (Math.random() < 0.4) {       //Expected to fail 40% of the time
            return "Executing Within the time Limit...";
        } else {
            try {
                System.out.println("Getting Delayed Execution");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Exception due to Request Timeout.";
    }

}
