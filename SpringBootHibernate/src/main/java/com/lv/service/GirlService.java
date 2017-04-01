package com.lv.service;

import com.lv.datasource.TargetDataSource;
import com.lv.model.Girl;
import com.lv.repository.GirlRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Date: 2016-12-20
 * Time: 18:01
 * Description:
 */
@Service
public class GirlService {
    @Resource
    private GirlRepository mGirlRepository;


    /**
     * 事务管理
     */
    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setAddress("湖南");
        girlA.setName("E");
        girlA.setAge(2);
        mGirlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setAddress("北京");
        girlB.setName("北京");
        girlB.setAge(21);

        mGirlRepository.save(girlB);
    }

    /**
     *
     *使用redis做缓存
     */
    @Cacheable(value = "girlcache2",keyGenerator = "wiselyKeyGeneratorc")
    public List<Girl> findByAge(Integer age){
        System.out.println("无缓存的时候调用这里");
        return mGirlRepository.findByAge(age);
    }
    /**
     * 指定数据源
     *
     */
    @TargetDataSource("ds1")
    public List<Girl> findList(){
        return mGirlRepository.findAll();
    }



}