package com.example.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class CustomGatewayFilterFactory
        extends AbstractGatewayFilterFactory<CustomGatewayFilterFactory.Config> {

    public CustomGatewayFilterFactory() {
        super(Config.class);
    }

    @Autowired
    private ScheduledFixedRateExample scheduledFixedRateExample;

    @Autowired
    private JankyConfig jankyConfig;

    @Override
    public GatewayFilter apply(Config config) {
        // return (exchange, chain) -> {
        // // If you want to build a "pre" filter you need to manipulate the
        // // request before calling chain.filter
        // ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
        // // use builder to manipulate the request
        // return chain.filter(exchange.mutate().request(builder.build()).build());
        // };
        return (exchange, chain) -> {
            System.out.println("\n\nOUT\n\n\n");
            System.out.print(jankyConfig.getUrl());
            String time = scheduledFixedRateExample.getTime();

            ServerHttpRequest request = exchange.getRequest().mutate()
                    // .header(config.getName(), time)
                    .header("THE-TIME", time)
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {
        // Put the configuration properties for your filter here
    }
}