package com.blog.BlogingProject.controller;

import com.blog.BlogingProject.model.Post;
import com.blog.BlogingProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private PostRepo repo;

    // Home page
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPosts", repo.findAll());
        return "index";
    }

    // Show form to create new post
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "new_post";
    }

    // Handle form submission for new posts
    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post) {
        repo.save(post);
        return "redirect:/";
    }

    // Show edit form (use edit_post.html template)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        // FIX: Added .orElseThrow() to handle Optional
        Post post = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + id));
        model.addAttribute("post", post);
        return "edit_post"; // Changed from "new_post" to "edit_post"
    }

    // Handle update for existing posts
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post) {
        repo.save(post); // save() works for both insert and update
        return "redirect:/";
    }

    // Delete post
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}