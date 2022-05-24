package com.example.demo.author;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AuthorConfig {
    public static final String AUTHOR_EXCHANGE = "author.exchange";
    public static final String AUTHOR_QUEUE = "author.queue";

    @Bean
    public TopicExchange authorExchange() {
        return new TopicExchange(AUTHOR_EXCHANGE, false, true);
    }

    @Bean
    @Primary
    public RabbitTemplate authorRabbitTemplate(ConnectionFactory connectionFactory,
                                               MessageConverter messageConverter) {
        var template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        template.setExchange(AUTHOR_EXCHANGE);
        return template;
    }

    @Bean
    public Queue authorQueue() {
        return new Queue(AUTHOR_QUEUE, false);
    }

    @Bean
    public Binding authorAddedBinding(Queue authorQueue, TopicExchange authorExchange) {
        return BindingBuilder.bind(authorQueue)
                .to(authorExchange)
                .with("added");
    }
}
