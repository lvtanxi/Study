package com.lv.service.impl

import com.lv.mapper.TsCenterMapper
import com.lv.model.TsCenter
import com.lv.service.TsCenterService
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class TsCenterServiceImpl(val mTsCenterMapper: TsCenterMapper) : TsCenterService {
    override fun findAllMessage():List<TsCenter>{
        val hashMap = HashMap<String, Any>()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        hashMap.put("date",dateFormat.parse("2017-04-05 16:24:49"))
        return mTsCenterMapper.findAllMessage(hashMap)
    }
}