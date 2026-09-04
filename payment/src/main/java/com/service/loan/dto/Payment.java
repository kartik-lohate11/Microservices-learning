package com.service.loan.dto;

import lombok.Data;

@Data
public class Payment {
    private Long paymentId;

    private Long orderId;
    private Long userId;
    private Double amount;
    private String paymentMethod;
    private String status;
}
