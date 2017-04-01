package org.seckill.dao;

import org.seckill.entity.Command;

import java.util.List;
import java.util.Map;

public interface CommandMapper {

    List<Command> findAllCommand();

    List<Command>  findAllCommandByPage(Map<String,Object> map);

    int insert(Command command);
}