package com.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") String userId) {
        return "User details for user id: " + userId;
    }
    
    @GetMapping
    public String getUsers() {
        return "All Users";
    }
    
}

