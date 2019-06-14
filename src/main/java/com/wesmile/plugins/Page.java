package com.wesmile.plugins;

import java.io.Serializable;

public final class Page implements Serializable {

    /**
     * 序列化标志
     */
    private static final long serialVersionUID = 1L;

    /**
     * 每页显示记录数
     */
    private Integer pageSize = null;

    /**
     * 分页查询开始记录位置
     */
    private int pageNum = 0;

    public Page() {
    }

    /**
     * 设置页数，自动计算数据范围.
     */
    public Page(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


}