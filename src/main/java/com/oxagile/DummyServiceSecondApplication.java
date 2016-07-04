package com.oxagile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
public class DummyServiceSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyServiceSecondApplication.class, args);
    }
}
