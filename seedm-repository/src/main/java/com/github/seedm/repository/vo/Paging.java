package com.github.seedm.repository.vo;

import com.github.pagehelper.PageInfo;

/**
 * 分页参数实体
 */
public class Paging {

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页显示数据条数
     */
    private int pageSize;

    /**
     * 分页属性
     */
    private PageInfo pageInfo;

    /**
     * 构造方法
     * @param pageNum 页码
     * @param pageSize 每页显示数据条数
     */
    public Paging(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
