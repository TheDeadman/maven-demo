package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableConfigurationProperties(JankyProperties.class)
public class JankyConfig {

    @Autowired
    private JankyProperties jankyProperties;

    public String getUrl() {

        if (jankyProperties == null) {
            return "Nothing";
        }
        return jankyProperties.getUrl();
        // return env.getProperty("URL");
    }
}
