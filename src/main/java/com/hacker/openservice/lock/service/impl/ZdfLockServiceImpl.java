package com.hacker.openservice.lock.service.impl;

import com.hacker.openservice.lock.entry.ZdfLockDO;
import com.hacker.openservice.lock.enums.LockTypeEnum;
import com.hacker.openservice.lock.mapper.ZdfLockMapper;
import com.hacker.openservice.lock.service.ZdfLockService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hacker on 2019/4/21 0021-下午 9:05
 *
 * @desc
 */
public class ZdfLockServiceImpl implements ZdfLockService {

    @Autowired
    private ZdfLockMapper zdfLockMapper;

    @Override
    public boolean getConfigLock() {
        return zdfLockMapper.getLock(LockTypeEnum.ZDF_LOCK_CONFIG.getLockType()) != null;
    }

    @Override
    public boolean getInstanceLock() {
        return zdfLockMapper.getLock(LockTypeEnum.ZDF_LOCK_INSTANCE.getLockType()) != null;
    }
}
