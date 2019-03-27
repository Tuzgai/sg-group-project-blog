package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Tag;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class TagDAOImpl implements TagDAO {

     private final String INSERT_TAG = "INSERT INTO tag name VALUES = ?";
    @Override
    public Tag createTag(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     private final String GET_ALLTAGS = "SELECT * FROM tag";
    @Override
    public List<Tag> getAllTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     private final String GET_ALLTAGSBYPOST = "";
    @Override
    public List<Tag> getTagsByPost(int postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
