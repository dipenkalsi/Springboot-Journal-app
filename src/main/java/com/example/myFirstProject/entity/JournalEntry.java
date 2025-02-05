package com.example.myFirstProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity //Means this is an entity
@Table(name="Journal") //Name of the table in the database where the journals will be stored.
public class JournalEntry {
    @Id //Use to declare id as the primary key of the table
    @Column(name = "ID") // column ka name jaha pe ye field store hogi.
    private long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Content")
    private String content;

//    @Column(name="OwnerId")
//    private long OwnerId;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    @JsonBackReference
    private User user;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
