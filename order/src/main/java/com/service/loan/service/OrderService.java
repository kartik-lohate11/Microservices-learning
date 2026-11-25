package com.service.loan.service;

import com.service.loan.dto.OrderData;
import com.service.loan.dto.OrderEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final List<OrderData> orderData = new ArrayList<>();
    private final StreamBridge streamBridge;

    public List<OrderData> getOrder() {
        return this.orderData;
    }

    public void saveOrder(OrderData data) {
        orderData.add(data);
        log.info("Order is created.." + data.getOrderName());
        OrderEventDto order = new OrderEventDto(
                10L, "ABC Order", "New Order", LocalDate.now()
        );
        boolean ack = streamBridge.send("send-communication", order);
        if (ack) {
            log.info("Order send...");
        } else {
            log.error("Failed to send Order");
        }
    }
}
