package com.hacker.openservice.lock.mapper;

import com.hacker.openservice.lock.entry.ZdfLockDO;

/**
 * Created by hacker on 2019/4/21 0021-下午 9:05
 *
 * @desc
 */
public interface ZdfLockMapper {

    ZdfLockDO getLock(String tyep);
}
