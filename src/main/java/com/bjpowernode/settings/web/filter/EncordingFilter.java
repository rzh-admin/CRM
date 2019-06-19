package com.bjpowernode.settings.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:任赵辉
 * 2019/6/19
 */
public class EncordingFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println("字符过滤器")
        ;HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        //response.setCharacterEncoding("text/html:utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }
}
