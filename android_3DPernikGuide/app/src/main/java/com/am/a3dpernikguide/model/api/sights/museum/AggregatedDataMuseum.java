package com.am.a3dpernikguide.model.api.sights.museum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class AggregatedDataMuseum {
    @SerializedName("total_count")
    @Expose
    private String totalCount;
    @SerializedName("last_visited")
    @Expose
    private String lastVisited;
    @SerializedName("users")
    @Expose
    private List<BarChartDataMuseum> users = null;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(String lastVisited) {
        this.lastVisited = lastVisited;
    }

    public List<BarChartDataMuseum> getBarChartDataMuseum() {
        return users;
    }

    public void setBarChartDataMuseum(List<BarChartDataMuseum> users) {
        this.users = users;
    }

}

