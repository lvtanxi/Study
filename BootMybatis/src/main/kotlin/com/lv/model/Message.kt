package com.lv.model

import com.lv.annotations.Poko

/**
 * Date: 2017-03-23
 * Time: 15:07
 * Description:
 */
@Poko
data class Message(var id:Int,var command:String?,var description:String?,var content:String?)