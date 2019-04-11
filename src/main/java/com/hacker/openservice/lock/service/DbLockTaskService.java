package com.hacker.openservice.lock.service;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:35
 *
 * 测试的时候可以使用mysql的如下语句查看事务和锁的情况：
 *
 * SELECT * from information_schema.innodb_trx;
 * SELECT * FROM information_schema.innodb_locks;
 *
 */
public interface DbLockTaskService {

    /**
     * 行级锁-只有INNODB 才支持，他的原理是索引，所以 for update 的时候如果是索引列那么他就是行锁，
     * 如果不是索引列 那么他就是 表锁
     */
    void rowLock();

    /**
     * 表锁-使用　for update 的时候如果不是索引列 那么他就走表级锁
     */
    void tableLock();
}
