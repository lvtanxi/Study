package com.lv.service.impl

import com.lv.service.AccountService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * Date: 2017-03-23
 * Time: 09:48
 * Description:
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class AccountServiceImplTest {
    @Autowired
    private val mAccountService: AccountService? = null

    @Test
    fun transfer() {
        mAccountService?.transfer("aaa","bbb",200.0)
    }

}