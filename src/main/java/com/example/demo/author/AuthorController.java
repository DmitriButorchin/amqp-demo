package com.example.demo.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

    private final AuthorProducer authorProducer;

    public AuthorController(AuthorProducer authorProducer) {
        this.authorProducer = authorProducer;
    }

    @PostMapping("/authors")
    public void createAuthor(@RequestBody Author author) {
        log.debug("Creating author: {}", author);
        authorProducer.produceAuthor(author);
    }
}
