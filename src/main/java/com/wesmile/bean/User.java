package com.wesmile.bean;

import java.util.Date;

/**
 * auto generate
 * @date 2019-06-12 14:35:22
 *
 * @author generator
 */
public class User {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户唯一code
     */
    private Long userCode;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像地址
     */
    private String headPicture;

    /**
     * 状态 0女 1男
     */
    private Byte gender;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 状态 0停用 1启用 -1拉黑
     */
    private Byte userState;

    /**
     * 最后登陆ip
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 用户id
     * @return id 用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户id
     * @param id 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户唯一code
     * @return user_code 用户唯一code
     */
    public Long getUserCode() {
        return userCode;
    }

    /**
     * 用户唯一code
     * @param userCode 用户唯一code
     */
    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    /**
     * 登录名
     * @return login_name 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 手机号
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 头像地址
     * @return head_picture 头像地址
     */
    public String getHeadPicture() {
        return headPicture;
    }

    /**
     * 头像地址
     * @param headPicture 头像地址
     */
    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture == null ? null : headPicture.trim();
    }

    /**
     * 状态 0女 1男
     * @return gender 状态 0女 1男
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 状态 0女 1男
     * @param gender 状态 0女 1男
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 真实姓名
     * @return real_name 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 身份证号
     * @return id_card 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 出生日期
     * @return birthday 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 状态 0停用 1启用 -1拉黑
     * @return user_state 状态 0停用 1启用 -1拉黑
     */
    public Byte getUserState() {
        return userState;
    }

    /**
     * 状态 0停用 1启用 -1拉黑
     * @param userState 状态 0停用 1启用 -1拉黑
     */
    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    /**
     * 最后登陆ip
     * @return last_login_ip 最后登陆ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后登陆ip
     * @param lastLoginIp 最后登陆ip
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * 最后登陆时间
     * @return last_login_time 最后登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登陆时间
     * @param lastLoginTime 最后登陆时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}