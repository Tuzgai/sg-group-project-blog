package com.sg.blog.Blog.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.blog.Blog.entity.Tag;
import java.util.List;

/**
 *
 * @author kahin
 */
public interface TagDAO {
 
       
    Tag createTag(Tag tag);

    List<Tag> getAllTags();
    
     List<Tag> getTagsByPost(int postID);
    
}
