
package com.nibri.binproject.model.verticals;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

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

}
