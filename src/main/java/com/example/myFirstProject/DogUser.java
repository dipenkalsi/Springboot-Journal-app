package com.example.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogUser {
    private Dog doggo;

    @Autowired
    public void MyController(Dog doggo) {
        this.doggo = doggo;
    }

    @GetMapping("/doggoName")
    public String getName() {
        return doggo.getName();
    }
}
