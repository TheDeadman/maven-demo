package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// @Configuration
// @Component
@ConfigurationProperties(prefix = "testing")
public class JankyProperties {

    private String url;

    public JankyProperties(String url) {
        System.out.println("\n\nHEREE constructor\n\n");
        System.out.println(url);
        System.out.println("\n\nEND constructor\n\n");
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        System.out.println("\n\nHEREE setURL\n\n");
        System.out.println(url);
        System.out.println("\n\nEND setURL\n\n");

        this.url = url;
    }
}
