package com.bjpowernode.activity.service.impl;

import com.bjpowernode.activity.dao.ActivityRemarkDao;
import com.bjpowernode.activity.service.ActivityRemarkService;
import com.bjpowernode.utils.SqlSessionUtil;

/**
 * Author:任赵辉
 * 2019/6/20
 */
public class ActivityRemarkImpl implements ActivityRemarkService {
    private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
}
