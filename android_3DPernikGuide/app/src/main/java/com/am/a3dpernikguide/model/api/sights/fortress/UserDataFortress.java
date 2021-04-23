package com.am.a3dpernikguide.model.api.sights.fortress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class UserDataFortress {

    @SerializedName("count_fortress")
    @Expose
    private Object countFortress;

    @SerializedName("last_visit_fortress")
    @Expose
    private Object lastVisitFortress;

    public Object getCountFortress() {
        return countFortress;
    }

    public void setCountFortress(Object countFortress) {
        this.countFortress = countFortress;
    }

    public Object getLastVisitFortress() {
        return lastVisitFortress;
    }

    public void setLastVisitFortress(Object lastVisitFortress) {
        this.lastVisitFortress = lastVisitFortress;
    }
}
