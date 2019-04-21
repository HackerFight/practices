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

    /**
     * 这个是模拟我遇到的实际业务场景
     * 从一个配置表读取一些数据 然后写到 另一个表中
     * 这时候就需要用到锁， 而且他是单独有一个锁表，原因是因为他是从 配置表中按照id排序（或者其他列）
     * 然后 limit 1, 所以无法使用 索引列而直接实现行锁，故单独创建了一个锁表
     */
    void businessLock();
}
