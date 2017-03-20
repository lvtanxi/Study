-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
CREATE TABLE seckill(
  `seckill_id` BIGINT NOT NUll AUTO_INCREMENT COMMENT '商品库存ID',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `start_time` TIMESTAMP   COMMENT '秒杀开始时间',
  `end_time`   TIMESTAMP    COMMENT '秒杀结束时间',
  PRIMARY KEY (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';




-- 初始化数据
INSERT into seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone6',100,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
  ('800元秒杀ipad',200,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
  ('6600元秒杀mac book pro',300,'2016-01-01 00:00:00','2016-01-02 00:00:00'),
  ('7000元秒杀iMac',400,'2016-01-01 00:00:00','2016-01-02 00:00:00');


SELECT * FROM seckill;

-- 秒杀成功明细表
-- 用户登录认证相关信息(简化为手机号)




CREATE TABLE success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品ID',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
  KEY idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';



  -- SHOW CREATE TABLE seckill;#显示表的创建信息

-- 秒杀执行存储过程
-- 1：存储过程优化：事务行级锁持有时间
-- 2：不要过度依赖存储过程
-- 3：简单的逻辑可以应用存储过程
-- 4：注意DELIMITER的使用，不然会失败

DELIMITER $$
CREATE PROCEDURE excuteSeckill(IN fadeSeckillId BIGINT,IN fadeUserPhone BIGINT,IN fadeKillTime TIMESTAMP ,OUT fadeResult INT)
	BEGIN
		DECLARE insert_count INT DEFAULT 0;
		START TRANSACTION ;
		INSERT ignore success_killed VALUES(fadeSeckillId,fadeUserPhone,0,fadeKillTime);  -- 先插入购买明细
		SELECT ROW_COUNT() INTO insert_count;
		IF(insert_count = 0) THEN
			ROLLBACK ;
			SET fadeResult = -1;   -- 重复秒杀
		ELSEIF(insert_count < 0) THEN
			ROLLBACK ;
			SET fadeResult = -2;   -- 内部错误
		ELSE   -- 已经插入购买明细，接下来要减少库存
			UPDATE seckill SET number = number -1 WHERE seckill_id = fadeSeckillId AND start_time < fadeKillTime AND end_time > fadeKillTime AND number > 0;
			SELECT ROW_COUNT() INTO insert_count;
			IF (insert_count = 0)  THEN
				ROLLBACK ;
				SET fadeResult = 0;   -- 库存没有了，代表秒杀已经关闭
			ELSEIF (insert_count < 0) THEN
				ROLLBACK ;
				SET fadeResult = -2;   -- 内部错误
			ELSE
				COMMIT ;    -- 秒杀成功，事务提交
				SET  fadeResult = 1;   -- 秒杀成功返回值为1
			END IF;
		END IF;
	END
$$

DELIMITER ;

SET @fadeResult = -3;
CALL excuteSeckill(1001,13813813822,NOW(),@fadeResult);
SELECT @fadeResult;
