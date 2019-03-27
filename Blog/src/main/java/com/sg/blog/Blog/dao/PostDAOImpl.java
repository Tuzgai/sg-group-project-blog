/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Post;
import com.sg.blog.Blog.entity.Tag;
import java.time.LocalDate;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class PostDAOImpl implements PostDAO {
    
    JdbcTemplate jdbc;

    private final String INSERT_POST = "Insert Into post title,body,time,Date,isfeatured, user_id VALUES = ?,?,?,?,?,?";
    @Override
    public Post createPost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final String SELECT_POST =  "Select from post where id = ?";
    @Override
    public Post getPost(int postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post updatePost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private final String DELETE_POST =  "Delete FROM post where id = ?";
    @Override
    public Post deletePost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final String SELECT_POSTS =  "Select * From post";
    @Override
    public List<Post> getAllPosts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final String SELECT_DATE =  "Select * From post where date = ?";
    @Override
    public List<Post> getAllPostByDateRange(LocalDate start, LocalDate end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final String SELECT_POSTTAG =  "Select * From post where`";
    @Override
    public List<Post> getAllPostsByHashTag(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
////BRIDGETABLE?
    @Override
    public List<Tag> getTagsByPost(int postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
