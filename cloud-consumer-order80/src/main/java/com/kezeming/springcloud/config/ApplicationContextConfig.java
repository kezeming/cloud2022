package com.kezeming.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/24 11:14
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    // @LoadBalanced  // 具备负载均衡能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
