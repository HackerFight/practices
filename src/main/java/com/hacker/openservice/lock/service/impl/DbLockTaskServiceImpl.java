package com.hacker.openservice.lock.service.impl;

import com.hacker.openservice.lock.entry.UserInfo;
import com.hacker.openservice.lock.entry.UserInfoDO;
import com.hacker.openservice.lock.mapper.UserInfoMapper;
import com.hacker.openservice.lock.service.DbLockTaskService;
import com.hacker.openservice.lock.service.DynamicTaskService;
import com.hacker.openservice.lock.service.ZdfLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:39
 *
 * @desc
 */
public class DbLockTaskServiceImpl implements DbLockTaskService {

    @Autowired
    private DynamicTaskService dynamicTaskService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ZdfLockService zdfLockService;

    @Override
    public void rowLock() {
        /**
         *  这是第一个语句，其实没必要这么复杂，直接可以线程 表锁那样，但是我这么写的目的
         *  是想说 代码 的多变性!
         */
        UserInfo userInfo = dynamicTaskService.serviceRowLock();

        /**
         * 执行到这里，还有锁吗？
         *  答：没有了，这里根本就没有锁了，在上面语句的内部执行完了 ，推出 execute 方法后就没有锁了
         */
        System.out.println(userInfo);

        return;
    }

    @Override
    public void tableLock() {
         transactionTemplate.execute(new TransactionCallbackWithoutResult() {
             @Override
             protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                 try{

                     UserInfoDO zhangsan = userInfoMapper.getTableRow("zhangsan");

                     /**
                      * 执行到这里，发现更新表中的任何一行数据都是阻塞的，
                      * 这就是表锁
                      */
                     System.out.println(zhangsan);

                 }catch (Exception e){
                     e.printStackTrace();
                     //这个千万不要忘了
                     transactionStatus.setRollbackOnly();
                 }

             }
         });
    }

    @Override
    public void businessLock() {

         transactionTemplate.execute(new TransactionCallbackWithoutResult() {
             @Override
             protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                 boolean configLock = zdfLockService.getConfigLock();
                 if (!configLock){
                     /**)
                      * 如果锁获取失败，那么就直接退出
                      */
                     return;

                     //从配置中查询数据
                    // zdfConfigService.getConfigData();

                     //将查询到的数据做一些调整，然后更新到实例表中
                     //zdfInstanceService.update();

                     /**
                      * 这样就保证了你从查询出来，到更新，这个过程不会发生错误（多线程环境）
                      */
                 }
             }
         });
    }
}
