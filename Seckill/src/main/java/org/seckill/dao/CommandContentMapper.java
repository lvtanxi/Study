package org.seckill.dao;

import org.seckill.entity.CommandContent;

import java.util.List;

public interface CommandContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommandContent record);

    int insertSelective(CommandContent record);

    CommandContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommandContent record);

    int updateByPrimaryKey(CommandContent record);

    int insertCommandContent(List<CommandContent> commandContents);
}