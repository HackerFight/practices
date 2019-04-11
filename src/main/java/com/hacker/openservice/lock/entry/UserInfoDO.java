package com.hacker.openservice.lock.entry;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:32
 *
 * @desc
 */
public class UserInfoDO {

    private Integer id;

    private String userId;

    private String userName;

    private String classNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return "UserInfoDO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", classNo='" + classNo + '\'' +
                '}';
    }
}
