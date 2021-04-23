package com.am.a3dpernikguide.model.api.sights.fortress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class AggregatedDataFortress {
    @SerializedName("total_count")
    @Expose
    private String totalCount;
    @SerializedName("last_visited")
    @Expose
    private String lastVisited;
    @SerializedName("users")
    @Expose
    private List<BarChatDataFortress> users = null;

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

    public List<BarChatDataFortress> getBarChartDataMuseum() {
        return users;
    }

    public void setBarChartDataMuseum(List<BarChatDataFortress> users) {
        this.users = users;
    }

}
