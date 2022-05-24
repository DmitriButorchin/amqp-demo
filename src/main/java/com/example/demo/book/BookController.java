package com.example.demo.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookProducer bookProducer;

    public BookController(BookProducer bookProducer) {
        this.bookProducer = bookProducer;
    }

    @PostMapping("/books")
    public void createBook(@RequestBody Book book) {
        log.debug("Creating book: {}", book);
        bookProducer.produceBook(book);
    }
}
