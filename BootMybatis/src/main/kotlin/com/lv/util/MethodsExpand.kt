package com.lv.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Date: 2017-03-21
 * Time: 15:51
 * Description:
 */

fun String?.isEmptyStr(): Boolean {
    return this == null || this.isEmpty()
}

fun Any?.getStringLength(): Int {
    if (null != this && "null" != this)
        return this.toString().length
    return 0
}

var Any.logger: Logger
    set(value) {

    }
    get() {
        return LoggerFactory.getLogger(this.javaClass)
    }