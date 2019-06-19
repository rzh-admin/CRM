package com.bjpowernode.settings.web.controller;

import com.bjpowernode.settings.donain.User;
import com.bjpowernode.settings.service.UserService;
import com.bjpowernode.settings.service.impl.UserServiceImpl;
import com.bjpowernode.utils.MD5Util;
import com.bjpowernode.utils.PrintJson;
import com.bjpowernode.utils.ServiceFactory;
import com.bjpowernode.utils.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:任赵辉
 * 2019/6/19
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入用户控制器");
        String path = request.getServletPath();
        if("/setting/user/login.do".equals(path)){
             login(request,response);
        }else if ("".equals(path)){

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入登录验证控制器");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        loginPwd= MD5Util.getMD5(loginPwd);
        //Map<String,Object> map = new HashMap<String, Object>();
        String ip = request.getRemoteAddr();
        System.out.println("ip="+ip);
        /*user.setLoginAct(loginAct);
        user.setLoginPwd(loginPwd);*/
        try {
            User user= us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(response, true);
        } catch (Exception e) {
            e.printStackTrace();
           String msg = e.getMessage();
           Map<String,Object> map=new HashMap<String, Object>();
           map.put("msg", msg);
           map.put("success", false);
           PrintJson.printJsonObj(response, map);
        }

    }
}
