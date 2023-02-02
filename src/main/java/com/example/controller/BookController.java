package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.unit.Code;
import com.example.controller.unit.Result;
import com.example.domain.Book;
import com.example.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 鸿
 * @since 2023-01-14
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping
    public Result getAll() {
        List<Book> flag = bookService.selectAll();
        return new Result(flag != null ? Code.FIND_ALL_OK : Code.FIND_ALL_ERR, flag);
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        Book flag = bookService.selectById(id);
        return new Result(flag != null ? Code.FIND_BY_ID_OK : Code.FIND_BY_ID_ERR, flag);
    }

    @PutMapping
    public Result upDate(@RequestBody Book book) {
        boolean flag = bookService.upDateBook(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.saveBook(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Long id) {
        boolean flag = bookService.deleteById(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/{start}/{end}")
    public Result page(@PathVariable Integer end, @PathVariable Integer start,String name ,String type,String description) {
        IPage flag = bookService.selectPage(start, end,name,type,description);
        return new Result(flag != null ? Code.FIND_PAGE_OK : Code.FIND_PAGE_ERR, flag);
    }
}

