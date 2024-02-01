package com.springai.service.impl;

import com.springai.service.BookService;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private AiClient aiClient;
    @Override
    public String detailRegardingBook(String bookName) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Please give details of this book {bookName} in a json format that consist of author
                date of release
                """);

        promptTemplate.add("bookName", bookName);
        return aiClient.generate(promptTemplate.create()).getGeneration().getText();
    }
}
