package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import com.sg.blog.Blog.dao.UserRepository;
import com.sg.blog.Blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Stuart
 */

@Controller
public class PostController {
    
    @Autowired
    PostRepository postRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/post")
    String displayPostPage(Model model) {
        
        return "post";
    }
    
    @PostMapping("/post")
    String createPost(Post post) {
        // Note that this is using the spring security user, not ours
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        
        post.setUser(userRepository.findByUsername(name).get(0));
        
        postRepository.save(post);
        
        return "redirect:/";
    }
    
}
