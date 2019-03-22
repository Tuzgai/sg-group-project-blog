package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.User;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface UserDao {
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
    User createUser(User user);
}
