package com.profnaya.restdemo1.restdemo1examples.service;

import com.profnaya.restdemo1.api.domain.Quote;
import com.profnaya.restdemo1.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;
    private final String api_url_users;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url.users}") String api_url_users) {
        this.restTemplate = restTemplate;
        this.api_url_users = api_url_users;
    }


    @Override
    public Quote getQuote() {
        return restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random",Quote.class);
    }

    @Override
    public User getUser() {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/1", User.class);
    }

    @Override
    public List<User> getUsers() {
        UriComponentsBuilder uriBuilder =  UriComponentsBuilder
                .fromUriString(api_url_users);
                //.queryParam("limit", 10); //if url has parameter
        User[] users = restTemplate.getForObject(uriBuilder.toUriString(), User[].class);
        return Arrays.asList(users);
    }
}
