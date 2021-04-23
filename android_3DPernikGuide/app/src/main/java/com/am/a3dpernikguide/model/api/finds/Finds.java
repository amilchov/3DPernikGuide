package com.am.a3dpernikguide.model.api.finds;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class Finds {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("finds")
    @Expose
    private List<FindsData> finds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FindsData> getFinds() {
        return finds;
    }

    public void setFinds(List<FindsData> finds) {
        this.finds = finds;
    }
}
