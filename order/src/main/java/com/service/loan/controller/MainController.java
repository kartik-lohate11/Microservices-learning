package com.service.loan.controller;

import com.service.loan.dto.OrderData;
import com.service.loan.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class MainController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAudit() {
        return ResponseEntity.ok(orderService.getOrder());
    }

    @PostMapping
    public ResponseEntity<?> saveAudit(@RequestBody OrderData auditData) {
        orderService.saveOrder(auditData);
        return ResponseEntity.ok("Data saved");
    }


}
