package com.library.service;

import com.library.domain.Role;
import com.library.domain.User;
import com.library.repository.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void loadUserByUsername() {
        User user = new User();
        userService.loadUserByUsername(user.getUsername());
        Mockito.verify(userRepo, Mockito.times(1)).findByUsername(user.getUsername());
    }

    @Test
    public void testLoadUserByUsername() {
    }

    @Test
    public void addUser() {
        User user = new User();
        userService.addUser(user);
        Assert.assertTrue(user.isActive());
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }
}