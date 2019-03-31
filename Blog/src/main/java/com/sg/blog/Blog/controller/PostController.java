package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Stuart
 */

@Controller
public class PostController {
    
    @Autowired
    PostRepository postRespository;
    
    @GetMapping("/post")
    String displayPostPage(Model model) {
        
        return "post";
    }
    
}
