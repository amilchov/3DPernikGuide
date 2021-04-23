package com.am.a3dpernikguide.model.api.sights.fortress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class Fortress {
    @SerializedName("fortress")
    @Expose
    private AggregatedDataFortress fortress;

    public AggregatedDataFortress getAggregatedDataFortress() {
        return fortress;
    }

    public void setAggregatedDataFortress(AggregatedDataFortress fortress) {
        this.fortress = fortress;
    }
}
