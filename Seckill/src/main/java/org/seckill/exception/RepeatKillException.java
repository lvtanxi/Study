package org.seckill.exception;

/**
 * Date: 2017-03-16
 * Time: 15:44
 * Description:重复秒杀异常（运行期异常）
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException() {
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
