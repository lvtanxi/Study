package org.seckill.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.seckill.dto.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * Date: 2017-04-01
 * Time: 10:16
 * Description: 分页拦截器
 * type 指定拦截的对象
 * method 指定拦截的方法
 * args 指定拦截的参数
 */

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String id = mappedStatement.getId();//获取执行Sql的ID
        if (id.matches(".+ByPage$")) {
            BoundSql boundSql = statementHandler.getBoundSql();
            //获取参数
            Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
            Page page = (Page) parameter.get("page");
            //原始Sql
            String sql = boundSql.getSql();
            //查询总条数的sql语句
            String countSql = "SELECT count(1) FROM (" + sql + ")a";
            //获取数据库连接对象
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = connection.prepareStatement(countSql);
            ParameterHandler handler= (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            handler.setParameters(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                page.setTotalNumber(resultSet.getInt(1));
            // 改造后的sql
            String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumer();
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        System.out.println(">>>>>plugin");
        return Plugin.wrap(target, this);//判断是否需要分页
    }

    public void setProperties(Properties properties) {
        System.out.println(">>>>>setProperties");
    }
}
