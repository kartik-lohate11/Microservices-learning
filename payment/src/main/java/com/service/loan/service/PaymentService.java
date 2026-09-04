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

    public Payment createPayment(PaymentRequest request) {

        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .userId(request.getUserId())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .status("PENDING")
                .build();

        return paymentRepository.save(payment);
    }

    public Payment getPayment(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public Payment updateStatus(Long paymentId, String status) {

        Payment payment = getPayment(paymentId);

        payment.setStatus(status);

        return paymentRepository.save(payment);
    }

}
