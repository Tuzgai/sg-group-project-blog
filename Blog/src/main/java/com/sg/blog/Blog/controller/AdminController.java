package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import com.sg.blog.Blog.dao.UserRepository;
import com.sg.blog.Blog.entity.Post;
import com.sg.blog.Blog.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Stuart
 */
public class AdminController {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PostRepository postRepository;
    
    @GetMapping("/admin")
    String showAdminPage(Model model) {
        List<User> users = userRepository.findAll();
        List<Post> posts = postRepository.findByApprovedFalse();
        
        model.addAttribute("users", users);
        model.addAttribute("posts", posts);
        
        return "admin";
    }
}
