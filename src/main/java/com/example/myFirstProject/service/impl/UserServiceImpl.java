package com.example.myFirstProject.service.impl;

import com.example.myFirstProject.entity.JournalEntry;
import com.example.myFirstProject.entity.User;
import com.example.myFirstProject.repository.JournalRepository;
import com.example.myFirstProject.repository.UserRepository;
import com.example.myFirstProject.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalRepository journalEntryRepository;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public JournalEntry addJournalEntryToUser(Long userId, JournalEntry journalEntry) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        journalEntry.setUser(user);
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getUserJournalEntries(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getJournalEntries();
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
