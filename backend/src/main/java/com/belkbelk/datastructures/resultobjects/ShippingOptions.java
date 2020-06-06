package com.belkbelk.datastructures.resultobjects;

public class ShippingOptions {

    private String shippingCostType;
    private Price shippingCost;

    public String getShippingCostType() {
        return shippingCostType;
    }

    public void setShippingCostType(String shippingCostType) {
        this.shippingCostType = shippingCostType;
    }

    public Price getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Price shippingCost) {
        this.shippingCost = shippingCost;
    }
}
