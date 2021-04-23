package com.am.a3dpernikguide.model.api.sights.fortress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class UserDataFortressVisited {
    @SerializedName("fortress")
    @Expose
    private UserDataFortress fortress;

    public UserDataFortress getFortress() {
        return fortress;
    }

    public void setFortress(UserDataFortress fortress) {
        this.fortress = fortress;
    }
}
