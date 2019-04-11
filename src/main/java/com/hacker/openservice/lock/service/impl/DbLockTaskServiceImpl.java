package com.hacker.openservice.lock.service.impl;

import com.hacker.openservice.lock.entry.UserInfo;
import com.hacker.openservice.lock.service.DbLockTaskService;
import com.hacker.openservice.lock.service.DynamicTaskService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:39
 *
 * @desc
 */
public class DbLockTaskServiceImpl implements DbLockTaskService {

    @Autowired
    private DynamicTaskService dynamicTaskService;

    @Override
    public void rowLock() {
        UserInfo userInfo = dynamicTaskService.serviceRowLock();

        System.out.println(userInfo);

        return;
    }

    @Override
    public void tableLock() {

    }
}
