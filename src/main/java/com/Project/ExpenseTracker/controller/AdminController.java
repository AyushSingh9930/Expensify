package com.Project.ExpenseTracker.controller;

import com.Project.ExpenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        System.out.println("Admin delete requested for ID: " + id);
        return userService.deleteUser(id);
    }
}
