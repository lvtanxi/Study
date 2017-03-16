package org.seckill.exception;

/**
 * Date: 2017-03-16
 * Time: 15:44
 * Description:秒杀相关异常（运行期异常）
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException() {
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
