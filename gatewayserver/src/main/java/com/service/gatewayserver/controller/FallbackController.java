package com.service.gatewayserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/contact")
    public ResponseEntity<?> contact(){
        return ResponseEntity
                .status(503)
                .body("Kindly Server facing some issue. Try after some moments!...");
    }
}
