package com.service.loan.controller;

import com.service.loan.dto.AuditData;
import com.service.loan.service.AuditService;
import com.service.loan.service.client.PaymentFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit")
@RequiredArgsConstructor
public class MainController {

    private final AuditService auditService;
    private final PaymentFeignClient paymentFeignClient;

    @GetMapping
    public ResponseEntity<?> getAudit() {

        return ResponseEntity.ok(auditService.getAudit());
    }

    @PostMapping
    public ResponseEntity<?> saveAudit(@RequestBody AuditData auditData) {
        auditService.saveAudit(auditData);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/pay")
    public ResponseEntity<?> payment(){
       return ResponseEntity.ok(paymentFeignClient.getAudit());
    }


}
