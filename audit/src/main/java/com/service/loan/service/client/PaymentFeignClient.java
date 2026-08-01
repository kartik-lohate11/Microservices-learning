package com.service.loan.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("payment")
public interface PaymentFeignClient {

    @GetMapping("/payment")
    public ResponseEntity<?> getAudit();
}
