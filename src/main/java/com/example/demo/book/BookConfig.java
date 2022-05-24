package com.example.demo.book;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {
    public static final String BOOK_EXCHANGE = "book.exchange";
    public static final String BOOK_QUEUE = "book.queue";

    @Bean
    public TopicExchange bookExchange() {
        return new TopicExchange(BOOK_EXCHANGE, false, true);
    }

    @Bean
    public RabbitTemplate bookRabbitTemplate(ConnectionFactory connectionFactory,
                                             MessageConverter messageConverter) {
        var template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        template.setExchange(BOOK_EXCHANGE);
        return template;
    }

    @Bean
    public Queue bookQueue() {
        return new Queue(BOOK_QUEUE, false);
    }

    @Bean
    public Binding bookAddedBinding(Queue bookQueue, TopicExchange bookExchange) {
        return BindingBuilder.bind(bookQueue)
                .to(bookExchange)
                .with("added");
    }
}
