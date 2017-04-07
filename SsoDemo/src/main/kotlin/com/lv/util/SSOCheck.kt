package com.lv.util

import javax.servlet.http.HttpServletRequest

/**
 * Date: 2017-04-07
 * Time: 11:26
 * Description:
 */
object SSOCheck {
    private val USERNAME = "user"
    private val PASSWORD = "123"

    fun checkLogin(userName: String?, password: String?): Boolean {
        return USERNAME == userName && PASSWORD == password
    }

    fun checkKookie(request: HttpServletRequest): Boolean {
        request.cookies.forEach {
            if (it.name == "ssocookie" && it.value == "ss0")
                return true
        }
        return false
    }

}