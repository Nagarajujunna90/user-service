package com.emandi.user;

import com.emandi.user.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    //	@RequestMapping("/to-read")
//	public Mono<String> toReadWithOutCircuteBreaker() {
//		return WebClient.builder().build()
//				.get().uri("http://localhost:8082/recommended").retrieve()
//				.bodyToMono(String.class);
//	}

//    @RequestMapping("/to-read")
//    public Mono<String> toReadWithCircuiteBreaker() {
//        return userService.readingList();
//    }

    @GetMapping("/")
    public String hello() {
        return "test";
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/


}
