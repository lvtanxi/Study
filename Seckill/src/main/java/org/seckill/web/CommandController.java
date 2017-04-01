package org.seckill.web;

import org.seckill.dto.Page;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Command;
import org.seckill.service.CommandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Date: 2017-03-29
 * Time: 10:13
 * Description:
 */
@Controller
@RequestMapping("/command")
public class CommandController {
    @Resource
    private CommandService mCommandService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<List<Command>> list() {
        List<Command> commands = mCommandService.findAllCommand();
        return new SeckillResult<List<Command>>(true,commands);
    }
    @RequestMapping(value = "/listByPage", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<List<Command>> listByPage() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("page",new Page());
        List<Command> commands = mCommandService.findAllCommandByPage(map);
        return new SeckillResult<List<Command>>(true,commands);
    }
}
