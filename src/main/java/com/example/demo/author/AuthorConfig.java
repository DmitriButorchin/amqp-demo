package com.example.demo.author;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorConfig {
    public static final String AUTHOR_EXCHANGE = "author.exchange";
    public static final String AUTHOR_QUEUE = "author.queue";

    @Bean
    public TopicExchange authorExchange() {
        return new TopicExchange(AUTHOR_EXCHANGE);
    }

    @Bean
    public Queue authorQueue() {
        return new Queue(AUTHOR_QUEUE);
    }

    @Bean
    public Binding authorBinding(Queue authorQueue, TopicExchange authorExchange) {
        return BindingBuilder.bind(authorQueue)
                .to(authorExchange)
                .with("#");
    }
}
