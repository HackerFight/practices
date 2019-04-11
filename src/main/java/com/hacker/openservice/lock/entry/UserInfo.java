package com.hacker.openservice.lock.entry;

/**
 * Created by hacker on 2019/4/11 0011-下午 10:27
 *
 * @desc
 */
public class UserInfo {

    private Integer id;

    private Integer userId;

    private String userName;

    private String classNo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "UserInfo{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", classNo='" + classNo + '\'' +
                '}';
    }
}
