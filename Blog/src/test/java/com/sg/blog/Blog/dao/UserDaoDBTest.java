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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/**
 *
 * @author Stuart
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoDBTest {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao userDao;

    public UserDaoDBTest() {
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
    public void testCreateAndGetUser() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();

        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setFullname("Stuart W");
        user.setUsername("stuartw");
        user.setPassword("test");
        user.setRoles(roles);
        user = userDao.createUser(user);

        User fromDao = userDao.getUserById(user.getId());

        assertEquals(user, fromDao);
    }

    @Test
    public void testGetAllUsers() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();

        Role role2 = new Role();
        role2.setRole("Test 2");
        role2 = roleDao.createRole(role);

        Set<Role> roles2 = new HashSet<>();

        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setFullname("Stuart W");
        user.setUsername("stuartw");
        user.setPassword("test");
        user.setRoles(roles);
        user = userDao.createUser(user);

        User user2 = new User();
        user2.setEmail("test@test.com2");
        user2.setEnabled(true);
        user2.setFullname("Stuart W2");
        user2.setUsername("stuartw2");
        user2.setPassword("test2");
        user2.setRoles(roles2);
        user2 = userDao.createUser(user2);

        List<User> fromDao = userDao.getAllUsers();

        assertEquals(2, fromDao.size());
        assertTrue(fromDao.contains(user));
        assertTrue(fromDao.contains(user2));
    }

    @Test
    public void testUpdateUser() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();

        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setFullname("Stuart W");
        user.setUsername("stuartw");
        user.setPassword("test");
        user.setRoles(roles);
        user = userDao.createUser(user);
        
        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
        
        Role role2 = new Role();
        role2.setRole("Test 2");
        role2 = roleDao.createRole(role);
        
        roles.clear();
        roles.add(role2);
        
        user.setRoles(roles);
        userDao.updateUser(user);
        
        assertNotEquals(role, fromDao);
        
        fromDao = userDao.getUserById(user.getId());
        
        assertEquals(user, fromDao);
    }

    @Test
    public void testDeleteUser() {
        Role role = new Role();
        role.setRole("Test");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();

        User user = new User();
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setFullname("Stuart W");
        user.setUsername("stuartw");
        user.setPassword("test");
        user.setRoles(roles);
        user = userDao.createUser(user);
        
        User user2 = new User();
        user2.setEmail("test@test.com2");
        user2.setEnabled(true);
        user2.setFullname("Stuart W2");
        user2.setUsername("stuartw2");
        user2.setPassword("test2");
        user2.setRoles(roles);
        user2 = userDao.createUser(user2);
        
        userDao.deleteUser(user.getId());
        
        List<User> fromDao = userDao.getAllUsers();
        
        assertEquals(1, fromDao.size());
        assertFalse(fromDao.contains(role));
    }
    
}
