package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.CommandContentMapper;
import org.seckill.entity.CommandContent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * Date: 2017-04-01
 * Time: 14:07
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CommandContentServiceTest {
    @Resource
    private CommandContentMapper mContentMapper;
    @Test
    public void insertCommandContent() throws Exception {
        List<CommandContent> contents=new ArrayList<CommandContent>();
        for (int i = 1; i < 3; i++) {
            CommandContent commandContent = new CommandContent();
            commandContent.setContent("lianxutianja"+i);
            commandContent.setCommandId(i);
            contents.add(commandContent);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>");
        int i = mContentMapper.insertCommandContent(contents);
        System.out.println(i);
        System.out.println(">>>>>>>>>>>>>>>>>>");
    }

}