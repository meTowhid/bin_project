
package com.nibri.binproject.model.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomePageLayout {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("shortTitle")
    @Expose
    private String shortTitle;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HomePageLayout{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", meta=" + meta +
                ", shortTitle='" + shortTitle + '\'' +
                ", data=" + data +
                '}';
    }
}
