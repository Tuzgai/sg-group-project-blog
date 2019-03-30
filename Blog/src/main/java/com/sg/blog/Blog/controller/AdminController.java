package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.UserRepository;
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
    
    @GetMapping
    String displayUsers(Model model) {
        List<User> users = userRepository.findAll();
        
        model.addAttribute("users", users);
        
        return "admin";
    }
    
}
