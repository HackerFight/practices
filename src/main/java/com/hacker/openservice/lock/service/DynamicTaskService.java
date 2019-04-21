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
        /**
         *   看看数据库是否会立即更新?
         *   答案：肯定会啊，这里没有事务，自动提交会立即提交的
         */

        userInfoMapper.updateUser(userInfo);

        UserInfoDO userInfoDO = transactionTemplate.execute(new TransactionCallback<UserInfoDO>() {
            @Nullable
            @Override
            public UserInfoDO doInTransaction(TransactionStatus transactionStatus) {

                /**
                 * 继续查看立即更新了?
                 *    userInfo.setUserName("lisi007");
                 *    userInfoMapper.updateUser(userInfo);
                 *  不会更新的，因为这个update 是在 事务中，所以不会理解提交的，注意，此时
                 *  去数据库中更新此行，或者 for update 此行，都会阻塞，这就是事务的原子性
                 *  其他事务无法更新
                 */


                //获取锁
                UserInfoDO rowLock = userInfoMapper.getRowLock(1001);

                /**
                 * 执行到这里还有锁吗?
                 *  答案：有的，此时执行了 for update , 由于id是主键，所以此时发生了行锁
                 *        其他事务（线程）无法再去 update 或者 for update 了
                 */
                System.out.println(rowLock);

                return rowLock;
            }
        });

        System.out.println("当执行到这里的时候数据库锁释放了吗?  释放了，因为此时已经推出了 execute　方法了!!!!");

        return convert(userInfoDO);
    }

    private UserInfo convert(UserInfoDO userInfoDO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDO, userInfo);
        return userInfo;
    }
}
