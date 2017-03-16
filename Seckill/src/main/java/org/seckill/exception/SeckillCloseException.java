package org.seckill.exception;

/**
 * Date: 2017-03-16
 * Time: 15:44
 * Description:秒杀关闭异常（运行期异常）
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException() {
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
