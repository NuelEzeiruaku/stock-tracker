package com.nuelezeiruaku.stock_tracker.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class webclientconfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder, 
                            @Value("${alpha.vantage.base.url}") String baseUrl) {
        return builder.baseUrl(baseUrl).build();
    }

}
