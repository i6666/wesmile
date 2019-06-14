package com.wesmile.bean;

import java.util.Date;

/**
 * auto generate
 * @date 2019-06-12 14:35:39
 *
 * @author generator
 */
public class File {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer contentId;

    /**
     * 图片路径
     */
    private String picUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTimes;

    /**
     * 记录状态（可用AVAILABLE删除DELETE禁用FORBID）
     */
    private String state;

    /**
     * 版本号
     */
    private Long versions;

    /**
     * 1 图片 2视频
     */
    private Integer type;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return content_id 
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * 
     * @param contentId 
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 图片路径
     * @return pic_url 图片路径
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 图片路径
     * @param picUrl 图片路径
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建时间
     * @return createTime 创建时间
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
     * 更新时间
     * @return updateTimes 更新时间
     */
    public Date getUpdateTimes() {
        return updateTimes;
    }

    /**
     * 更新时间
     * @param updateTimes 更新时间
     */
    public void setUpdateTimes(Date updateTimes) {
        this.updateTimes = updateTimes;
    }

    /**
     * 记录状态（可用AVAILABLE删除DELETE禁用FORBID）
     * @return state 记录状态（可用AVAILABLE删除DELETE禁用FORBID）
     */
    public String getState() {
        return state;
    }

    /**
     * 记录状态（可用AVAILABLE删除DELETE禁用FORBID）
     * @param state 记录状态（可用AVAILABLE删除DELETE禁用FORBID）
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 版本号
     * @return versions 版本号
     */
    public Long getVersions() {
        return versions;
    }

    /**
     * 版本号
     * @param versions 版本号
     */
    public void setVersions(Long versions) {
        this.versions = versions;
    }

    /**
     * 1 图片 2视频
     * @return type 1 图片 2视频
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1 图片 2视频
     * @param type 1 图片 2视频
     */
    public void setType(Integer type) {
        this.type = type;
    }
}