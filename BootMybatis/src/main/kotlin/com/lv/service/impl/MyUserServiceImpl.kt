package com.lv.service.impl

import com.lv.enums.ResultEnum
import com.lv.exception.ErrorException
import com.lv.mapper.MyUserMapper
import com.lv.service.MyUserService
import com.lv.util.getStringLength
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Date: 2017-03-21
 * Time: 10:53
 * Description:
 */
@Service
class MyUserServiceImpl(val myUserMapper: MyUserMapper) : MyUserService {

    override fun verifyUser(mParam: Map<String, Any>) {
        val userPassWorldLength = mParam["userPassWorld"].getStringLength()
        if (userPassWorldLength == 0)
            throw ErrorException(ResultEnum.EMPTY)
        else if (userPassWorldLength < 6)
            throw ErrorException(ResultEnum.SHORT)
        else
            print("成")
        //方法扩展
    }


    @Transactional
    override fun addUser(mParam: Map<String, Any>) = myUserMapper.addUser(mParam)

    override fun findAllUser() = myUserMapper.findAllUser()
}