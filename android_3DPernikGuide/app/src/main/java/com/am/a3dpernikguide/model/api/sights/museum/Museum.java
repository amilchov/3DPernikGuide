package com.am.a3dpernikguide.model.api.sights.museum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class Museum {
    @SerializedName("museum")
    @Expose
    private AggregatedDataMuseum museum;

    public AggregatedDataMuseum getAggregatedDataMuseum() {
        return museum;
    }

    public void setAggregatedDataMuseum(AggregatedDataMuseum museum) {
        this.museum = museum;
    }
}

