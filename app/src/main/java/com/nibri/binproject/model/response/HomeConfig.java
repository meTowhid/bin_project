
package com.nibri.binproject.model.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeConfig {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("homePageLayout")
    @Expose
    private List<HomePageLayout> homePageLayout = null;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<HomePageLayout> getHomePageLayout() {
        return homePageLayout;
    }

    public void setHomePageLayout(List<HomePageLayout> homePageLayout) {
        this.homePageLayout = homePageLayout;
    }


    @Override
    public String toString() {
        return "HomeConfig{" +
                "version='" + version + '\'' +
                ", homePageLayout=" + homePageLayout +
                '}';
    }
}
