package com.example.PPSIntershipRESTapi.controllers;

import com.example.PPSIntershipRESTapi.responses.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping({"/","/home"})
    public ResponseEntity<MessageResponse> welcomeMessage(){
        return ResponseEntity.ok(new MessageResponse("Welcome to Luis Somoza PPS REST API Microservice for Intership In Java, have a good time <3"));
    }
}
