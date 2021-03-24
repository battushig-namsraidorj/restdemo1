package com.profnaya.restdemo1.restdemo1examples.service;

import com.profnaya.restdemo1.api.domain.Quote;
import com.profnaya.restdemo1.api.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiService {
    Quote getQuote();
    User getUser();
    List<User> getUsers();
}
