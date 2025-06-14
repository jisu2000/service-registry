package org.samrthire.service_registry.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<?> test(){

        return ResponseEntity.ok(
                Map.of("message", "System is up and running",
                        "Time", LocalDateTime.now().toString())

        );
    }
}
