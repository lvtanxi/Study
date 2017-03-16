package org.seckill.dto;

import org.seckill.entity.SuccesKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * Date: 2017-03-16
 * Time: 15:41
 * Description:封装秒杀执行后结果
 */
public class SeckillExecution {
    private long seckillId;
    private int state;
    private String stateInfo;

    private SuccesKilled mSuccesKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccesKilled succesKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        mSuccesKilled = succesKilled;
    }

    public SeckillExecution(long seckillId,SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccesKilled getSuccesKilled() {
        return mSuccesKilled;
    }

    public void setSuccesKilled(SuccesKilled succesKilled) {
        mSuccesKilled = succesKilled;
    }
}
