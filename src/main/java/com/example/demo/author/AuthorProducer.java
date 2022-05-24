package com.example.demo.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AuthorProducer {
    private static final Logger log = LoggerFactory.getLogger(AuthorProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public AuthorProducer(@Qualifier("authorRabbitTemplate") RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceAuthor(Author author) {
        log.debug("Producing author: {}", author);
        rabbitTemplate.convertAndSend("added", author);
    }
}
