package com.service.loan.service;

import com.service.loan.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    private static Long amount = 500L;

    public void saveAmount(Long amount) {
        PaymentService.amount += amount;
    }

    public Long getAmount() {
            return amount;
    }

}
