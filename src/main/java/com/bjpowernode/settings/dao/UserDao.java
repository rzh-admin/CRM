package com.bjpowernode.settings.dao;

import com.bjpowernode.settings.domain.User;

import java.util.Map;

/**
 * Author:任赵辉
 * 2019/6/19
 */
public interface UserDao {
    User login(Map<String, String> map);
}
