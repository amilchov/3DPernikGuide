package com.am.a3dpernikguide.model.api.sights.museum;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class BarChartDataMuseum {
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
    @SerializedName("count_museum")
    @Expose
    private String countMuseum;
    @SerializedName("last_visit_museum")
    @Expose
    private String lastVisitMuseum;

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

    public String getCountMuseum() {
        return countMuseum;
    }

    public void setCountMuseum(String countMuseum) {
        this.countMuseum = countMuseum;
    }

    public String getLastVisitMuseum() {
        return lastVisitMuseum;
    }

    public void setLastVisitMuseum(String lastVisitMuseum) {
        this.lastVisitMuseum = lastVisitMuseum;
    }
}
