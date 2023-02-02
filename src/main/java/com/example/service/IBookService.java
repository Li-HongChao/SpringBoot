package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 鸿
 * @since 2023-01-14
 */
public interface IBookService extends IService<Book> {
    boolean saveBook (Book book);
    boolean deleteById (Long i);
    boolean upDateBook(Book book);

    Book selectById (Integer i);
    List<Book> selectAll();
    IPage selectPage(Integer current, Integer PageSize, String name, String type, String description);

}
