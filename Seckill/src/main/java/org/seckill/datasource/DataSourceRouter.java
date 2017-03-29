package org.seckill.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 
 * @author zongbo
 * 实现spring多路由配置，由spring调用
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

 // 获取数据源名称
 protected Object determineCurrentLookupKey() {
  return HandleDataSource.getDataSource();
 }

}