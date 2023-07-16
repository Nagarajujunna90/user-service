package com.emandi.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(info = @Info(title = "user-service"))
@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@RestController
@RefreshScope
public class UserServiceApplication {
    @Value("${hello.app}")
    String test;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);

    }

    @GetMapping("/")
    public String hello(){
        System.out.println("sdfsda==="+test);
        return test;
    }

/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

}
