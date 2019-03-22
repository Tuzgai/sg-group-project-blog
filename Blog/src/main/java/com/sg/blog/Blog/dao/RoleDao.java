package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Role;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface RoleDao {
    Role getRoleById(int id);
    Role getRoleByRole(String role);
    List<Role> getAllRoles();
    void deleteRole(int id);
    void updateRole(Role role);
    Role createRole(Role role);
}
