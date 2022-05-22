package com.example.demo.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.demo.book.BookConfig.BOOK_QUEUE;

@Component
public class BookConsumer {
    private static final Logger log = LoggerFactory.getLogger(BookConsumer.class);

    @RabbitListener(queues = BOOK_QUEUE)
    public void receiveBook(Book book) {
        log.debug("Received book: {}", book);
    }
}
