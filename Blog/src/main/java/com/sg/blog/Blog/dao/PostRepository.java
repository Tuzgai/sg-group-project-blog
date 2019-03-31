package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Post;
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
}
