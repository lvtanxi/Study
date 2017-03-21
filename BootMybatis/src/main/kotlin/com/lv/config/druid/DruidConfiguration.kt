package com.lv.config.druid

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.support.http.StatViewServlet
import com.alibaba.druid.support.http.WebStatFilter
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.util.*
import javax.sql.DataSource


/**
 * Date: 2017-03-08
 * Time: 10:01
 * Description: Druid 配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
class DruidConfiguration {

    var url: String? = null

    var username: String? = null

    var password: String? = null

    var driverClassName: String? = null

    var initialSize: Int = 0

    var minIdle: Int = 0

    var maxActive: Int = 0

    var maxWait: Int = 0

    var timeBetweenEvictionRunsMillis: Int = 0

    var minEvictableIdleTimeMillis: Int = 0

    var varidationQuery: String? = null

    var testWhileIdle: Boolean = false

    var testOnBorrow: Boolean = false

    var testOnReturn: Boolean = false

    var poolPreparedStatements: Boolean = false

    var maxPoolPreparedStatementPerConnectionSize: Int = 0

    var filters: String? = null

    var connectionProperties: String? = null

    @Bean     //声明其为Bean实例
    @Primary //在同样的DataSource中，首先使用被标注的DataSource
    fun dataSource(): DataSource {
        val datasource = DruidDataSource()

        datasource.url = this.url
        datasource.username = username
        datasource.password = password
        datasource.driverClassName = driverClassName

        //configuration
        datasource.initialSize = initialSize
        datasource.minIdle = minIdle
        datasource.maxActive = maxActive
        datasource.maxWait = maxWait.toLong()
        datasource.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis.toLong()
        datasource.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis.toLong()
        datasource.validationQuery = varidationQuery
        datasource.isTestWhileIdle = testWhileIdle
        datasource.isTestOnBorrow = testOnBorrow
        datasource.isTestOnReturn = testOnReturn
        datasource.isPoolPreparedStatements = poolPreparedStatements
        datasource.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize
        datasource.setFilters(filters)
        datasource.setConnectionProperties(connectionProperties)

        return datasource
    }

    @Bean
    fun druidServlet(): ServletRegistrationBean {
        val servletRegistrationBean = ServletRegistrationBean()
        servletRegistrationBean.setServlet(StatViewServlet())
        servletRegistrationBean.addUrlMappings("/druid/*")
        val initParameters = HashMap<String, String>()
        initParameters.put("loginUsername", "admin")// 用户名
        initParameters.put("loginPassword", "admin")// 密码
        initParameters.put("resetEnable", "false")// 禁用HTML页面上的“Reset All”功能
        initParameters.put("allow", "127.0.0.1") // IP白名单 (没有配置或者为空，则允许所有访问)
        //initParameters.put("deny", "192.168.20.38");// IP黑名单 (存在共同时，deny优先于allow)
        servletRegistrationBean.initParameters = initParameters
        return servletRegistrationBean
    }

    @Bean
    fun filterRegistrationBean(): FilterRegistrationBean {
        val filterRegistrationBean = FilterRegistrationBean()
        filterRegistrationBean.filter = WebStatFilter()
        filterRegistrationBean.addUrlPatterns("/*")
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
        return filterRegistrationBean
    }

}
