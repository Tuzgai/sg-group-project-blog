    package com.sg.blog.Blog.dao;

import org.apache.catalina.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stuart
 */
@Repository
public interface RoleRepository extends JpaRepository<Store, Integer>{

}