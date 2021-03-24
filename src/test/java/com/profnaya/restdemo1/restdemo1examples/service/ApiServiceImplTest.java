package com.profnaya.restdemo1.restdemo1examples.service;

import com.profnaya.restdemo1.api.domain.Quote;
import com.profnaya.restdemo1.api.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Test
    void testGetQuote() {
        Quote quote = apiService.getQuote();
        assertEquals("success", quote.getType() );
    }

    @Test
    void testGetUser() {
        User user = apiService.getUser();
        assertEquals(1, user.getId());
    }

    @Test
    void testGetUsers() {
        List<User> users = apiService.getUsers();
        assertEquals(10, users.size() );
    }
}