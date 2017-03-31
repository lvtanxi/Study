package org.seckill.dto;

/**
 * Date: 2017-03-31
 * Time: 10:45
 * Description:分页对象
 */
public class Page {
    /**
     * 总条数
     */
    private int totalNumber;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 每页条数
     */
    private int pageSize = 1;
    /**
     * 数据库中limit的参数，从第几条开始取
     */
    private int dbIndex;

    /**
     * 数据库中limit的参数，一共取多少条
     */
    private int dbNumer;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        this.count();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumer() {
        return dbNumer;
    }

    public void setDbNumer(int dbNumer) {
        this.dbNumer = dbNumer;
    }

    public void count() {
        //计算总页数
        int totalPageTemp = this.totalNumber / this.pageSize;
        int plus = (this.totalNumber % this.pageSize == 0) ? 0 : 1;
        totalPageTemp += plus;
        if (totalPageTemp <= 0)
            totalPageTemp = 1;
        this.totalPage = totalPageTemp;

        //设置当前页数
        //总页数小雨当前页，应将当前页数设置为总页数
        if (this.totalPage < this.currentPage)
            this.currentPage = this.totalPage;
        //当前页小雨1，设置为1
        if (this.currentPage < 1)
            this.currentPage = 1;
        //计算limit的参数
        this.dbIndex = (this.currentPage - 1) * this.pageSize;
        this.dbNumer = this.pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
