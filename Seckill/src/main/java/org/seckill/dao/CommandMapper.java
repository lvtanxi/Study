package org.seckill.dao;

import org.seckill.entity.Command;

import java.util.List;

public interface CommandMapper {

    List<Command> findAllCommand();

    int insert(Command command);
}