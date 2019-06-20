package com.bjpowernode.activity.service.impl;

import com.bjpowernode.activity.dao.ActivityDao;
import com.bjpowernode.activity.service.ActivityService;
import com.bjpowernode.utils.SqlSessionUtil;

/**
 * Author:任赵辉
 * 2019/6/20
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
}
