
package com.nibri.binproject.model.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("deepLinkURL")
    @Expose
    private String deepLinkURL;
    @SerializedName("isDeepLink")
    @Expose
    private Boolean isDeepLink;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("webURL")
    @Expose
    private String webURL;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("isServiceAvailable")
    @Expose
    private Boolean isServiceAvailable;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("serviceHTTPHeader")
    @Expose
    private String serviceHTTPHeader;
    @SerializedName("isAuthRequired")
    @Expose
    private Boolean isAuthRequired;
    @SerializedName("serviceScope")
    @Expose
    private String serviceScope;
    @SerializedName("serviceURL")
    @Expose
    private String serviceURL;
    @SerializedName("serviceIcon")
    @Expose
    private ServiceIcon serviceIcon;
    @SerializedName("serviceUnavailableIcon")
    @Expose
    private ServiceUnavailableIcon serviceUnavailableIcon;
    @SerializedName("serviceUnavailableMsg")
    @Expose
    private String serviceUnavailableMsg;
    @SerializedName("apiVersions")
    @Expose
    private List<ApiVersion> apiVersions = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("vertical")
    @Expose
    private Vertical vertical;
    @SerializedName("language")
    @Expose
    private Language language;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("coverImage")
    @Expose
    private CoverImage coverImage;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("subTitle")
    @Expose
    private String subTitle;
    @SerializedName("action")
    @Expose
    private Action action;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getIsServiceAvailable() {
        return isServiceAvailable;
    }

    public void setIsServiceAvailable(Boolean isServiceAvailable) {
        this.isServiceAvailable = isServiceAvailable;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceHTTPHeader() {
        return serviceHTTPHeader;
    }

    public void setServiceHTTPHeader(String serviceHTTPHeader) {
        this.serviceHTTPHeader = serviceHTTPHeader;
    }

    public Boolean getIsAuthRequired() {
        return isAuthRequired;
    }

    public void setIsAuthRequired(Boolean isAuthRequired) {
        this.isAuthRequired = isAuthRequired;
    }

    public String getServiceScope() {
        return serviceScope;
    }

    public void setServiceScope(String serviceScope) {
        this.serviceScope = serviceScope;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public ServiceIcon getServiceIcon() {
        return serviceIcon;
    }

    public void setServiceIcon(ServiceIcon serviceIcon) {
        this.serviceIcon = serviceIcon;
    }

    public ServiceUnavailableIcon getServiceUnavailableIcon() {
        return serviceUnavailableIcon;
    }

    public void setServiceUnavailableIcon(ServiceUnavailableIcon serviceUnavailableIcon) {
        this.serviceUnavailableIcon = serviceUnavailableIcon;
    }

    public String getServiceUnavailableMsg() {
        return serviceUnavailableMsg;
    }

    public void setServiceUnavailableMsg(String serviceUnavailableMsg) {
        this.serviceUnavailableMsg = serviceUnavailableMsg;
    }

    public List<ApiVersion> getApiVersions() {
        return apiVersions;
    }

    public void setApiVersions(List<ApiVersion> apiVersions) {
        this.apiVersions = apiVersions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vertical getVertical() {
        return vertical;
    }

    public void setVertical(Vertical vertical) {
        this.vertical = vertical;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "title='" + title + '\'' +
                ", deepLinkURL='" + deepLinkURL + '\'' +
                ", isDeepLink=" + isDeepLink +
                ", isActive=" + isActive +
                ", image=" + image +
                ", webURL='" + webURL + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", isServiceAvailable=" + isServiceAvailable +
                ", serviceType='" + serviceType + '\'' +
                ", serviceHTTPHeader='" + serviceHTTPHeader + '\'' +
                ", isAuthRequired=" + isAuthRequired +
                ", serviceScope='" + serviceScope + '\'' +
                ", serviceURL='" + serviceURL + '\'' +
                ", serviceIcon=" + serviceIcon +
                ", serviceUnavailableIcon=" + serviceUnavailableIcon +
                ", serviceUnavailableMsg='" + serviceUnavailableMsg + '\'' +
                ", apiVersions=" + apiVersions +
                ", id='" + id + '\'' +
                ", vertical=" + vertical +
                ", language=" + language +
                ", description='" + description + '\'' +
                ", coverImage=" + coverImage +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", items=" + items +
                ", subTitle='" + subTitle + '\'' +
                ", action=" + action +
                '}';
    }
}