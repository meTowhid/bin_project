
package com.nibri.binproject.model.milestone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("item_per_row")
    @Expose
    private String itemPerRow;

    public String getItemPerRow() {
        return itemPerRow;
    }

    public void setItemPerRow(String itemPerRow) {
        this.itemPerRow = itemPerRow;
    }

}
