package com.example.myFirstProject.repository;

import com.example.myFirstProject.entity.JournalEntry;
import com.example.myFirstProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="Select * from Journal where OwnerId=:UserId", nativeQuery = true)
    public List<JournalEntry> getJournalEntriesByUserId(@Param("UserId") Long UserId);
}
