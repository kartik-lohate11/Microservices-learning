package com.service.gatewayserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/health")
    public ResponseEntity<?> health(){
        return ResponseEntity.ok("Services is healthy");
    }

    @GetMapping("/contact")
    public ResponseEntity<?> contact(){
        return ResponseEntity
                .status(503)
                .body("Kindly Server facing some issue. Try after some moments!...");
    }
}
