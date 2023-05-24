package com.example.week4hw19.Service;

import com.example.week4hw19.Model.Blog;
import com.example.week4hw19.Repository.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {


    private final BlogRepository blogRepository;

    public List<Blog> getAll(){
        return blogRepository.findAll();
    }
    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }
    public void updateBlog(int id, Blog blog){
        Blog blog_old = blogRepository.getBlogById(id);
        blog_old.setBody(blog.getBody());
        blog_old.setCategory(blog.getCategory());
        blog_old.setTitle(blog.getTitle());
        blog_old.setPublished(blog.isPublished());
        blogRepository.save(blog_old);
    }
    public void deleteBlog(int id){
        Blog blog = blogRepository.getBlogById(id);
        blogRepository.delete(blog);
    }
    public Blog getBlogById(int id){
        return blogRepository.getBlogById(id);
    }
    public Blog getBlogByTitle(String title){
        return blogRepository.getBlogByTitle(title);
    }
    public Blog getBlogByCategory(String category){
        return blogRepository.getBlogByCategory(category);
    }
    public void changeStatus(int id){
       Blog blog_old = blogRepository.getBlogById(id);
       blog_old.setPublished(true);
       blogRepository.save(blog_old);
    }
}
