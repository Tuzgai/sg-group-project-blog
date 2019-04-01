package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import com.sg.blog.Blog.dao.TagRepository;
import com.sg.blog.Blog.dao.UserRepository;
import com.sg.blog.Blog.entity.Post;
import com.sg.blog.Blog.entity.Tag;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    
    @Autowired
    TagRepository tagRepository;
    
    @GetMapping("/post")
    String displayPostPage(Model model) {
        
        return "post";
    }
    
    @PostMapping("/post")
    String createPost(Post post, HttpServletRequest request) {
        // Note that this is using the spring security user, not ours
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        
        post.setUser(userRepository.findByUsername(name).get(0));
        
        if(post.getStartdate() == null) {
            post.setStartdate(LocalDate.of(1000, 1, 1));
        }
        
        if(post.getEnddate() == null) {
            post.setEnddate(LocalDate.of(9999, 12, 31));
        }
        
        // Process string of comma-separated tags into list of Tags
        String tagString = request.getParameter("tagString");
        tagString = tagString.replace(" ", "");
        String [] tagArr = tagString.split(",");
        List<Tag> tags = new ArrayList<>();
        for(String tagName : tagArr) {
            Tag tag = new Tag();
            tag.setName(tagName);
            tagRepository.save(tag);
            tags.add(tag);
        }
        
        post.setTags(tags);
        
        postRepository.save(post);
        
        return "redirect:/";
    }
    
}
