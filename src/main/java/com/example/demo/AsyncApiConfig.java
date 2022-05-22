package com.example.demo;

import com.asyncapi.v2.model.info.Info;
import io.github.stavshamir.springwolf.configuration.AsyncApiDocket;
import io.github.stavshamir.springwolf.configuration.EnableAsyncApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAsyncApi
public class AsyncApiConfig {
    @Bean
    public AsyncApiDocket asyncApiDocket() {
        var info = Info.builder()
                .title("Demo project")
                .version("0.0.1")
                .build();

        return AsyncApiDocket.builder()
                .basePackage("com.example.demo")
                .info(info)
                .build();
    }
}
