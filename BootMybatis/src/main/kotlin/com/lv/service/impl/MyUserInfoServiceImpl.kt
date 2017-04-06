package com.lv.service.impl

import com.lv.mapper.MyUserInfoMapper
import com.lv.service.MyUserInfoService
import org.springframework.stereotype.Service

@Service
class MyUserInfoServiceImpl(val  myUserInfoMapper: MyUserInfoMapper) : MyUserInfoService {
    override fun findAllMyUserInfo()=myUserInfoMapper.findAllMyUserInfo()
    override fun findAllMyUserInfoMap()=myUserInfoMapper.findAllMyUserInfoMap()
}