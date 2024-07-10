package com.example.myFirstProject.service.impl;

import com.example.myFirstProject.entity.JournalEntry;
import com.example.myFirstProject.repository.JournalRepository;
import com.example.myFirstProject.service.JournalEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {
    @Autowired
    JournalRepository journalRepository;

    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Override
    public boolean create(JournalEntry journalEntry) {
        journalRepository.save(journalEntry);
        return true;
    }

    @Override
    public List<JournalEntry> readAll() throws RuntimeException {
        try{
            logger.info("Successfully fetched the entries from DB.");
            return journalRepository.findAll();
        }
        catch(Exception e){
            logger.error("There was an error while fetching the entries.");
            throw new RuntimeException("The following error occurred while fetching entries from the DB", e);
        }
    }

    @Override
    public boolean update(JournalEntry journalEntry, Long id) {
        journalRepository.save(journalEntry);
        return true;
    }




}
