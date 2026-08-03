package com.service.loan.service.client.fallback;

import com.service.loan.service.client.PaymentFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBack implements PaymentFeignClient {
    @Override
    public ResponseEntity<?> getAudit() {
        return ResponseEntity.status(503).body("Issue to process Payment... Try After some moments");
    }
}
