package org.seckill.service.imp;

import org.seckill.dao.CommandMapper;
import org.seckill.datasource.DataSource;
import org.seckill.entity.Command;
import org.seckill.service.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * Date: 2017-03-28
 * Time: 18:03
 * Description:
 */
@Service
public class CommandServiceImpl implements CommandService {
    @Resource
    private CommandMapper mMapper;

    @DataSource(DataSource.order)
    public List<Command> findAllCommand() {
        return mMapper.findAllCommand();
    }
}
