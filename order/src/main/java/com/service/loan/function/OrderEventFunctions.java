package com.service.loan.function;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class OrderEventFunctions {

    @Bean
    public Consumer<Long> updateOrder() {
        return orderVal -> {
                log.info("Order data is {} ; Order received", orderVal);
        };
    }
}
