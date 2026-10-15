package com.service.loan.controller;

import com.service.loan.dto.PaymentData;
import com.service.loan.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class MainController {

    private final PaymentService paymentService;

    @GetMapping("/health")
    public ResponseEntity<?> health(){
        return ResponseEntity.ok("Services is healthy");
    }

    @GetMapping
    public ResponseEntity<?> getAudit() {
        return ResponseEntity.ok(paymentService.getAmount());
    }

    @PostMapping
    public ResponseEntity<?> saveAudit(@RequestBody PaymentData paymentData) {
        paymentService.saveAmount(paymentData.getAmount());
        return ResponseEntity.ok("Data saved");
    }


}
