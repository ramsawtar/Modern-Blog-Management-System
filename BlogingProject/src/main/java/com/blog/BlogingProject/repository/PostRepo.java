package com.blog.BlogingProject.repository;

import com.blog.BlogingProject.model.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {


}
