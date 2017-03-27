package com.lv.mapper

import com.lv.model.Command

/**
 * Date: 2017-03-27
 * Time: 11:04
 * Description:
 */
interface CommandMapper {
    fun findAllCommand(): List<Command>
}