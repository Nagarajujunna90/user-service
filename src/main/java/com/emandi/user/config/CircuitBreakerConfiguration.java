//package com.emandi.user.config;
//
//import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
//import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
//import io.github.resilience4j.timelimiter.TimeLimiterConfig;
//import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
//import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
//import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
//import org.springframework.cloud.client.circuitbreaker.Customizer;
//import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.Duration;
//
//@Configuration
//public class CircuitBreakerConfiguration {
//
//
//    @Bean
//    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .circuitBreakerConfig(CircuitBreakerConfig.custom().minimumNumberOfCalls(2).build())
//                .timeLimiterConfig(TimeLimiterConfig.custom()
//                .timeoutDuration(Duration.ofSeconds(4)).build()).build());
//    }
////    @Bean
////    public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(CircuitBreakerRegistry circuitBreakerRegistry) {
////        ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory();
////        reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(circuitBreakerRegistry);
////        return reactiveResilience4JCircuitBreakerFactory;
////    }
//
////    @Bean
////    public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(CircuitBreakerRegistry circuitBreakerRegistry, TimeLimiterRegistry timeLimiterRegistry) {
////        ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory();
////        // inject the created spring managed bean circuit breaker registry will all externally configured CBs
////        reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(circuitBreakerRegistry);
////        // Inject the the created spring managed bean time limter config for specific backend name otherwise use the default configuration from resilience4j
////        reactiveResilience4JCircuitBreakerFactory.configure(
////                builder -> builder
////                        .timeLimiterConfig(timeLimiterRegistry.getConfiguration("getInvoiceRetry").
////                                orElse(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(300)).build()))
////                        .circuitBreakerConfig(circuitBreakerRegistry.getConfiguration("default").
////                                        orElse(circuitBreakerRegistry.getDefaultConfig())),"backendB");
////        return reactiveResilience4JCircuitBreakerFactory;
////    }
////    @Bean
////    Customizer<ReactiveCircuitBreakerFactory> circuitBreakerFactory() {
////
////        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig
////                .custom()
////                .timeoutDuration(Duration.ofMillis(300))
////                .build();
////
////        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
////                .failureRateThreshold(5)
////                .waitDurationInOpenState(Duration.ofMillis(300))
////                .slidingWindowSize(2)
////                .build();
////
////        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder("config")
////                .circuitBreakerConfig(circuitBreakerConfig)
////                .timeLimiterConfig(timeLimiterConfig)
////                .build());
////
////    }
//}
