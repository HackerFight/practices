package com.hacker.openservice.lock.service;

import com.hacker.openservice.lock.entry.UserInfo;
import com.hacker.openservice.lock.entry.UserInfoDO;
import com.hacker.openservice.lock.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:40
 *
 * @desc
 */
public class DynamicTaskService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 其实没有必要写这么繁琐，我这么写的目的就是为了让自己熟悉代码，比如返回值等等
     * @return
     */
    public UserInfo serviceRowLock(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1001);
        userInfo.setUserName("lisi");
        userInfo.setClassNo("2012003");
        //看看数据库是否会立即更新?
        userInfoMapper.updateUser(userInfo);

        UserInfoDO userInfoDO = transactionTemplate.execute(new TransactionCallback<UserInfoDO>() {
            @Nullable
            @Override
            public UserInfoDO doInTransaction(TransactionStatus transactionStatus) {

                userInfo.setUserName("lisi007");
                //继续查看立即更新了?
                userInfoMapper.updateUser(userInfo);

                //获取锁
                UserInfoDO rowLock = userInfoMapper.getRowLock(1001);

                System.out.println(rowLock);

                return rowLock;
            }
        });

        System.out.println("当执行到这里的时候数据库锁释放了吗? ");

        return convert(userInfoDO);
    }

    private UserInfo convert(UserInfoDO userInfoDO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDO, userInfo);
        return userInfo;
    }
}
