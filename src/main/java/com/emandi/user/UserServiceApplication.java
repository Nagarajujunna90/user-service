package com.emandi.user;

import com.emandi.user.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(info = @Info(title = "user-service"))
@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@RestController
@RefreshScope
public class UserServiceApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);

    }

    //	@RequestMapping("/to-read")
//	public Mono<String> toReadWithOutCircuteBreaker() {
//		return WebClient.builder().build()
//				.get().uri("http://localhost:8082/recommended").retrieve()
//				.bodyToMono(String.class);
//	}

    @RequestMapping("/to-read")
    public Mono<String> toReadWithCircuiteBreaker() {
        return userService.readingList();
    }

    @GetMapping("/")
    public String hello() {
        return "test";
    }

/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/


}
