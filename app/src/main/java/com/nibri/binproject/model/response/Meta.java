
package com.nibri.binproject.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("item_per_row")
    @Expose
    private String itemPerRow;

    @SerializedName("height_ratio")
    @Expose
    private float heightRatio;

    public String getItemPerRow() {
        return itemPerRow;
    }

    public void setItemPerRow(String itemPerRow) {
        this.itemPerRow = itemPerRow;
    }

    public void setHeightRatio(float heightRatio) {
        this.heightRatio = heightRatio;
    }

    public float getHeightRatio() {
        return heightRatio;
    }
}
