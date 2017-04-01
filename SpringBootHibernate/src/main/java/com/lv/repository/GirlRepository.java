package com.lv.repository;

import com.lv.model.Girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Date: 2016-12-20
 * Time: 17:32
 * Description:
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    List<Girl> findByAge(Integer age);
}
