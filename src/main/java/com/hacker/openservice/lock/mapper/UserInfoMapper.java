package com.hacker.openservice.lock.mapper;

import com.hacker.openservice.lock.entry.UserInfo;
import com.hacker.openservice.lock.entry.UserInfoDO;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:29
 *
 * @desc
 */
public interface UserInfoMapper {

    /**
     * 获取锁
     * @param userId
     * @return
     */
    UserInfoDO getRowLock(Integer userId);

    /**
     * 更新操作，目的是为了查看是否自动提交
     * @param userInfo
     */
    void updateUser(UserInfo userInfo);
}
