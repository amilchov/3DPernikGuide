package com.am.a3dpernikguide.model.api.sights.museum;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class UserDataMuseumVisited {
    @SerializedName("museum")
    @Expose
    @Nullable
    private UserDataMuseum museum;

    public UserDataMuseum getMuseum() {
        return museum;
    }

    public void setMuseum(UserDataMuseum museum) {
        this.museum = museum;
    }
}
