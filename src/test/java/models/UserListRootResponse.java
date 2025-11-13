package models;

import java.util.List;

public class UserListRootResponse {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<UserResponse> data;
    private Support support;
    private Meta _meta;

    public UserListRootResponse(Integer page, Integer per_page, Integer total, Integer total_pages, List<UserResponse> data, Support support, Meta meta) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
        this._meta = meta;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public List<UserResponse> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public Meta get_meta() {
        return _meta;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<UserResponse> data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public void set_meta(Meta _meta) {
        this._meta = _meta;
    }
}
