package com.am.a3dpernikguide.model.api.sights.museum;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class UserDataMuseum {
    @SerializedName("count_museum")
    @Expose
    @Nullable
    private Object countMuseum;
    @SerializedName("last_visit_museum")
    @Expose
    @Nullable
    private Object lastVisitMuseum;

    public Object getCountMuseum() {
        return countMuseum;
    }

    public void setCountMuseum(Object countMuseum) {
        this.countMuseum = countMuseum;
    }

    public Object getLastVisitMuseum() {
        return lastVisitMuseum;
    }

    public void setLastVisitMuseum(Object lastVisitMuseum) {
        this.lastVisitMuseum = lastVisitMuseum;
    }
}
