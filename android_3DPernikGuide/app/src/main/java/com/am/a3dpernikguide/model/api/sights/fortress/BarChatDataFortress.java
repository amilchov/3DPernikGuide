package com.am.a3dpernikguide.model.api.sights.fortress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class BarChatDataFortress {
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("count_fortress")
    @Expose
    private String countFortress;
    @SerializedName("last_visit_fortress")
    @Expose
    private String lastVisitFortress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountFortress() {
        return countFortress;
    }

    public void setCountFortress(String countFortress) {
        this.countFortress = countFortress;
    }

    public String getLastVisitFortress() {
        return lastVisitFortress;
    }

    public void setLastVisitFortress(String lastVisitFortress) {
        this.lastVisitFortress = lastVisitFortress;
    }

}
