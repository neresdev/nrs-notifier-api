package com.nrs.notifier.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping
@RestController
public class NotifierResource {

    @GetMapping("/send-message")
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("ok: " + LocalDateTime.now());
    }
}
