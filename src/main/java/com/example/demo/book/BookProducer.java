package com.example.demo.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookProducer {
    private static final Logger log = LoggerFactory.getLogger(BookProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public BookProducer(@Qualifier("bookRabbitTemplate") RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceBook(Book book) {
        log.debug("Producing book: {}", book);
        rabbitTemplate.convertAndSend("added", book);
    }
}
