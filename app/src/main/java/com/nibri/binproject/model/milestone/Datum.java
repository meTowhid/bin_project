
package com.nibri.binproject.model.milestone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("deepLinkURL")
    @Expose
    private String deepLinkURL;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("webURL")
    @Expose
    private String webURL;
    @SerializedName("isDeepLink")
    @Expose
    private Boolean isDeepLink;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("image")
    @Expose
    private Image image;

    public String getDeepLinkURL() {
        return deepLinkURL;
    }

    public void setDeepLinkURL(String deepLinkURL) {
        this.deepLinkURL = deepLinkURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
