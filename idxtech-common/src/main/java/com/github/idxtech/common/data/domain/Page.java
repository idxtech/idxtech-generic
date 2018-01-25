package com.github.idxtech.common.data.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Page<E> implements Serializable {

    private static final long serialVersionUID = -5786309292840258593L;

    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页个数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 页数
     */
    private int pageCount;
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 数据列表
     */
    private List<E> list;

    public Page() {
    }

    public Page(int totalCount, int pageSize, int pageNum, List<E> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageCount = totalCount / pageSize + totalCount % pageSize == 0 ? 0 : 1;
        this.pageNum = pageNum;
        this.list = list;
    }

    public Page(int pageNum, int pageSize, List<E> list) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalCount = -1;
        this.pageCount = 1;
        this.list = list;
    }

    public static <T> Page<T> of(List<T> list, int pageNum, int pageSize) {
        if (list == null || list.isEmpty()) {
            return new Page<>(0, pageSize, pageNum, new ArrayList<>());
        } else {
            List<T> subList = list.stream().skip(pageSize * (pageNum - 1)).limit(pageSize).collect(Collectors.toList());
            return new Page<>(list.size(), pageSize, pageNum, subList);
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageNum=" + pageNum +
                ", list=" + list +
                '}';
    }
}