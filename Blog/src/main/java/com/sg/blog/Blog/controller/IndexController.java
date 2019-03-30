package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import com.sg.blog.Blog.entity.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Stuart
 */
@Controller
public class IndexController {
    
    @Autowired
    PostRepository postRepository;
    
    @GetMapping("/")
    public String showIndex(Model model) {
        List<Post> posts = postRepository.findAll();
        
        model.addAttribute("posts", posts);
        
        return "index";
    }
}
