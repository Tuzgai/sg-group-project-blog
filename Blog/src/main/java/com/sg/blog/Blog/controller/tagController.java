/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.Blog.controller;

import com.sg.blog.Blog.dao.PostRepository;
import com.sg.blog.Blog.dao.RoleRepository;
import com.sg.blog.Blog.dao.TagRepository;
import com.sg.blog.Blog.dao.UserRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kahin
 */
@Controller
public class tagController {
    @Autowired
    PostRepository postR;

    @Autowired
    RoleRepository roleR;

    @Autowired
    TagRepository tagR;

    @Autowired
    UserRepository userR;
    
    @GetMapping("/AllPostsWithThisTag")
    public String tagPost(HttpServletRequest request, Model model){
      String tag =  request.getParameter("tag");
      Tag object = tagR.findById(tag);
    }
}
