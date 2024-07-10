package com.example.myFirstProject.repository;

import com.example.myFirstProject.entity.JournalEntry;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
//    public boolean updateById(JournalEntry journalEntry, Long id);
    @Query(value="SELECT * from Journal WHERE id=:id", nativeQuery = true)
    public JournalEntry getEntryById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value="DELETE from Journal WHERE id=:id", nativeQuery = true)
    public void deleteEntryById(@Param("id") Long id);
}
