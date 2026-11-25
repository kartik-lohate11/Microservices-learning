package com.service.message.function;

import com.service.message.dto.OrderEventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Configuration
@Slf4j
public class OrderEventFunctions {

    @Bean
    public Function<OrderEventDto, OrderEventDto> send() {
        return orderEventDto -> {
            log.info("{} : Order is placed", orderEventDto.id());
            return orderEventDto;
        };
    }

    @Bean
    public Function<OrderEventDto, Long> sms() {
        return orderEventDto -> {
            log.info("{} : Order is places by SMS provider", orderEventDto.orderName());
            return orderEventDto.id();
        };
    }
}
