package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Command;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

/**
 * Date: 2017-03-28
 * Time: 13:40
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CommandMapperTest {
    @Resource
    private CommandMapper mCommandMapper;
    @Test
    public void findAllCommand() throws Exception {
        List<Command> allCommand = mCommandMapper.findAllCommand();
        if(null!=allCommand) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(allCommand);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

}