package com.service.loan.service;

import com.service.loan.dto.OrderData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    private final List<OrderData> orderData = new ArrayList<>();

    public List<OrderData> getOrder(){
        return this.orderData;
    }

    public void saveOrder(OrderData data){
        orderData.add(data);
    }
}
