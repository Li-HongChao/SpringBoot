package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.dao.BookDao;
import com.example.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 鸿
 * @since 2023-01-14
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public boolean deleteById(Long i) {
        return bookDao.deleteById(i)>0;
    }

    @Override
    public boolean upDateBook(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Book selectById(Integer i) {
        return bookDao.selectById(i);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage selectPage(Integer current, Integer PageSize, String name, String type, String description) {
        LambdaQueryWrapper<Book> query = new LambdaQueryWrapper<>();
        query.like(!Strings.isEmpty(name),Book::getName,name);
        query.like(!Strings.isEmpty(type),Book::getType,type);
        query.like(!Strings.isEmpty(description),Book::getDescription,description);
        return bookDao.selectPage(new Page(current,PageSize),query);
    }
}
