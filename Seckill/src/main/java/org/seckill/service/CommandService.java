package org.seckill.service;

import org.seckill.entity.Command;

import java.util.List;

/**
 * Date: 2017-03-28
 * Time: 18:03
 * Description:
 */
public interface CommandService {

    List<Command> findAllCommand();
}
