package com.wesmile.base;


public class BasePage {

    /**
     * 分页页码
     */
    private Integer pageNum;

    /**
     * 分页每页条数
     */
    private Integer pageSize;

    /**
     * 参与排序字段
     */
    private String sort;

    /**
     * 排序规则
     */
    private String order;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BaseQueryObj{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
