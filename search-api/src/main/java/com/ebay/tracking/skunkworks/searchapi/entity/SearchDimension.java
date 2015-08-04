package com.ebay.tracking.skunkworks.searchapi.entity;

/**
 * @author chrysan
 */
public class SearchDimension {
    private String name;
    private int value;
    private String order;

    public SearchDimension() {}

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
