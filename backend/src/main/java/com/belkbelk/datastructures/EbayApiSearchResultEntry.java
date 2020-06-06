package com.belkbelk.datastructures;

import com.belkbelk.datastructures.resultobjects.*;

import java.util.ArrayList;
import java.util.List;

public class EbayApiSearchResultEntry {

    private String itemId;
    private String title;
    private Image image;
    private Price price;
    private String itemHref;
    private String condition;
    private String conditionId;
    List<Image> thumbnailImages = new ArrayList<>();
    List<ShippingOptions> shippingOptions = new ArrayList<>();
    List<String> buyingOptions = new ArrayList<>();
    private String itemWebUrl;
    ItemLocation itemLocation;
    List<Categories> categories = new ArrayList<>();
    List<Image> additionalImages = new ArrayList<>();
    private boolean adultOnly;
    private String legacyItemId;
    private boolean availableCoupons;
    private Seller seller;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public List<Image> getThumbnailImages() {
        return thumbnailImages;
    }

    public void setThumbnailImages(List<Image> thumbnailImages) {
        this.thumbnailImages = thumbnailImages;
    }

    public List<ShippingOptions> getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(List<ShippingOptions> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

    public List<String> getBuyingOptions() {
        return buyingOptions;
    }

    public void setBuyingOptions(List<String> buyingOptions) {
        this.buyingOptions = buyingOptions;
    }

    public String getItemWebUrl() {
        return itemWebUrl;
    }

    public void setItemWebUrl(String itemWebUrl) {
        this.itemWebUrl = itemWebUrl;
    }

    public ItemLocation getItemLocationObject() {
        return itemLocation;
    }

    public void setItemLocationObject(ItemLocation itemLocation) {
        this.itemLocation = itemLocation;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Image> getAdditionalImages() {
        return additionalImages;
    }

    public void setAdditionalImages(List<Image> additionalImages) {
        this.additionalImages = additionalImages;
    }

    public boolean isAdultOnly() {
        return adultOnly;
    }

    public void setAdultOnly(boolean adultOnly) {
        this.adultOnly = adultOnly;
    }

    public String getLegacyItemId() {
        return legacyItemId;
    }

    public void setLegacyItemId(String legacyItemId) {
        this.legacyItemId = legacyItemId;
    }

    public boolean isAvailableCoupons() {
        return availableCoupons;
    }

    public void setAvailableCoupons(boolean availableCoupons) {
        this.availableCoupons = availableCoupons;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getItemHref() {
        return itemHref;
    }

    public void setItemHref(String itemHref) {
        this.itemHref = itemHref;
    }

}
