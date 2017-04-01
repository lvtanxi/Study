package org.seckill.service.imp;

import com.github.pagehelper.PageHelper;

import org.seckill.dao.CommandMapper;
import org.seckill.datasource.DataSource;
import org.seckill.entity.Command;
import org.seckill.service.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        PageHelper.startPage(1,1);
        return mMapper.findAllCommand();
    }

    public int insert(Command command) {
        int insert = mMapper.insert(command);
        System.out.println(command.getId());
        return insert;
    }

    public List<Command> findAllCommandByPage(Map<String, Object> map) {
        return mMapper.findAllCommandByPage(map);
    }
}
