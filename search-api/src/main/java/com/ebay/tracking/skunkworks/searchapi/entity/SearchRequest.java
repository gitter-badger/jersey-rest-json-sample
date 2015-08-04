
package com.ebay.tracking.skunkworks.searchapi.entity;

public class SearchRequest {

    private String keywords;
    private SearchDimension[] dimensions;

    public SearchRequest(){}

    public SearchDimension[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(SearchDimension[] dimensions) {
        this.dimensions = dimensions;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
