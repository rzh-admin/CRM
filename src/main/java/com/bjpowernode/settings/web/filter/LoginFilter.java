package com.bjpowernode.settings.web.filter;

import com.bjpowernode.settings.donain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:任赵辉
 * 2019/6/19
 */
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入登录过滤器");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path =request.getServletPath();
        if ("/setting/user/login.do".equals(path)||"/login.jsp".equals(path)){
            chain.doFilter(req, resp);
        }else {
            User user = (User) request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);
            }else {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }
}
