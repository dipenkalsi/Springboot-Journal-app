package com.example.myFirstProject.service;

import com.example.myFirstProject.entity.JournalEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface JournalEntryService {
    public boolean create(JournalEntry journalEntry);

    public List<JournalEntry> readAll() throws RuntimeException;

    public boolean update(JournalEntry journalEntry, Long Id);

}
