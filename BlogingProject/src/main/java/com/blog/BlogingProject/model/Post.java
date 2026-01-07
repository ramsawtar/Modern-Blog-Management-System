package com.blog.BlogingProject.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "posts") // Optional but good practice

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content", length = 5000) // Increase length for content
    private String content;

    @Column(name = "author") // Fixed: Changed from "auther" to "author"
    private String author;   // Fixed: Changed variable name

    public Post() {
    }

    // Updated constructor
    public Post(Integer id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and setters - FIXED
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {  // Fixed getter name
        return author;
    }

    public void setAuthor(String author) {  // Fixed setter name
        this.author = author;
    }
}