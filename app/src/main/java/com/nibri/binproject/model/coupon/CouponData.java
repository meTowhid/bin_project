package com.nibri.binproject.model.coupon;

import com.google.gson.annotations.SerializedName;

public class CouponData {
    @SerializedName("title")
    private String title;
    @SerializedName("subTitle")
    private String subTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("webURL")
    private String webURL;
    @SerializedName("deepLinkURL")
    private String deepLinkURL;
    @SerializedName("isDeepLink")
    private Boolean isDeepLink;
    @SerializedName("isActive")
    private Boolean isActive;
    @SerializedName("action")
    private String action;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getDeepLinkURL() {
        return deepLinkURL;
    }

    public void setDeepLinkURL(String deepLinkURL) {
        this.deepLinkURL = deepLinkURL;
    }

    public Boolean getIsDeepLink() {
        return isDeepLink;
    }

    public void setIsDeepLink(Boolean isDeepLink) {
        this.isDeepLink = isDeepLink;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}

