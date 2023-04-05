package com.yxs.testcase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 洋小松
 * @date 2023/3/27
 */
@Configuration
public class Config {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
