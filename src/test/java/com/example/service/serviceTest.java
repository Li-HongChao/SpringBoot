package com.example.service;

import com.example.domain.Book;
import com.example.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class serviceTest {
    @Autowired
    private BookServiceImpl book;

}
