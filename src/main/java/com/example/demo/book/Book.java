package com.example.demo.book;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Book's representation")
public class Book implements Serializable {
    @Schema(description = "Book's title", example = "Harry Potter and the Sorcerer's Stone", required = true)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
