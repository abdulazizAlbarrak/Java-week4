package com.example.week4hw19.Repository;

import com.example.week4hw19.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog getBlogById(Integer id);
    Blog getBlogByTitle(String title);
    Blog getBlogByCategory(String category);

}
