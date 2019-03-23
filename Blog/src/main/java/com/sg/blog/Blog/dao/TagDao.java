/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Tag;
import java.util.List;

/**
 *
 * @author abdisamadugas
 */
public interface TagDao {

    Tag getTagByName(String name);

    List<Tag> getAllTags();

    Tag addTag(Tag tag);
    
    void getTagByPost(String post);

    
}
