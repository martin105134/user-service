package com.example.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import javax.management.ServiceNotFoundException;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean(name = "auth-service-validate")
    public WebClient webClientAuthService(WebClient.Builder webClientBuilder) {

        return webClientBuilder
                .baseUrl("http://localhost:8090/api/v1/validate")
                .build();
    }
}