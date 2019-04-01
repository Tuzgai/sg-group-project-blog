package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import com.sg.blog.Blog.dao.UserRepository;
import com.sg.blog.Blog.entity.Post;
import com.sg.blog.Blog.entity.User;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Stuart
 */

@Controller
public class AdminController {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PostRepository postRepository;
    
    @GetMapping("/admin")
    String showAdminPage(Model model) {
        List<User> users = userRepository.findAll();
        List<Post> posts = postRepository.findByApprovedFalse();
        
        posts = posts.stream()
                .sorted(Comparator.comparing(Post::getTimestamp)
                        .reversed())
                .collect(Collectors.toList());
        
        model.addAttribute("users", users);
        model.addAttribute("posts", posts);
        
        return "admin";
    }
}
