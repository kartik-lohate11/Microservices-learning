package com.service.loan.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private Long userId;
    private Double amount;
    private String paymentMethod;
}
