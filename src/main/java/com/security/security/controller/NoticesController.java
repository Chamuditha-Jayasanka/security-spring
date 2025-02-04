package com.security.security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
@CrossOrigin
public class NoticesController {
    @GetMapping("/my-notice")
    public String getAccountDetails() {
        return "here are the notice details";
    }
}
