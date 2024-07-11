package com.example.myFirstProject.controller;

import com.example.myFirstProject.entity.JournalEntry;
import com.example.myFirstProject.entity.User;

import com.example.myFirstProject.repository.UserRepository;
import com.example.myFirstProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/{userId}/journalEntries")
    public JournalEntry addJournalEntryToUser(@PathVariable Long userId, @RequestBody JournalEntry journalEntry) {
        return userService.addJournalEntryToUser(userId, journalEntry);
    }

    @GetMapping("/{userId}/journalEntries")
    public List<JournalEntry> getUserJournalEntries(@PathVariable Long userId) {
        return userService.getUserJournalEntries(userId);
    }
}
