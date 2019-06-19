package com.bjpowernode.settings.service;

import com.bjpowernode.exception.LoginException;
import com.bjpowernode.settings.donain.User;

import java.util.Map;

/**
 * Author:任赵辉
 * 2019/6/19
 */
public interface UserService {

    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
