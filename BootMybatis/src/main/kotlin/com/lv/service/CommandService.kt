package com.lv.service

import com.lv.model.Command

/**
 * Date: 2017-03-27
 * Time: 11:09
 * Description:
 */
interface CommandService {
    fun findAllCommand(): List<Command>
}