package com.example.demo.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.demo.author.AuthorConfig.AUTHOR_QUEUE;

@Component
public class AuthorConsumer {
    private static final Logger log = LoggerFactory.getLogger(AuthorConsumer.class);

    @RabbitListener(queues = AUTHOR_QUEUE)
    public void receiveAuthor(Author author) {
        log.debug("Received author: {}", author);
    }
}
