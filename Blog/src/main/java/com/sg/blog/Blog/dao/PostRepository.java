package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Post;
import com.sg.blog.Blog.entity.Tag;
import com.sg.blog.Blog.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stuart
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    public List<Post> findByApprovedFalse();
    public List<Post> findByApprovedTrue();
    public List<Post> findByTagsContaining(Tag tag);
    public List<Post> findByTagsContainingOrderByTimestamp(Tag tag);
    public List<Post> findByUser(User user);
}
