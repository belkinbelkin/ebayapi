package com.belkbelk.datastructures;

import java.util.List;

public class EbayApiSearchResult {

    private String href;
    private Integer total;
    private String next;
    private Integer limit;
    private String offset;
    private List<EbayApiSearchResultEntry> itemSummaries;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public List<EbayApiSearchResultEntry> getItemSummaries() {
        return itemSummaries;
    }

    public void setItemSummaries(List<EbayApiSearchResultEntry> itemSummaries) {
        this.itemSummaries = itemSummaries;
    }
}
