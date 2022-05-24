package com.example.demo;

import com.asyncapi.v2.binding.amqp.AMQPOperationBinding;
import com.asyncapi.v2.model.info.Info;
import com.example.demo.author.Author;
import com.example.demo.book.Book;
import io.github.stavshamir.springwolf.asyncapi.types.ProducerData;
import io.github.stavshamir.springwolf.configuration.AsyncApiDocket;
import io.github.stavshamir.springwolf.configuration.EnableAsyncApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@EnableAsyncApi
public class AsyncApiConfig {
    @Bean
    public AsyncApiDocket asyncApiDocket() {
        var info = Info.builder()
                .title("Demo project")
                .version("0.0.1")
                .build();

        var authorProducer = ProducerData.builder()
                .channelName("added")
                .payloadType(Author.class)
                .binding(Map.of("amqp", new AMQPOperationBinding()))
                .build();
        var bookProducer = ProducerData.builder()
                .channelName("added")
                .payloadType(Book.class)
                .binding(Map.of("amqp", new AMQPOperationBinding()))
                .build();

        return AsyncApiDocket.builder()
                .basePackage("com.example.demo")
                .info(info)
                .producers(List.of(authorProducer, bookProducer))
                .build();
    }
}
