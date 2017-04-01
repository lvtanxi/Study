package org.seckill.service;

import org.seckill.entity.CommandContent;

import java.util.List;

/**
 * Date: 2017-03-30
 * Time: 16:27
 * Description:
 */
public interface CommandContentService {
    void insert(CommandContent commandContent);

    int insertCommandContent(List<CommandContent> commandContents);
}
