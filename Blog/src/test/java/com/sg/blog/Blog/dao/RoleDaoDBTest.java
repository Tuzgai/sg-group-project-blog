package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Role;
import com.sg.blog.Blog.entity.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Stuart
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoDBTest {
    
    @Autowired
    RoleDao roleDao;
    
    @Autowired
    UserDao userDao;
    
    public RoleDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Clear out the DBs before any tests
        List<Role> roles = roleDao.getAllRoles();
        List<User> users = userDao.getAllUsers();
        
        roles.forEach(r -> roleDao.deleteRole(r.getId()));
        users.forEach(u -> userDao.deleteUser(u.getId()));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCreateAndGetRole() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);
        Role fromDao = roleDao.getRoleById(role.getId());
        assertEquals(fromDao, role);
    }
    
    @Test
    public void testGetAllRoles() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);
        
        Role role2 = new Role();
        role2.setRole("Test 2");
        role2 = roleDao.createRole(role);
        
        List<Role> fromDao = roleDao.getAllRoles();
        assertEquals(2, fromDao.size());
        assertTrue(fromDao.contains(role));
        assertTrue(fromDao.contains(role2));
    }
    
    @Test
    public void testUpdateRole() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);
        
        Role fromDao = roleDao.getRoleById(role.getId());
        
        assertEquals(role, fromDao);
        
        role.setRole("Test update");
        roleDao.updateRole(role);
        
        assertNotEquals(role, fromDao);
        
        fromDao = roleDao.getRoleById(role.getId());
        
        assertEquals(role, fromDao);
    }
    
    @Test
    public void testDeleteRole() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);
        
        Role role2 = new Role();
        role2.setRole("Test 2");
        role2 = roleDao.createRole(role);
        
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        
        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setFullname("Stuart W");
        user.setUsername("stuartw");
        user.setPassword("test");
        user.setRoles(roles);
        user = userDao.createUser(user);
        
        roleDao.deleteRole(role.getId());
        
        user = userDao.getUserById(user.getId());
        assertTrue(user.getRoles().isEmpty());
        
        assertNull(roleDao.getRoleById(role.getId()));
        
        List<Role> fromDao = roleDao.getAllRoles();
        
        assertEquals(1, fromDao.size());
        assertFalse(fromDao.contains(role));
    }
}
