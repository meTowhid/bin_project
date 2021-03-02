
package com.nibri.binproject.model.verticals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("item_per_row")
    @Expose
    private Integer itemPerRow;
    @SerializedName("min_row")
    @Expose
    private Integer minRow;

    public Integer getItemPerRow() {
        return itemPerRow;
    }

    public void setItemPerRow(Integer itemPerRow) {
        this.itemPerRow = itemPerRow;
    }

    public Integer getMinRow() {
        return minRow;
    }

    public void setMinRow(Integer minRow) {
        this.minRow = minRow;
    }

}
