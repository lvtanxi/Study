package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.CommandMapper;
import org.seckill.entity.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Date: 2017-03-28
 * Time: 18:07
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CommandServiceTest {
    @Autowired
    private CommandMapper mMapper;
    @Test
    public void findAllCommand() throws Exception {
        List<Command> allCommand = mMapper.findAllCommand();
        if(null!=allCommand) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(allCommand);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

}