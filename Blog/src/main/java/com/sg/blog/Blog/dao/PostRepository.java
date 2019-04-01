package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Post;
import org.apache.catalina.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stuart
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
