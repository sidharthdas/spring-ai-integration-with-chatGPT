package com.springai.controller;

import com.springai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("test-server")
    public String testServer() {
        return "Server is up. . . ";
    }

    @GetMapping("book-details-by-book-name/{bookName}")
    public String getBookDetails(@PathVariable("bookName") String bookName) {
        return bookService.detailRegardingBook(bookName);
    }
}
