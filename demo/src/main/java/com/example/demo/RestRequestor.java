package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestRequestor {
    @Autowired
    private JankyConfig jankyConfig;

    public String requestNewTime() {

        RestTemplate restTemplate = new RestTemplate();
        // String result = restTemplate.getForObject(jankyConfig.getUrl() + "/time",
        // String.class);

        if (jankyConfig == null) {
            return "NULL";
        }
        return jankyConfig.getUrl();

        // return result;
    }
}
