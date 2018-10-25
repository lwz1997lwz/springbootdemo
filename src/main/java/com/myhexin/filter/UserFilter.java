package com.myhexin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: springbootdemo
 * @description: 用户过滤器
 * @author: Linweizhe
 * @create: 2018-10-25 15:53
 **/
@WebFilter(filterName ="userFilter" ,urlPatterns = "/*")
public class UserFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---------->>> init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---------->>> doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("---------->>> destory");
    }
}
