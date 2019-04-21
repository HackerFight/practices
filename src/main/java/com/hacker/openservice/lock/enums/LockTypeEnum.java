package com.hacker.openservice.lock.enums;

/**
 * Created by hacker on 2019/4/21 0021-下午 9:07
 *
 * @desc
 */
public enum LockTypeEnum {

    ZDF_LOCK_CONFIG("DYNAMIC_TASK_CONFIG_LOCK", "配置锁"),

    ZDF_LOCK_INSTANCE("DYNAMIC_TASK_INSTANCE_LOCK", "实例锁"),

    ;

    private String lockType;

    private String lockDesc;

    LockTypeEnum(String lockType, String lockDesc){
        this.lockType = lockType;
        this.lockDesc = lockDesc;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

    public String getLockDesc() {
        return lockDesc;
    }

    public void setLockDesc(String lockDesc) {
        this.lockDesc = lockDesc;
    }
}
