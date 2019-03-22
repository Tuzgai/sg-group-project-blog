/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.Blog.dao;

import PostDTO.Post;
import PostDTO.Tag;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author kahin
 */
public interface PostDAO {

    Post createPost(Post post);

    Post getPost(int postID);

    Post updatePost(Post post);

    Post deletePost(Post post);

    List<Post> getAllPosts();
    
    List<Post> getAllPostByDateRange(LocalDate start, LocalDate end);
    
    List<Post> getAllPostsByHashTag(Tag tag);
    
    List<Tag> getTagsByPost(int postID);

}
