package org.seckill.service.imp;

import org.seckill.dao.CommandContentMapper;
import org.seckill.entity.CommandContent;
import org.seckill.service.CommandContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Date: 2017-03-30
 * Time: 16:27
 * Description:
 */
@Service
public class CommandContentServiceImpl implements CommandContentService {
    @Resource
    private CommandContentMapper mContentMapper;
    public void insert(CommandContent commandContent) {
        mContentMapper.insert(commandContent);
    }
}
