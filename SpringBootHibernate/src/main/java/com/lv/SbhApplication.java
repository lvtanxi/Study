package com.lv;

import com.lv.datasource.DynamicDataSourceRegister;
import com.lv.filter.HTTPBasicAuthorizeAttribute;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Queue;

@SpringBootApplication
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
public class SbhApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbhApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		System.out.println(">>>asdfasdf>>>>>>");
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HTTPBasicAuthorizeAttribute httpBasicFilter = new HTTPBasicAuthorizeAttribute();
		registrationBean.setFilter(httpBasicFilter);
		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/user/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

	/**
	 * 消息队列
	 */
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
}



