package com.dp.tratoria.response;

import java.util.List;

public class GeneralListResponse<T> {

    private List<T> value;
    private PageInfo pageInfo;

    public List<T> getValue() {
        return value;
    }

    public void setValue(List<T> value) {
        this.value = value;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
