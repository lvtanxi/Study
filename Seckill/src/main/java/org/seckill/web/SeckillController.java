package org.seckill.web;


import org.seckill.dto.Export;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Date: 2017-03-17
 * Time: 10:26
 * Description:控制器
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    @Resource
    private SeckillService mSeckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(HttpServletRequest servletRequest,Model model) {
        System.out.println(servletRequest.getHeader("lvtanxi"));
        List<Seckill> seckillList = mSeckillService.getSeckillList();
        model.addAttribute("list", seckillList);
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null)
            return "redirest:/seckill/list";
        Seckill seckill = mSeckillService.getById(seckillId);
        if (seckill == null)
            return "forward:/seckill/list";
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    //ajax接口
    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<Export> export(@PathVariable() long seckillId) {
        SeckillResult<Export> result;
        try {
            Export export = mSeckillService.exportSeckilUrl(seckillId);
            if (export == null)
                result = new SeckillResult<Export>(false, "Export is null");
            else
                result = new SeckillResult<Export>(true, export);
        } catch (Exception e) {
            e.printStackTrace();
            result = new SeckillResult<Export>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") long seckillId, @PathVariable("md5") String md5, @CookieValue(value = "killPhone", required = false) Long userPhone) {
        SeckillResult<SeckillExecution> result;
        try {
            if (userPhone == null)
                return new SeckillResult<SeckillExecution>(false, "未注册");
            SeckillExecution execution = mSeckillService.executeSeckillProcedure(seckillId, userPhone, md5);
            result = new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e1) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            result = new SeckillResult<SeckillExecution>(false, execution);
        } catch (RepeatKillException e2) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            result = new SeckillResult<SeckillExecution>(false, execution);
        } catch (SeckillException e) {
            e.printStackTrace();
            result = new SeckillResult<SeckillExecution>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value ="/time/now",method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time(){
        return new SeckillResult<Long>(true,new Date().getTime());
    }


    @RequestMapping(value ="/test",method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> test(){
        return new SeckillResult<Long>(true,new Date().getTime());
    }


}
