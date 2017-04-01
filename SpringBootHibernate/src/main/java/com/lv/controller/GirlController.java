package com.lv.controller;

import com.lv.model.Girl;
import com.lv.repository.GirlRepository;
import com.lv.service.GirlService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Date: 2016-12-20
 * Time: 17:30
 * Description:
 */
@RestController
public class GirlController {
    @Resource
    private GirlRepository mGirlRepository;
    @Resource
    private GirlService mService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "grils")
    public List<Girl> grilList() {

        logger.info("你妹");
        logger.error("你妹");
        return mGirlRepository.findAll();
    }

    @GetMapping(value = "grils/age")
    public List<Girl> grilList(@RequestParam("age") int age) {
        return mService.findByAge(age);
    }

    @GetMapping(value = "grils/datasource")
    public List<Girl> datasource() {
        return mService.findList();
    }

    @PostMapping(value = "gril")
    public Girl grilAdd(@RequestParam("address") String address,
                        @RequestParam("name") String name) {
        Girl girl = new Girl();
        girl.setAddress(address);
        girl.setName(name);
        girl.setAge(20);
        return mGirlRepository.save(girl);
    }

    @GetMapping(value = "gril/{id}")
    public Girl grilOne(@PathVariable(value = "id") Integer id) {
        return mGirlRepository.findOne(id);
    }

    @PutMapping(value = "gril/{id}")
    public Girl grilUpdate(@PathVariable(value = "id") Integer id, @RequestParam("address") String address) {
        Girl one = mGirlRepository.findOne(id);
        one.setAddress(address);
        return mGirlRepository.save(one);
    }

    @DeleteMapping(value = "gril/{id}")
    public void grilDelete(@PathVariable(value = "id") Integer id) {
        mGirlRepository.delete(id);
    }

    @PostMapping(value = "gril/two")
    public void grilTow() {
        mService.insertTwo();
    }

    @PostMapping(value = "gril/map")
    public void testMap(@RequestBody Map<String, Object> map) {
        if (null != map)
            logger.info("this is map val" + map.toString());
        else
            logger.info("map is null");
    }


}