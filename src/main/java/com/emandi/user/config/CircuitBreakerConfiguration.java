package com.emandi.user.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfiguration {
//    @Bean
//    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//                .timeLimiterConfig(TimeLimiterConfig.custom()
//                .timeoutDuration(Duration.ofSeconds(4)).build()).build());
//    }

    @Bean
    Customizer<ReactiveCircuitBreakerFactory> circuitBreakerFactory() {

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig
                .custom()
                .timeoutDuration(Duration.ofMillis(300))
                .build();

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(5)
                .waitDurationInOpenState(Duration.ofMillis(300))
                .slidingWindowSize(2)
                .build();

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder("config")
                .circuitBreakerConfig(circuitBreakerConfig)
                .timeLimiterConfig(timeLimiterConfig)
                .build());

    }
}
