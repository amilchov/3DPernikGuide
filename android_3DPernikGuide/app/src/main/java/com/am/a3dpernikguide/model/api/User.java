package com.am.a3dpernikguide.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class User {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("count_fortress")
    @Expose
    private Object countFortress;
    @SerializedName("count_museum")
    @Expose
    private Object countMuseum;
    @SerializedName("last_visit_fortress")
    @Expose
    private Object lastVisitFortress;
    @SerializedName("last_visit_museum")
    @Expose
    private Object lastVisitMuseum;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getCountFortress() {
        return countFortress;
    }

    public void setCountFortress(Object countFortress) {
        this.countFortress = countFortress;
    }

    public Object getCountMuseum() {
        return countMuseum;
    }

    public void setCountMuseum(Object countMuseum) {
        this.countMuseum = countMuseum;
    }

    public Object getLastVisitFortress() {
        return lastVisitFortress;
    }

    public void setLastVisitFortress(Object lastVisitFortress) {
        this.lastVisitFortress = lastVisitFortress;
    }

    public Object getLastVisitMuseum() {
        return lastVisitMuseum;
    }

    public void setLastVisitMuseum(Object lastVisitMuseum) {
        this.lastVisitMuseum = lastVisitMuseum;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}
