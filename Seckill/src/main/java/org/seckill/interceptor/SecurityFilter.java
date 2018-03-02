package org.seckill.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(filterName="SecurityFilter",urlPatterns="/*")
public class SecurityFilter implements javax.servlet.Filter {
 
    public void destroy() {
        System.out.println("过滤器销毁");
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);
        mutableRequest.putHeader("lvtanxi", "吕檀溪");
        chain.doFilter(mutableRequest, response);
    }
 
    public void init(FilterConfig filterConfig) {
        System.out.println("过滤器初始化");
    }
}