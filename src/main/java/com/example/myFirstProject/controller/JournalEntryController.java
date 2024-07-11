package com.example.myFirstProject.controller;

import com.example.myFirstProject.entity.JournalEntry;
import com.example.myFirstProject.repository.JournalRepository;
import com.example.myFirstProject.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;
//    public Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @Autowired
    JournalRepository journalRepository;

    @GetMapping
    List<JournalEntry> getAll(){
        return journalEntryService.readAll();
    }

    @PostMapping
    public boolean createEntries(@RequestBody JournalEntry myEntry){
        journalEntryService.create(myEntry);
        return true;
    }

    @PostMapping("post-multiple")
    public boolean createMultipleEntries(@RequestBody List<JournalEntry> myEntries){
        for(int i=0; i<myEntries.size(); i++){
            journalEntryService.create(myEntries.get(i));
        }
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalRepository.getEntryById(myId);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable Long myId){
        try {
            journalRepository.deleteEntryById(myId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @PutMapping("id/{myId}")
    public boolean updateJournalEntry(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
        journalEntryService.update(myEntry, myId);
        return true;
    }
}
