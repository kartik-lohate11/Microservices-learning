package com.service.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.time.Duration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locator) {
        return locator.routes()
                .route(
                        p -> p
                                .path("/kartik/audit/**")
                                .filters(f -> f.rewritePath("/kartik/audit/(?<segment>.*)", "/${segment}")
                                        .circuitBreaker(config -> config.setName("auditCircuitBreaker")
                                                .setFallbackUri("forward:/contact")))
                                .uri("lb://AUDIT")
                )
                .route(
                        p -> p
                                .path("/kartik/order/**")
                                .filters(f -> f.rewritePath("/kartik/order/(?<segment>.*)", "/${segment}")
                                        .circuitBreaker(config -> config.setName("orderCircuitBreaker")
                                                .setFallbackUri("forward:/contact"))
                                        .retry(retryConfig -> retryConfig
                                                .setRetries(3)
                                                .setMethods(HttpMethod.GET)
                                                .setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true))

                                )
                                .uri("lb://ORDER")
                )
                .route(
                        p -> p
                                .path("/kartik/payment/**")
                                .filters(f -> f.rewritePath("/kartik/payment/(?<segment>.*)", "/${segment}")
                                        .circuitBreaker(config -> config.setName("paymentCircuitBreaker")
                                                .setFallbackUri("forward:/contact")
                                        ))
                                .uri("lb://PAYMENT")
                ).build();
    }
}
