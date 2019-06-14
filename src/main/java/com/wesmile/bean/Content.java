package com.wesmile.bean;

import java.util.Date;

/**
 * auto generate
 * @date 2019-06-12 14:35:09
 *
 * @author generator
 */
public class Content {
    /**
     * 
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 拉取时间
     */
    private Date fetchTime;

    /**
     * 图片路径
     */
    private Integer fileId;

    /**
     * 标签
     */
    private String tag;

    /**
     * 排序
     */
    private String sort;

    /**
     * 来源
     */
    private String source;

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
     * 0 默认文本 1 图片 2视频
     */
    private Integer type;

    /**
     * 内容
     */
    private String content;

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
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 拉取时间
     * @return fetchTime 拉取时间
     */
    public Date getFetchTime() {
        return fetchTime;
    }

    /**
     * 拉取时间
     * @param fetchTime 拉取时间
     */
    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    /**
     * 图片路径
     * @return file_id 图片路径
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 图片路径
     * @param fileId 图片路径
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * 标签
     * @return tag 标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 标签
     * @param tag 标签
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * 排序
     * @return sort 排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 来源
     * @return source 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 来源
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
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
     * 0 默认文本 1 图片 2视频
     * @return type 0 默认文本 1 图片 2视频
     */
    public Integer getType() {
        return type;
    }

    /**
     * 0 默认文本 1 图片 2视频
     * @param type 0 默认文本 1 图片 2视频
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}