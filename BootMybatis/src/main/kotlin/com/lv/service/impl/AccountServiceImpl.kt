package com.lv.service.impl

import com.lv.mapper.AccountMapper
import com.lv.service.AccountService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Date: 2017-03-23
 * Time: 09:14
 * Description:
 */
@Service
class AccountServiceImpl (val mAccountMapper: AccountMapper): AccountService {

    @Transactional
    override fun transfer(outUser: String, inUser: String, money: Double):Int {
        val updateCount = mAccountMapper.outMovney(outUser, money)
        if(updateCount>0)
            return mAccountMapper.inMovney(inUser, money)
        return 0
    }
}