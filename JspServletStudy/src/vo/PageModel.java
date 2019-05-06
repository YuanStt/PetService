package vo;

import java.util.List;

public class PageModel<E> {

    //结果
    private List<E> list;
    //记录总条数
    private int totalCount;
    //当前页
    private int currPage;
    //页面大小
    private int pageSize;
    //总页面
    private int totalPage;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrPage() {
        if (currPage < 1)
            currPage=1;
        if (currPage > totalPage)
            currPage = totalPage;
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        if (pageSize < 1)
            pageSize=1;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
