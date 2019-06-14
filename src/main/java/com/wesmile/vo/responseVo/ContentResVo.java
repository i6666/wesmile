package com.wesmile.vo.responseVo;

import com.wesmile.bean.Content;

import java.util.List;

/**
 * Created by zma on 2019/06/12
 */
public class ContentResVo{

    private List fileList;

    /**
     * 标题
     */
    private String title;
    /**
     * 0 默认文本 1 图片 2视频
     */
    private Integer type;

    /**
     * 内容
     */
    private String content;


    /**
     * 标签
     */
    private String tag;

    /**
     * 排序
     */
    private String sort;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List getFileList() {
        return fileList;
    }

    public void setFileList(List fileList) {
        this.fileList = fileList;
    }



}
