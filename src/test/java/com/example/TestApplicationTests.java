package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void getAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void getPage(){
        Page page = new Page(1,3);
        System.out.println(bookDao.selectPage(page, null));
    }

}
