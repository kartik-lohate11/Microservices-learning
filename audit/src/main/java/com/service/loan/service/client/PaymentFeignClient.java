package com.service.loan.service.client;

import com.service.loan.service.client.fallback.PaymentFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment",fallback = PaymentFallBack.class)
public interface PaymentFeignClient {

    @GetMapping("/payment")
    public ResponseEntity<?> getAudit();
}
