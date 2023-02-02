package com.example.dao;

import com.example.domain.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 鸿
 * @since 2023-01-14
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
