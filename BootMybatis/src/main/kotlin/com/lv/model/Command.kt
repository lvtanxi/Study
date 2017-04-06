package com.lv.model

import com.lv.annotations.Poko

/**
 * Date: 2017-03-27
 * Time: 11:01
 * Description:
 */
@Poko
data class Command (var id:Int?,var name:String?,var description:String?,var contentList:List<CommandContent>?)